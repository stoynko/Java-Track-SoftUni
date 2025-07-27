package E02_Car_Dealer.services.implementations;

import E02_Car_Dealer.data.dtos.car.*;
import E02_Car_Dealer.data.dtos.car.export.*;
import E02_Car_Dealer.data.dtos.car.input.*;
import E02_Car_Dealer.data.entities.*;
import E02_Car_Dealer.repositories.*;
import E02_Car_Dealer.services.interfaces.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final PartsService partsService;
    private final CarRepository repository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository repository, ModelMapper modelMapper, PartsService partsService) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.partsService = partsService;
    }

    @Override
    public CarDTO importCarData(ImportCarDTO carDTO, CarRelationsDTO relationsDTO) {
        Car car = modelMapper.map(carDTO, Car.class);
        List<Part> parts = new ArrayList<>();
        for (Long partID : relationsDTO.getPartIDs()) {
            Part part = partsService.getReferenceById(partID);
            parts.add(part);
        }
        car.setPartsList(parts);
        repository.saveAndFlush(car);
        return modelMapper.map(car, CarDTO.class);
    }

    @Override
    public boolean hasBeenImported() {
        return repository.count() > 0;
    }

    @Override
    public List<ExportCarDTO> exportCarData() {
        List<Car> cars = repository.findAllCarsWithParts();

        return cars.stream().map(car -> {
            ExportCarDTO carDTO = modelMapper.map(car, ExportCarDTO.class);
            return carDTO;
        }).toList();
    }
}
