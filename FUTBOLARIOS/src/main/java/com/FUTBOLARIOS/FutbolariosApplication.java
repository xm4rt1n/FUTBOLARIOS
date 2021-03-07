package com.FUTBOLARIOS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class FutbolariosApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jbdcTemplate; 
	
	public static void main(String[] args) {
		SpringApplication.run(FutbolariosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM alumnos";
		List<alumnos> alumnos = jbdcTemplate.query(sql, BeanPropertyRowMapper.newInstance(alumnos.class));
		
		alumnos.forEach(System.out :: println);
	}

}
