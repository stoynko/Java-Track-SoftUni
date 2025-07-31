package Volcano.service.impl;

import Volcano.models.entity.*;
import Volcano.repository.*;
import Volcano.service.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Service
public class CountryServiceImpl implements CountryService {


    private final CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return "";
    }

    @Override
    public String importCountries() throws IOException {
        return "";
    }

    @Override
    public Optional<Country> getReferenceById(Long countryId) {
        return Optional.empty();
    }

    @Override
    public void saveAddedVolcanoInCountry(Country country) {

    }
}
