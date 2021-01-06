package br.com.treinamento.petshop.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.treinamento.petshop.domain.Pets;
import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.json.Response;

public interface IClienteController {
    public ResponseEntity<Response> cadastraCliente(@RequestParam String nome,@RequestParam String endereco,@RequestParam String dataNascimento,@RequestParam String idPets) throws BDException;
	 
	 public ResponseEntity<Response> deleteTodosCliente() throws BDException;
	 
	 public ResponseEntity<Response> buscaTodasCliente() throws BDException;
}
