package E02_Car_Dealer.services.implementations;

import E02_Car_Dealer.data.dtos.part.*;
import E02_Car_Dealer.data.dtos.part.input.*;
import E02_Car_Dealer.data.entities.*;
import E02_Car_Dealer.repositories.*;
import E02_Car_Dealer.services.interfaces.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
public class PartsServiceImpl implements PartsService {

    private final SupplierService supplierService;
    private final PartsRepository partsRepository;
    private final ModelMapper modelMapper;

    public PartsServiceImpl(PartsRepository partsRepository, ModelMapper modelMapper, SupplierService supplierService) {
        this.partsRepository = partsRepository;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
    }

    @Override
    @Transactional
    public PartDTO importPartData(ImportPartDTO partDTO, PartRelationsDTO relationsDTO) {
        Part part = modelMapper.map(partDTO, Part.class);
        Supplier supplier = supplierService.getReferenceById(relationsDTO.getSupplierId());
        part.setSupplier(supplier);
        partsRepository.saveAndFlush(part);
        return modelMapper.map(part, PartDTO.class);
    }

    @Override
    public boolean hasBeenImported() {
        return partsRepository.count() > 0;
    }
}
