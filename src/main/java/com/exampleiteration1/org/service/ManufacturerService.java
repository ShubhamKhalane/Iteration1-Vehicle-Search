package com.exampleiteration1.org.service;

import com.exampleiteration1.org.entity.Manufacturer;
import org.springframework.stereotype.Service;

@Service
public interface ManufacturerService {
    Manufacturer saveManufactorer(Manufacturer manufacturer);
}
