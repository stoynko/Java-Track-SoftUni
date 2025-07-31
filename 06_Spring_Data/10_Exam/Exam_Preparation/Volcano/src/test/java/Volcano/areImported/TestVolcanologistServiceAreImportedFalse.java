package Volcano.areImported;
//TestVolcanologistServiceAreImportedFalse

import Volcano.repository.*;
import Volcano.service.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TestVolcanologistServiceAreImportedFalse {


    @InjectMocks
    private VolcanologistServiceImpl astronomerService;
    @Mock
    private VolcanologistRepository mockVolcanologistRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockVolcanologistRepository.count()).thenReturn(0L);
        Assertions.assertFalse(astronomerService.areImported());
    }
}