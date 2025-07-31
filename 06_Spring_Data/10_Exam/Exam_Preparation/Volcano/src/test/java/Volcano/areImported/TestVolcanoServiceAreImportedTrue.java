package Volcano.areImported;
//TestVolcanoServiceAreImportedTrue

import Volcano.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import Volcano.service.impl.*;

@ExtendWith(MockitoExtension.class)
public class TestVolcanoServiceAreImportedTrue {

    @InjectMocks
    private VolcanoServiceImpl volcanoService;
    @Mock
    private VolcanoRepository mockVolcanoRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockVolcanoRepository.count()).thenReturn(1L);
        Assertions.assertTrue(volcanoService.areImported());
    }
}