package Volcano.areImported;
//TestCountryServiceAreImportedFalse

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
public class TestCountryServiceAreImportedFalse {

    @InjectMocks
    private CountryServiceImpl countryService;
    @Mock
    private CountryRepository mockCountryRepository;

    @Test
    void areImportedShouldReturnFalse() {
        Mockito.when(mockCountryRepository.count()).thenReturn(0L);
        Assertions.assertFalse(countryService.areImported());
    }
}