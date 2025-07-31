package Volcano.service;


import jakarta.xml.bind.*;

import java.io.IOException;


public interface VolcanologistService {

    boolean areImported();

    String readVolcanologistsFromFile() throws IOException;

	String importVolcanologists() throws IOException, JAXBException;

}
