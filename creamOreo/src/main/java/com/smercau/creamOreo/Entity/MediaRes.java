package com.smercau.creamOreo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class MediaRes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long codbar;

    private int Tropa;

    private String camara;

    private Double pesoFaena;

    private Double pesoOreo;

    private Date fechayHoraFaena;

    private Date fechaYHoraOreo;

}
