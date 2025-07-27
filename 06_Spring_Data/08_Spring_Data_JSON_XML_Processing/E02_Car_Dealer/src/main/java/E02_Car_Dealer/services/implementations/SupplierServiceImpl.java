package E02_Car_Dealer.services.implementations;

import E02_Car_Dealer.data.dtos.supplier.*;
import E02_Car_Dealer.data.dtos.supplier.export.*;
import E02_Car_Dealer.data.dtos.supplier.input.*;
import E02_Car_Dealer.data.entities.*;
import E02_Car_Dealer.repositories.*;
import E02_Car_Dealer.services.interfaces.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SuppliersRepository repository;
    private final ModelMapper modelMapper;


    public SupplierServiceImpl(SuppliersRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Supplier getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public SupplierDTO importSupplierData(ImportSupplierDTO supplierDTO) {
        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
        repository.saveAndFlush(supplier);
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    @Override
    public List<ExportSupplierProductsDTO> exportSuppliers(boolean isImporter) {
        return repository.exportSuppliers(isImporter);
    }

    @Override
    public boolean hasBeenImported() {
        return repository.count() > 0;
    }
}
