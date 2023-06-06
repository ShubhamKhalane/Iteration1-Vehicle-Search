package com.exampleiteration1.org.service;

import com.exampleiteration1.org.dao.ManufacturerDAO;
import com.exampleiteration1.org.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Manufacturer getManufacturerById(int id) {
        Optional<Manufacturer> mandb = manufacturerDAO.findById(id);
        if(mandb.isPresent()){
            return mandb.get();
        }
        return null;
    }
}
