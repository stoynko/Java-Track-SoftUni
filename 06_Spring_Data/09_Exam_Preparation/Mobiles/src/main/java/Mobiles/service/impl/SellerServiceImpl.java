package Mobiles.service.impl;

import Mobiles.data.dto.seller.*;
import Mobiles.data.entities.*;
import Mobiles.repository.*;
import Mobiles.service.*;
import Mobiles.util.*;
import com.google.gson.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.nio.file.*;

@Service
public class SellerServiceImpl implements SellerService {

    public static final String IMPORT_SELLERS_PATH = "src/main/resources/files/json/sellers.json";

    private final SellerRepository repository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;

    public SellerServiceImpl(SellerRepository sellerRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validator) {
        this.repository = sellerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        Path path = Path.of(IMPORT_SELLERS_PATH);
        return Files.readString(path);
    }

    @Override
    public String importSellers() throws IOException {
        StringBuilder output = new StringBuilder();
        ImportSellerDTO[] sellerDTOs = gson.fromJson(readSellersFromFile(), ImportSellerDTO[].class);
        for (ImportSellerDTO sellerDTO : sellerDTOs) {
            Seller seller = createSeller(sellerDTO);
            if (seller != null) {
                output.append(String.format("Successfully imported seller %s %s", seller.getFirstName(), seller.getLastName()));
            } else {
                output.append("Invalid seller");
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    private Seller createSeller(ImportSellerDTO sellerDTO) {
        if (!validator.isValid(sellerDTO)) {
            return null;
        }
        try {
            Seller seller = modelMapper.map(sellerDTO, Seller.class);
            repository.saveAndFlush(seller);
            return seller;
        } catch (Exception e) {
            return null;
        }
    }
}
