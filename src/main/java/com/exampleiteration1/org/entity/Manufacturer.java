package com.exampleiteration1.org.entity;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manufacturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Manufacturer Name Is Required")
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
}
