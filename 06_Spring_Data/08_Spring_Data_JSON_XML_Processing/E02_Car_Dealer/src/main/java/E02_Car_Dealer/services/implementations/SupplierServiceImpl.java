package E02_Car_Dealer.services.implementations;

import E02_Car_Dealer.data.dtos.supplier.*;
import E02_Car_Dealer.data.dtos.supplier.input.*;
import E02_Car_Dealer.data.entities.*;
import E02_Car_Dealer.repositories.*;
import E02_Car_Dealer.services.interfaces.*;
import E02_Car_Dealer.services.utilities.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.*;
import org.modelmapper.*;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SuppliersRepository suppliersRepository;

    private final ModelMapper modelMapper;
    private final XmlMapper xmlMapper;
    private final ObjectMapper objectMapper;


    public SupplierServiceImpl(SuppliersRepository suppliersRepository, ModelMapper modelMapper, XmlMapper xmlMapper,ObjectMapper objectMapper) {
        this.suppliersRepository = suppliersRepository;
        this.modelMapper = modelMapper;
        this.xmlMapper = xmlMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public SupplierDTO importData(ImportSupplierDTO supplierDTO) {
        Supplier supplier = modelMapper.map(supplierDTO, Supplier.class);
        suppliersRepository.saveAndFlush(supplier);
        return modelMapper.map(supplier, SupplierDTO.class);
    }
}
