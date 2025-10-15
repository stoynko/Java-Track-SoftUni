package softuni.exam.service.impl;

import com.fasterxml.jackson.dataformat.xml.*;
import com.google.gson.*;
import jakarta.xml.bind.*;
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
public class DealerServiceImpl implements DealerService {

    private final String IMPORT_DEALERS_PATH = "src/main/resources/files/xml/dealers.xml";

    private final DealerRepository repository;
    private final CarService carService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final XmlMapper xmlMapper;

    public DealerServiceImpl(DealerRepository repository, CarService carService, Gson gson, ModelMapper modelMapper, ValidationUtil validator, XmlMapper xmlMapper) {
        this.repository = repository;
        this.carService = carService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readDealersFromFile() throws IOException {
        Path path = Path.of(IMPORT_DEALERS_PATH);
        return Files.readString(path);
    }

    @Override
    public String importDealers() throws IOException, JAXBException {

        StringBuilder ouput = new StringBuilder();
        ImportDealersDTO dealerDTOs = xmlMapper.readValue(readDealersFromFile(), ImportDealersDTO.class);

        for (ImportDealerDTO dealerDTO : dealerDTOs.getDealers()) {
            Dealer dealer = createEntity(dealerDTO);
            if (dealer != null) {
                ouput.append(String.format("Successfully imported dealer %s %s", dealer.getFirstName(), dealer.getLastName()));
            } else {
                ouput.append("Invalid dealer");
            }
            ouput.append(System.lineSeparator());
        }
        return ouput.toString();
    }

/*    @Override
    public String importDealers() throws JAXBException, IOException {
        StringBuilder output = new StringBuilder();
        ImportDealersDTO dealerDTOs = xmlMapper.readValue(readDealersFromFile(), ImportDealersDTO.class);

        for (ImportDealerDTO dealerDTO : dealerDTOs.getDealers()) {
            if (repository.existsByFirstNameAndLastName(dealerDTO.getFirstName(), dealerDTO.getLastName())
                    || !carService.existsById(dealerDTO.getOfferingCar()) || !validator.isValid(dealerDTO)) {
                output.append("Invalid dealer");
                output.append(System.lineSeparator());
                continue;
            }

            Dealer dealer = modelMapper.map(dealerDTO, Dealer.class);
            dealer.setOfferingCar(carService.getReferenceById(dealerDTO.getOfferingCar()));
            repository.saveAndFlush(dealer);

            output.append(String.format("Successfully imported dealer %s %s", dealer.getFirstName(), dealer.getLastName()));
            output.append(System.lineSeparator());
        }

        return output.toString();
    }*/

    private Dealer createEntity(ImportDealerDTO dealerDTO) {
        try {
            if (!validator.isValid(dealerDTO)) {
                throw new InvalidObjectException("Invalid DTO");
            }
            Dealer dealer = modelMapper.map(dealerDTO, Dealer.class);
            Car car = carService.getReferenceById(dealerDTO.getOfferingCar());
            dealer.setOfferingCar(car);
            repository.save(dealer);
            return dealer;

        } catch (Exception e) {
            return null;
        }
    }
}
