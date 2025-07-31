package Volcano.service.impl;

import Volcano.repository.*;
import Volcano.service.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {


    private final VolcanologistRepository repository;

    public VolcanologistServiceImpl(VolcanologistRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return "";
    }

    @Override
    public String importVolcanologists() throws IOException {
        return "";
    }
}