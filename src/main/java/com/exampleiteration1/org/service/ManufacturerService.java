package com.exampleiteration1.org.service;

import com.exampleiteration1.org.entity.Manufacturer;
import com.exampleiteration1.org.exception.ManufacturerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManufacturerService {
    Manufacturer saveManufactorer(Manufacturer manufacturer);
    List<Manufacturer> fetchAll();
    Manufacturer getManufacturerById(int id);
    void deleteManufacturer(int id) throws ManufacturerNotFoundException;
}
