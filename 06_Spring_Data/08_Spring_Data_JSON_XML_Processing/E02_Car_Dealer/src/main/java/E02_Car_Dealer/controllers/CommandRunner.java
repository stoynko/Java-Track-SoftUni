package E02_Car_Dealer.controllers;

import E02_Car_Dealer.data.dtos.car.*;
import E02_Car_Dealer.data.dtos.car.export.*;
import E02_Car_Dealer.data.dtos.car.input.*;
import E02_Car_Dealer.data.dtos.part.*;
import E02_Car_Dealer.data.dtos.part.input.*;
import E02_Car_Dealer.data.dtos.supplier.*;
import E02_Car_Dealer.data.dtos.supplier.export.*;
import E02_Car_Dealer.data.dtos.supplier.input.*;
import E02_Car_Dealer.services.interfaces.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.*;
import org.hibernate.validator.internal.constraintvalidators.hv.*;
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
    private static final String CARS_IMPORT_PATH = "xml/import/cars.xml";

    private static final String EXPORT_PATH = "src/main/resources/xml/export/";

    private final SupplierService supplierService;
    private final PartsService partsService;
    private final CarService carService;
    private final XmlMapper xmlMapper;

    public CommandRunner(SupplierService supplierService, XmlMapper xmlMapper, PartsService partsService, CarService carService) {
        this.supplierService = supplierService;
        this.xmlMapper = xmlMapper;
        this.partsService = partsService;
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws IOException {

        List<SupplierDTO> suppliers = new ArrayList<>();
        List<PartDTO> parts = new ArrayList<>();

        if (!supplierService.hasBeenImported()) {
            suppliers = importSuppliers();
        }

        if (!partsService.hasBeenImported()) {
            parts = importParts(suppliers);
        }

        if (!carService.hasBeenImported()) {
            importCars(parts);
        }

        /* Get all suppliers that do not import parts from abroad. Get their id, name and the number of parts they can offer to supply.
          Export the list of suppliers to XML in the format provided below. */
        //exportSuppliers("local-suppliers", false);

        /* Get all cars along with their list of parts. For the car get only make, model and traveled distance and for the parts get only name and price.
        Export the list of cars and their parts to XML in the format provided below. */
        exportCars("cars-and-parts");
    }

    public List<SupplierDTO> importSuppliers() {
        InputStream inputStream = readResourceFileAsInputStream(SUPPLIERS_IMPORT_PATH);
        List<SupplierDTO> allSuppliers = new ArrayList<>();
        try {
            ReadSupplierDTO wrapper = xmlMapper.readValue(inputStream, ReadSupplierDTO.class);
            List<ImportSupplierDTO> supplierImportDTOs = wrapper.getSuppliers();
            for (ImportSupplierDTO supplierDTO : supplierImportDTOs) {
                SupplierDTO supplier = supplierService.importSupplierData(supplierDTO);
                allSuppliers.add(supplier);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        return allSuppliers;
    }

    private List<PartDTO> importParts(List<SupplierDTO> suppliers) {
        InputStream inputStream = readResourceFileAsInputStream(PARTS_IMPORT_PATH);
        List<PartDTO> allParts = new ArrayList<>();
        try {
            ReadPartDTO wrapper = xmlMapper.readValue(inputStream, ReadPartDTO.class);
            List<ImportPartDTO> partDTOS = wrapper.getPartList();
            for (ImportPartDTO partDTO : partDTOS) {
                Long randomSupplierID = ThreadLocalRandom.current().nextLong(1, suppliers.size());
                PartRelationsDTO partRelationDTO = new PartRelationsDTO(randomSupplierID);
                PartDTO part = partsService.importPartData(partDTO, partRelationDTO);
                allParts.add(part);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        return allParts;
    }

    private void importCars(List<PartDTO> parts) {
        InputStream inputStream = readResourceFileAsInputStream(CARS_IMPORT_PATH);
        try {
            ReadCarDTO wrapper = xmlMapper.readValue(inputStream, ReadCarDTO.class);
            List<ImportCarDTO> carDTOs = wrapper.getCars();

            for (ImportCarDTO carDTO : carDTOs) {
                List<Long> partIDs = new ArrayList<>();
                int randomPartsCount = ThreadLocalRandom.current().nextInt(10,21);
                for (int i = 0; i < randomPartsCount; i++) {
                    Long randomPartId = ThreadLocalRandom.current().nextLong(1, parts.size());
                    partIDs.add(randomPartId);
                }
                CarRelationsDTO carRelationsDTO = new CarRelationsDTO(partIDs);
                carService.importCarData(carDTO, carRelationsDTO);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    private void exportSuppliers(String fileName, boolean isImporter) throws IOException {
        List<ExportSupplierProductsDTO> suppliersReport = supplierService.exportSuppliers(false);
        ExportSupplierDTO exportDTO = new ExportSupplierDTO();
        exportDTO.setSuppliersList(suppliersReport);
        xmlMapper.writer().writeValue(System.out, exportDTO);
    }

    private void exportCars(String fileName) throws IOException {
        List<ExportCarDTO> carsList = carService.exportCarData();
        ExportCarsDTO carsDTO = new ExportCarsDTO(carsList);

        xmlMapper.writer().writeValue(System.out, carsDTO);
    }

    private static InputStream readResourceFileAsInputStream(String path) {
        try {
            return new ClassPathResource(path).getInputStream();
        } catch (IOException ioException) {
            throw new RuntimeException("Failed to load or parse file with path: " + path, ioException);
        }
    }
}
