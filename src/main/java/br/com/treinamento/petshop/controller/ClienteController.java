package br.com.treinamento.petshop.controller;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.petshop.domain.Pets;
import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.json.Response;

@RestController
@RequestMapping("/api/treinamento/v1")
@Configuration
@ComponentScan("br.com.treinamento")
public class ClienteController implements IClienteController {

	@Override
	public ResponseEntity<Response> cadastraCliente(Integer idCliente, String nome, String endereco,
			Date dataNascimento, Pets pets) throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response> deleteTodosCliente() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Response> buscaTodasCliente() throws BDException {
		// TODO Auto-generated method stub
		return null;
	}

}
