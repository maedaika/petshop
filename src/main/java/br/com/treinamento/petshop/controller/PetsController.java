package br.com.treinamento.petshop.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.treinamento.petshop.bo.PetsBO;
import br.com.treinamento.petshop.domain.Pets;
import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.json.Response;
import br.com.treinamento.petshop.util.DataUtil;

@RestController
@RequestMapping("/api/treinamento/v1")
@Configuration
@ComponentScan("br.com.treinamento")
public class PetsController implements IPets {
	
	@Autowired
	PetsBO petsBO = null;


	
	@Override
	@RequestMapping(value = "/pets/cadastro", method =  RequestMethod.POST)
	public ResponseEntity<Response> cadastraPets(Integer idPets, String nome, String nomeDono, String endereco, String dataNascimento) throws BDException {
	
		Pets pets = new Pets();
		Response response = new Response();
		try {
		
		DataUtil dataUtil = new DataUtil();
		pets.setDataNascimento(dataUtil.parseDataBanco(dataNascimento));
		pets.setEndereco(endereco);
		pets.setIdPets(idPets);
		pets.setNome(nome);
		pets.setNomeDono(nomeDono);
		response.setModeloRetorno(petsBO.buscaTodasPets());
		response.setMensagensRetorno("Cadastro realizado com sucesso!!!");
		
		} catch (Exception e) {

			response.setMensagensRetorno(e.getMessage());
		}
		
		return ResponseEntity.ok(response);
	}

	@Override
	@RequestMapping(value = "/pets/delete/todas", method =  RequestMethod.DELETE)
	public ResponseEntity<Response> deleteTodosPets() throws BDException {
		Response response = new Response();
		try {
			petsBO.deleteTodasPets();
			response.setMensagensRetorno("Todas os pets foram apagadas da base de dados!!!");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	@RequestMapping(value = "/pets/busca/todas", method =  RequestMethod.GET)
	public ResponseEntity<Response> buscaTodasPets() throws BDException {
		Response response = new Response();
		
		try {
			response.setModeloRetorno(petsBO.buscaTodasPets());
			response.setMensagensRetorno("Todas os produtos contidas na base de dados!!!");
		} catch (Exception e) {
			// TODO: handle exception
		response.setMensagensRetorno(e.getMessage());
	}
	return ResponseEntity.ok(response);
	}

}
