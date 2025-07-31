package Volcano.service;

import Volcano.models.entity.*;
import java.io.IOException;
import java.util.Optional;


public interface CountryService {

    boolean areImported();

    String readCountriesFromFile() throws IOException;

    String importCountries() throws IOException;

    Optional<Country> getReferenceById(Long countryId);

    void saveAddedVolcanoInCountry(Country country);
}
