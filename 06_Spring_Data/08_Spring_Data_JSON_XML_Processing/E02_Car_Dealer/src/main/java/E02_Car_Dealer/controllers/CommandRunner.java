package E02_Car_Dealer.controllers;

import E02_Car_Dealer.data.dtos.part.input.*;
import E02_Car_Dealer.data.dtos.supplier.input.*;
import E02_Car_Dealer.repositories.*;
import E02_Car_Dealer.services.interfaces.*;
import com.fasterxml.jackson.dataformat.xml.*;
import org.springframework.boot.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Component
public class CommandRunner implements CommandLineRunner {

    private static final String SUPPLIERS_IMPORT_PATH = "xml/import/suppliers.xml";
    private static final String PARTS_IMPORT_PATH = "xml/import/parts.xml";

    private final SupplierService supplierService;
    private final XmlMapper xmlMapper;
    private final PartsService partsService;
    private final PartsRepository partsRepository;

    public CommandRunner(SupplierService supplierService, XmlMapper xmlMapper, PartsService partsService, PartsRepository partsRepository) {
        this.supplierService = supplierService;
        this.xmlMapper = xmlMapper;
        this.partsService = partsService;
        this.partsRepository = partsRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (!supplierService.hasBeenImported()) {
            importSuppliers();
        }

        if (!partsService.hasBeenImported()) {
            importParts();
        }
    }

    private void importParts() {
        InputStream inputStream = readResourceFileAsInputStream(PARTS_IMPORT_PATH);
        try {
            ReadPartDTO wrapper = xmlMapper.readValue(inputStream, ReadPartDTO.class);
            List<ImportPartDTO> partDTOS = wrapper.getPartList();
            for (ImportPartDTO partDTO : partDTOS) {
                partsService.importPart(partDTO);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public void importSuppliers() {
        InputStream inputStream = readResourceFileAsInputStream(SUPPLIERS_IMPORT_PATH);
        try {
            ReadSupplierDTO wrapper = xmlMapper.readValue(inputStream, ReadSupplierDTO.class);
            List<ImportSupplierDTO> supplierDTOs = wrapper.getSuppliers();
            for (ImportSupplierDTO supplierDTO : supplierDTOs) {
                supplierService.importData(supplierDTO);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    private static InputStream readResourceFileAsInputStream(String path) {
        try {
            return new ClassPathResource(SUPPLIERS_IMPORT_PATH).getInputStream();
        } catch (IOException ioException) {
            throw new RuntimeException("Failed to load or parse file with path: " + path, ioException);
        }
    }
}
