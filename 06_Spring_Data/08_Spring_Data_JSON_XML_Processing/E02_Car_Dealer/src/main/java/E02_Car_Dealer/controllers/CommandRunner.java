package E02_Car_Dealer.controllers;

import E02_Car_Dealer.data.dtos.supplier.input.*;
import E02_Car_Dealer.services.interfaces.*;
import com.fasterxml.jackson.dataformat.xml.*;
import org.springframework.boot.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

import java.io.*;

@Component
public class CommandRunner implements CommandLineRunner {

    private static final String SUPPLIERS_IMPORT_PATH = "xml/import/suppliers.xml";

    private final SupplierService supplierService;
    private final XmlMapper xmlMapper;

    public CommandRunner(SupplierService supplierService, XmlMapper xmlMapper) {
        this.supplierService = supplierService;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        //importSuppliers();

    }

    public void importSuppliers() {
        InputStream inputStream = readResourceFileAsInputStream(SUPPLIERS_IMPORT_PATH);
        try {
            ImportSupplierDTO supplierDTO = xmlMapper.readValue(inputStream, ImportSupplierDTO.class);
            supplierService.importData(supplierDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
