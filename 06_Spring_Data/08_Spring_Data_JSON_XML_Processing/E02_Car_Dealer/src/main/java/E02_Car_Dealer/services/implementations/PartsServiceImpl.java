package E02_Car_Dealer.services.implementations;

import E02_Car_Dealer.data.dtos.part.*;
import E02_Car_Dealer.data.dtos.part.input.*;
import E02_Car_Dealer.data.entities.*;
import E02_Car_Dealer.repositories.*;
import E02_Car_Dealer.services.interfaces.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;

@Service
public class PartsServiceImpl implements PartsService {


    private final PartsRepository partsRepository;
    private final ModelMapper modelMapper;


    public PartsServiceImpl(PartsRepository partsRepository, ModelMapper modelMapper) {
        this.partsRepository = partsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PartDTO importPart(ImportPartDTO partDTO) {
        Part part = modelMapper.map(partDTO, Part.class);
        partsRepository.saveAndFlush(part);
        return modelMapper.map(part, PartDTO.class);
    }

    @Override
    public boolean hasBeenImported() {
        return partsRepository.count() > 0;
    }
}
