package E02_Car_Dealer.controllers;

import E02_Car_Dealer.data.dtos.part.*;
import E02_Car_Dealer.data.dtos.part.input.*;
import E02_Car_Dealer.data.dtos.supplier.*;
import E02_Car_Dealer.data.dtos.supplier.input.*;
import E02_Car_Dealer.services.interfaces.*;
import com.fasterxml.jackson.dataformat.xml.*;
import org.springframework.boot.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

@Component
public class CommandRunner implements CommandLineRunner {

    private static final String SUPPLIERS_IMPORT_PATH = "xml/import/suppliers.xml";
    private static final String PARTS_IMPORT_PATH = "xml/import/parts.xml";

    private final SupplierService supplierService;
    private final PartsService partsService;
    private final XmlMapper xmlMapper;

    public CommandRunner(SupplierService supplierService, XmlMapper xmlMapper, PartsService partsService) {
        this.supplierService = supplierService;
        this.xmlMapper = xmlMapper;
        this.partsService = partsService;

    }

    @Override
    public void run(String... args) {

        List<SupplierDTO> suppliers = new ArrayList<>();
        //List<PartDTO> parts = new ArrayList<>();

        if (!supplierService.hasBeenImported()) {
            suppliers = importSuppliers();
        }

        if (!partsService.hasBeenImported()) {
            importParts(suppliers);
        }
    }

    private void importParts(List<SupplierDTO> suppliers) {
        InputStream inputStream = readResourceFileAsInputStream(PARTS_IMPORT_PATH);
        try {
            ReadPartDTO wrapper = xmlMapper.readValue(inputStream, ReadPartDTO.class);
            List<ImportPartDTO> partDTOS = wrapper.getPartList();
            for (ImportPartDTO partDTO : partDTOS) {
                Long randomSupplierID = ThreadLocalRandom.current().nextLong(1, suppliers.size());
                PartRelationsDTO partRelationDTO = new PartRelationsDTO(randomSupplierID);
                partsService.importPart(partDTO, partRelationDTO);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        //return partsDTOs;
    }

    public List<SupplierDTO> importSuppliers() {
        InputStream inputStream = readResourceFileAsInputStream(SUPPLIERS_IMPORT_PATH);
        List<SupplierDTO> supplierDTOs = new ArrayList<>();
        try {
            ReadSupplierDTO wrapper = xmlMapper.readValue(inputStream, ReadSupplierDTO.class);
            List<ImportSupplierDTO> supplierImportDTOs = wrapper.getSuppliers();
            for (ImportSupplierDTO supplierDTO : supplierImportDTOs) {
                SupplierDTO supplier = supplierService.importData(supplierDTO);
                supplierDTOs.add(supplier);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        return supplierDTOs;
    }

    private static InputStream readResourceFileAsInputStream(String path) {
        try {
            return new ClassPathResource(path).getInputStream();
        } catch (IOException ioException) {
            throw new RuntimeException("Failed to load or parse file with path: " + path, ioException);
        }
    }

}
