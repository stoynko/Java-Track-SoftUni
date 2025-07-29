package Mobiles.service.impl;

import Mobiles.repository.*;
import Mobiles.service.*;
import jakarta.xml.bind.*;
import org.springframework.stereotype.*;
import java.io.*;
import java.nio.file.*;

@Service
public class DeviceServiceImpl implements DeviceService {

    public static final String IMPORT_DEVICES_PATH = "src/main/resources/files/xml/devices.xml";

    private final DeviceRepository repository;

    public DeviceServiceImpl(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        Path path = Path.of(IMPORT_DEVICES_PATH);
        return Files.readString(path);
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        return "";
    }

    @Override
    public String exportDevices() {
        return "";
    }
}
