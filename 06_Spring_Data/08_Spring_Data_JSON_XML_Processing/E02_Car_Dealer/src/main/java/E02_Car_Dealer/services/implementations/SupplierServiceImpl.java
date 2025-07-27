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

    private final SuppliersRepository suppliersRepository;
    private final ModelMapper modelMapper;


    public SupplierServiceImpl(SuppliersRepository suppliersRepository, ModelMapper modelMapper) {
        this.suppliersRepository = suppliersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Supplier getReferenceById(Long id) {
        return suppliersRepository.getReferenceById(id);
    }

    @Override
    public SupplierDTO importSupplierData(ImportSupplierDTO supplierDTO) {
        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
        suppliersRepository.saveAndFlush(supplier);
        return modelMapper.map(supplier, SupplierDTO.class);
    }

    @Override
    public List<ExportSupplierProductsDTO> exportSuppliers(boolean isImporter) {
        return suppliersRepository.exportSuppliers(isImporter);
    }

    @Override
    public boolean hasBeenImported() {
        return suppliersRepository.count() > 0;
    }
}
