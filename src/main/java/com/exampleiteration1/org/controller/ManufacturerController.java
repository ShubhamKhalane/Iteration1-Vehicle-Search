package com.exampleiteration1.org.controller;

import com.exampleiteration1.org.entity.Manufacturer;
import com.exampleiteration1.org.exception.ManufacturerNotFoundException;
import com.exampleiteration1.org.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/manufacturer")
public class ManufacturerController {
    @Autowired
    ManufacturerService manufacturerService;
    @PostMapping
    ResponseEntity<Manufacturer> saveManufacturer(@RequestBody Manufacturer manufacturer){
        Manufacturer dbsaveman = manufacturerService.saveManufactorer(manufacturer);
        return new ResponseEntity<>(dbsaveman, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturer(){
        List<Manufacturer> man = manufacturerService.fetchAll();
        return ResponseEntity.status(HttpStatus.OK).body(man);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManById(@PathVariable int id) throws ManufacturerNotFoundException {
        Manufacturer mandb = manufacturerService.getManufacturerById(id);
        if(mandb==null){
            throw new ManufacturerNotFoundException("Manufacturer with not present with id"+id);
        }
        return ResponseEntity.ok(mandb);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteManById(int id) throws ManufacturerNotFoundException {
        manufacturerService.deleteManufacturer(id);
        return new ResponseEntity<>("Manufacturer Deleted From Id "+id,HttpStatus.OK);
    }
}
