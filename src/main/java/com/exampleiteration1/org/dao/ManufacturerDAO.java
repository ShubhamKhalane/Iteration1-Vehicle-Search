package com.exampleiteration1.org.dao;

import com.exampleiteration1.org.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerDAO extends JpaRepository<Manufacturer,Integer> {
}
