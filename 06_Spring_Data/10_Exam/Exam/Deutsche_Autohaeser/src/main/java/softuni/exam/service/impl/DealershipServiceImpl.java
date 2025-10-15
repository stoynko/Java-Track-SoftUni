package softuni.exam.service.impl;

import com.google.gson.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;
import softuni.exam.models.dto.*;
import softuni.exam.models.entity.*;
import softuni.exam.repository.*;
import softuni.exam.service.*;
import softuni.exam.util.*;

import java.io.*;
import java.nio.file.*;

@Service
public class DealershipServiceImpl implements DealershipService {

    private final String IMPORT_DEALERSHIP_PATH = "src/main/resources/files/json/dealerships.json";

    private final DealershipRepository repository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;

    public DealershipServiceImpl(DealershipRepository repository, Gson gson, ModelMapper modelMapper, ValidationUtil validator) {
        this.repository = repository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readDealershipsFromFile() throws IOException {
        Path path = Path.of(IMPORT_DEALERSHIP_PATH);
        return Files.readString(path);
    }

    @Override
    public String importDealerships() throws IOException {
        StringBuilder output = new StringBuilder();
        ImportDealershipDTO[] dealershipDTOs = gson.fromJson(readDealershipsFromFile(), ImportDealershipDTO[].class);
        for (ImportDealershipDTO dealershipDTO : dealershipDTOs) {
            Dealership dealership = createEntity(dealershipDTO);
            if (dealership != null) {
                output.append(String.format("Successfully imported dealership %s", dealership.getName()));
            } else {
                output.append("Invalid dealership");
            }
            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }

    @Override
    public Dealership getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    private Dealership createEntity(ImportDealershipDTO dealershipDTO) {
        try {
            if (!validator.isValid(dealershipDTO)) {
                throw new InvalidObjectException("Invalid DTO");
            }
            Dealership dealership = modelMapper.map(dealershipDTO, Dealership.class);
            repository.save(dealership);
            return dealership;

        } catch (Exception e) {
            return null;
        }
    }
}
