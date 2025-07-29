package Mobiles.service.impl;

import Mobiles.data.dto.sale.*;
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
public class SaleServiceImpl implements SaleService {

    public static final String IMPORT_SALES_PATH = "src/main/resources/files/json/sales.json";
    private final SaleRepository repository;
    private final SellerService sellerService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;

    public SaleServiceImpl(SaleRepository repository, SellerService sellerService, Gson gson, ModelMapper modelMapper, ValidationUtil validator) {
        this.repository = repository;
        this.sellerService = sellerService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        Path path = Path.of(IMPORT_SALES_PATH);
        return Files.readString(path);
    }

    @Override
    public String importSales() throws IOException {
        StringBuilder output = new StringBuilder();
        ImportSaleDTO[] saleDTOs = gson.fromJson(readSalesFileContent(), ImportSaleDTO[].class);
        for (ImportSaleDTO saleDTO : saleDTOs) {
            Sale sale = createSale(saleDTO);
            if (sale != null) {
                output.append(String.format("Successfully imported sale with number %s", sale.getNumber()));
            } else {
                output.append("Invalid sale");
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    private Sale createSale(ImportSaleDTO saleDTO) {
        if (!validator.isValid(saleDTO)) {
            return null;
        }

        try {
            Sale sale = modelMapper.map(saleDTO, Sale.class);
            repository.saveAndFlush(sale);
            return sale;
        } catch (Exception e) {
            return null;
        }
    }


}
