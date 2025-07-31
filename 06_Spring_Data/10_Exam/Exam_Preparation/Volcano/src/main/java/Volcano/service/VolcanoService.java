package Volcano.service;

import Volcano.models.entity.*;

import java.io.IOException;

public interface VolcanoService {

    boolean areImported();

    String readVolcanoesFileContent() throws IOException;

    String importVolcanoes() throws IOException;

    Volcano getReferenceById(Long volcanoId);

    void addAndSaveAddedVolcano(Volcano volcano, Volcanologist volcanologist);

    String exportVolcanoes();
}
