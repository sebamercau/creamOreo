package com.smercau.creamOreo;

import com.smercau.creamOreo.Entity.MediaRes;
import com.smercau.creamOreo.Entity.TwinsRegistroFaena;
import com.smercau.creamOreo.Service.MediaResService;
import com.smercau.creamOreo.Service.TwinsRegistroFaenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CreamOreoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreamOreoApplication.class, args);

		TwinsRegistroFaenaService twinsRegistroFaenaService = new TwinsRegistroFaenaService();
		List<TwinsRegistroFaena> registros = twinsRegistroFaenaService.obtenerRegistrosPorFecha();

		for (TwinsRegistroFaena registro : registros) {
			System.out.println(registro.getCodigoDeBarras());
		}



	}


}
