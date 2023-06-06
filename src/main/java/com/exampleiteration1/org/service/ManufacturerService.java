package com.exampleiteration1.org.service;

import com.exampleiteration1.org.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManufacturerService {
    Manufacturer saveManufactorer(Manufacturer manufacturer);
    List<Manufacturer> fetchAll();
}
