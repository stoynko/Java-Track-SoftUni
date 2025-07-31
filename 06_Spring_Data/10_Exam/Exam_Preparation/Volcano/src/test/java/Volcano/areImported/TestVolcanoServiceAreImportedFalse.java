package Volcano.areImported;
//TestVolcanoServiceAreImportedFalse

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
public class TestVolcanoServiceAreImportedFalse {

    @InjectMocks
    private VolcanoServiceImpl volcanoService;
    @Mock
    private VolcanoRepository mockVolcanoRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockVolcanoRepository.count()).thenReturn(0L);
        Assertions.assertFalse(volcanoService.areImported());
    }
}