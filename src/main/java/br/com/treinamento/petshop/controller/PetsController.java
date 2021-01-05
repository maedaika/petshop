package br.com.treinamento.petshop.controller;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.json.Response;

@RestController
@RequestMapping("/api/treinamento/v1")
@Configuration
@ComponentScan("br.com.treinamento")
public class PetsController implements IPets {

	@Override
	public ResponseEntity<Response> cadastraPets(Integer idPets, String nome, String nomeDono, String endereco,
			Date dataNascimento) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response> deleteTodosPets() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response> buscaTodasPets() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

}
