package com.smercau.creamOreo.Service;

import com.smercau.creamOreo.Entity.Twins.TwinsRegistroFaena;
import com.smercau.creamOreo.Repository.Twins.TwinsRegistroFaenaCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwinsRegistroFaenaCustomService {

    @Autowired
    private TwinsRegistroFaenaCustomRepository twinsRegistroFaenaCustomRepository;

    public List<TwinsRegistroFaena> obtenerRegistrosPorFecha() {
        return twinsRegistroFaenaCustomRepository.buscarFecha("20240923");
    }
}
