package com.exampleiteration1.org.service;

import com.exampleiteration1.org.dao.ManufacturerDAO;
import com.exampleiteration1.org.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImplementation implements ManufacturerService {
    @Autowired
    ManufacturerDAO manufacturerDAO;
    @Override
    public Manufacturer saveManufactorer(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }

    @Override
    public List<Manufacturer> fetchAll() {
        List<Manufacturer> mandb = manufacturerDAO.findAll();
        return  mandb;
    }
}
