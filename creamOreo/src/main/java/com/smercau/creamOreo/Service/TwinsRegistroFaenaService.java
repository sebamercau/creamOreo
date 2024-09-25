package com.smercau.creamOreo.Service;

import com.smercau.creamOreo.Entity.Twins.TwinsRegistroFaena;
import com.smercau.creamOreo.Repository.Twins.TwinsRegistroFaenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwinsRegistroFaenaService {

    @Autowired
    private TwinsRegistroFaenaRepository twinsRegistroFaenaRepository;

/*    @Autowired
    private TwinsRegistroFaenaCustomRepository twinsRegistroFaenaCustomRepository;*/

    public List<TwinsRegistroFaena> obtenerTodosLosRegistros() {
        return twinsRegistroFaenaRepository.findAll();
    }

/*    public List<TwinsRegistroFaena> obtenerRegistrosPorFecha() {
        return twinsRegistroFaenaCustomRepository.buscarFecha("20240923");
    }*/


}
