package com.smercau.creamOreo;

import com.smercau.creamOreo.Entity.Twins.TwinsRegistroFaena;
import com.smercau.creamOreo.Repository.TwinsCustom.TwinsRegistroFaenaCustomRepository;
import com.smercau.creamOreo.Repository.Twins.TwinsRegistroFaenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CreamOreoApplication implements CommandLineRunner {

	/*@Autowired
	private TwinsRegistroFaenaRepository twinsRegistroFaenaRepository;*/

	@Autowired
	private TwinsRegistroFaenaCustomRepository twinsRegistroFaenaCustomRepository;


	public static void main(String[] args) {
		SpringApplication.run(CreamOreoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<TwinsRegistroFaena> registros = twinsRegistroFaenaCustomRepository.buscarFecha("20240922");

		registros.forEach(registro -> System.out.println(registro.toString()));
	}




}
