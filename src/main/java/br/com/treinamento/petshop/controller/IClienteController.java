package br.com.treinamento.petshop.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.treinamento.petshop.domain.Pets;
import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.json.Response;

public interface IClienteController {
    public ResponseEntity<Response> cadastraCliente(@RequestParam Integer idCliente,@RequestParam String nome,@RequestParam String endereco,@RequestParam Date dataNascimento,@RequestParam Pets pets) throws BDException;
	 
	 public ResponseEntity<Response> deleteTodosCliente() throws BDException;
	 
	 public ResponseEntity<Response> buscaTodasCliente() throws BDException;
}
