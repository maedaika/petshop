package br.com.treinamento.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.petshop.bo.ClienteBO;
import br.com.treinamento.petshop.domain.Cliente;
import br.com.treinamento.petshop.domain.Pets;
import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.json.Response;
import br.com.treinamento.petshop.util.DataUtil;

@RestController
@RequestMapping("/api/treinamento/v1")
@Configuration
@ComponentScan("br.com.treinamento")
public class ClienteController implements IClienteController {
	
	@Autowired
	ClienteBO clienteBO = null;
	

	@RequestMapping(value = "/cliente/cadastro", method =  RequestMethod.POST)
	public ResponseEntity<Response> cadastraCliente(String nome, String endereco, String dataNascimento, String idPets) throws BDException {
		
		DataUtil dataUtil = new DataUtil();
		Response response = new Response();
		Cliente cliente = new Cliente();
		try {
			cliente.setNome(nome);
			cliente.setDataNascimento(dataUtil.parseDataBanco(dataNascimento));
			cliente.setEndereco(endereco);
			//cliente.setIdCliente(idCliente);
			Pets pets = new Pets();
			//pets.setIdPets(new Integer(idPets));
			//cliente.setPets(pets);
			cliente.setPets(new Integer(idPets));
			
			response.setModeloRetorno(clienteBO.cadastraCliente(cliente));
			response.setMensagensRetorno("Cadastro realizado com sucesso");
		} catch (Exception e) {
			response.setMensagensRetorno(e.getMessage());
		}
		return  ResponseEntity.ok(response);
	}

	@Override
	@RequestMapping(value = "/cliente/delete/todas", method =  RequestMethod.DELETE)
	public ResponseEntity<Response> deleteTodosCliente() throws BDException {
		//Cliente cliente = new Cliente();
		Response response = new Response();
		try {
			clienteBO.deleteTodasCliente();
			response.setMensagensRetorno("Todas os clientes foram apagadas da base de dados!!!");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMensagensRetorno(e.getMessage());	
		}
		return ResponseEntity.ok(response);
	}

	@Override
	@RequestMapping(value = "/cliente/busca/todas", method =  RequestMethod.GET)
	public ResponseEntity<Response> buscaTodasCliente() throws BDException {
		Response response = new Response();
		//Cliente cliente = new Cliente();
		try {
			response.setModeloRetorno(clienteBO.buscaTodasCliente());
			response.setMensagensRetorno("Todas os produtos contidas na base de dados!!!");
		} catch (Exception e) {
			response.setMensagensRetorno(e.getMessage());
		}
		return ResponseEntity.ok(response);
	}
	@Override
	@RequestMapping(value = "/cliente/ler/lerArquivo", method =  RequestMethod.POST)
	public ResponseEntity<Response> LerArquivos() throws BDException {
		Response response = new Response();
		try {
			response.setModeloRetorno(clienteBO.lerArquivos());
			response.setMensagensRetorno("Leitura de arquivos");
		} catch (Exception e) {
			response.setMensagensRetorno(e.getMessage());
		}
		return ResponseEntity.ok(response);
	}

}
