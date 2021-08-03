package com.chavesricardo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chavesricardo.projetogpmo4.domain.Cirurgia;
import com.chavesricardo.projetogpmo4.domain.Paciente;
import com.chavesricardo.projetogpmo4.domain.Usuario;
import com.chavesricardo.projetogpmo4.repositories.CirurgiaRepository;
import com.chavesricardo.projetogpmo4.repositories.PacienteRepository;
import com.chavesricardo.projetogpmo4.repositories.UsuarioRepository;

@SpringBootApplication
public class Projetogpmo4Application implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private CirurgiaRepository cirurgiaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Projetogpmo4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usu1 = new Usuario(null, "Ricardo", "ricardo@gmail.com", "12345");
		Usuario usu2 = new Usuario(null, "Débora", "debora@gmail.com", "123456");
		Usuario usu3 = new Usuario(null, "Ana", "ana@gmail.com", "1234567");
		Usuario usu4 = new Usuario(null, "Vanessa", "vanessa@gmail.com", "12345678");
		Usuario usu5 = new Usuario(null, "Renata", "renata@gmail.com", "123456789");
		
		Paciente pct1 = new Paciente(null, 11111111);
		Paciente pct2 = new Paciente(null, 22222222);
		Paciente pct3 = new Paciente(null, 33333333);
		Paciente pct4 = new Paciente(null, 44444444);
		Paciente pct5 = new Paciente(null, 55555555);
		Paciente pct6 = new Paciente(null, 66666666);
		Paciente pct7 = new Paciente(null, 77777777);
		
		usu1.getPacientes().addAll(Arrays.asList(pct1));
		usu2.getPacientes().addAll(Arrays.asList(pct2, pct3));
		usu3.getPacientes().addAll(Arrays.asList(pct4, pct5, pct6));
		usu5.getPacientes().addAll(Arrays.asList(pct7));
		
		pct1.getUsuarios().addAll(Arrays.asList(usu1));
		pct2.getUsuarios().addAll(Arrays.asList(usu2));
		pct3.getUsuarios().addAll(Arrays.asList(usu2));
		pct4.getUsuarios().addAll(Arrays.asList(usu3));
		pct5.getUsuarios().addAll(Arrays.asList(usu3));
		pct6.getUsuarios().addAll(Arrays.asList(usu3));
		pct7.getUsuarios().addAll(Arrays.asList(usu5));
		
		Cirurgia cir1 = new Cirurgia(null, new java.util.Date(sdf.parse("20/02/2020").getTime()));
		Cirurgia cir2 = new Cirurgia(null, new java.util.Date(sdf.parse("26/05/2021").getTime()));
		Cirurgia cir3 = new Cirurgia(null, new java.util.Date(sdf.parse("10/10/2009").getTime()));
		Cirurgia cir4 = new Cirurgia(null, new java.util.Date(sdf.parse("15/08/2013").getTime()));
		Cirurgia cir5 = new Cirurgia(null, new java.util.Date(sdf.parse("07/02/2000").getTime()));
		Cirurgia cir6 = new Cirurgia(null, new java.util.Date(sdf.parse("07/02/2000").getTime()));
		Cirurgia cir7 = new Cirurgia(null, new java.util.Date(sdf.parse("24/12/2010").getTime()));
		Cirurgia cir8 = new Cirurgia(null, new java.util.Date(sdf.parse("13/05/1998").getTime()));
		Cirurgia cir9 = new Cirurgia(null, new java.util.Date(sdf.parse("27/06/2019").getTime()));
		
		pct1.getCirurgias().addAll(Arrays.asList(cir1, cir2));
		pct2.getCirurgias().addAll(Arrays.asList(cir3));
		pct3.getCirurgias().addAll(Arrays.asList(cir4));
		pct4.getCirurgias().addAll(Arrays.asList(cir5, cir6, cir7));
		pct5.getCirurgias().addAll(Arrays.asList(cir8));
		pct6.getCirurgias().addAll(Arrays.asList(cir9));
		
		cir1.getPacientes().addAll(Arrays.asList(pct1));
		cir2.getPacientes().addAll(Arrays.asList(pct1));
		cir3.getPacientes().addAll(Arrays.asList(pct2));
		cir4.getPacientes().addAll(Arrays.asList(pct3));
		cir5.getPacientes().addAll(Arrays.asList(pct4));
		cir6.getPacientes().addAll(Arrays.asList(pct4));
		cir7.getPacientes().addAll(Arrays.asList(pct4));
		cir8.getPacientes().addAll(Arrays.asList(pct5));
		cir9.getPacientes().addAll(Arrays.asList(pct6));
			
		
		cirurgiaRepository.saveAll(Arrays.asList(cir1, cir2, cir3, cir4, cir5, cir6, cir7, cir8, cir9));
		pacienteRepository.saveAll(Arrays.asList(pct1, pct2, pct3, pct4, pct5, pct6, pct7));
		usuarioRepository.saveAll(Arrays.asList(usu1,usu2,usu3,usu4,usu5));
		
		
	}
	
	

}
