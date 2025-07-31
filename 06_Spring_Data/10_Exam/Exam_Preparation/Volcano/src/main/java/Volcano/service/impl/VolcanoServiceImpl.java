package Volcano.service.impl;

import Volcano.models.entity.*;
import Volcano.repository.*;
import Volcano.service.*;
import org.springframework.stereotype.*;

import java.io.*;

@Service
public class VolcanoServiceImpl implements VolcanoService {


    private final VolcanoRepository repository;

    public VolcanoServiceImpl(VolcanoRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return "";
    }

    @Override
    public String importVolcanoes() throws IOException {
        return "";
    }

    @Override
    public Volcano getReferenceById(Long volcanoId) {
        return null;
    }

    @Override
    public void addAndSaveAddedVolcano(Volcano volcano, Volcanologist volcanologist) {

    }

    @Override
    public String exportVolcanoes() {
        return "";
    }
}