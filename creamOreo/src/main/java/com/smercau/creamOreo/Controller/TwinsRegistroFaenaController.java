package com.smercau.creamOreo.Controller;


import com.smercau.creamOreo.Entity.Twins.TwinsRegistroFaena;
import com.smercau.creamOreo.Service.TwinsRegistroFaenaCustomService;

import java.util.List;


public class TwinsRegistroFaenaController {


    private final TwinsRegistroFaenaCustomService twinsRegistroFaenaCustomService = new TwinsRegistroFaenaCustomService();




    List<TwinsRegistroFaena> registros = twinsRegistroFaenaCustomService.obtenerRegistrosPorFecha();

    public List<TwinsRegistroFaena> getRegistros() {
        return registros;
    }

    public void setRegistros(List<TwinsRegistroFaena> registros) {
        this.registros = registros;
    }
}
