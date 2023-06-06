package com.exampleiteration1.org.service;

import com.exampleiteration1.org.dao.ManufacturerDAO;
import com.exampleiteration1.org.entity.Manufacturer;
import com.exampleiteration1.org.exception.ManufacturerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.apache.logging.log4j.util.StringBuilders.equalsIgnoreCase;

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

    @Override
    public Manufacturer updateManufacturer(int id, Manufacturer manufacturer) {
        Manufacturer mandb= getManufacturerById(id);
        if(mandb!=null && Objects.nonNull(manufacturer)){
            if(Objects.nonNull(manufacturer.getManufacturerName())&& !"".equalsIgnoreCase(manufacturer.getManufacturerName())){
                mandb.setManufacturerName(manufacturer.getManufacturerName());
            }
            if(Objects.nonNull(manufacturer.getCountryOfOrigin())&& !"".equalsIgnoreCase(manufacturer.getCountryOfOrigin())){
                mandb.setCountryOfOrigin(manufacturer.getCountryOfOrigin());
            }
            return(manufacturerDAO.save(mandb));
        }return mandb;

    }

    @Override
    public void deleteManufacturerById(int id) throws ManufacturerNotFoundException {
        Manufacturer manufacturer = getManufacturerById(id);
        if(manufacturer==null){
            throw new ManufacturerNotFoundException("Manufacturer not found with id "+id);

        }manufacturerDAO.deleteById(id);
    }
}
