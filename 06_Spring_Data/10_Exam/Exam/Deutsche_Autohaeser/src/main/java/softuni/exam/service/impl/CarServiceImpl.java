package softuni.exam.service.impl;

import com.google.gson.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;
import softuni.exam.models.dto.*;
import softuni.exam.models.entity.*;
import softuni.exam.models.entity.enums.*;
import softuni.exam.repository.*;
import softuni.exam.service.*;
import softuni.exam.util.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final String IMPORT_CAR_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository repository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;
    private final DealershipService dealershipService;

    public CarServiceImpl(CarRepository repository, Gson gson, ModelMapper modelMapper, ValidationUtil validator, DealershipService dealershipService) {
        this.repository = repository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.dealershipService = dealershipService;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        Path path = Path.of(IMPORT_CAR_PATH);
        return Files.readString(path);
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder output = new StringBuilder();
        ImportCarDTO[] carDTOs = gson.fromJson(readCarsFileContent(), ImportCarDTO[].class);
        for (ImportCarDTO carDTO : carDTOs) {
            Car car = createEntity(carDTO);
            if (car != null) {
                output.append(String.format("Successfully imported car %s - %d km.", car.getBrand(), car.getMileage()));
            } else {
                output.append("Invalid car");
            }
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    @Override
    public String exportCars() {
        StringBuilder output = new StringBuilder();
        List<Car> cars = repository.getCarByType(CarType.COMBI, 100000);

        for (Car car : cars) {
            output.append(String.format("Brand: %s", car.getBrand()));
            output.append(System.lineSeparator());
            output.append(String.format("   *Mileage: %d km.", car.getMileage()));
            output.append(System.lineSeparator());
            output.append(String.format("   **Model: %s", car.getModel()));
            output.append(System.lineSeparator());
            output.append(String.format("   ***Dealership: %s", car.getDealership().getName()));
            output.append(System.lineSeparator());
        }
        System.out.println();
        return output.toString();
    }

    @Override
    public Car getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }

    private Car createEntity(ImportCarDTO carDTO) {
        try {
            if (!validator.isValid(carDTO)) {
                throw new InvalidObjectException("Invalid DTO");
            }
            Car car = modelMapper.map(carDTO, Car.class);
            Dealership dealership = dealershipService.getReferenceById(carDTO.getDealership());
            car.setDealership(dealership);
            repository.save(car);
            return car;

        } catch (Exception e) {
            return null;
        }
    }
}
