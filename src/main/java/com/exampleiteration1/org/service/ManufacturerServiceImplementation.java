package com.exampleiteration1.org.service;

import com.exampleiteration1.org.dao.ManufacturerDAO;
import com.exampleiteration1.org.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImplementation implements ManufacturerService {
    @Autowired
    ManufacturerDAO manufacturerDAO;
    @Override
    public Manufacturer saveManufactorer(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }
}
