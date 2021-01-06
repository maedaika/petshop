package br.com.treinamento.petshop.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.json.Response;

public interface IPets {

    public ResponseEntity<Response> cadastraPets(@RequestParam Integer idPets,@RequestParam String nome,@RequestParam String nomeDono,@RequestParam String endereco,@RequestParam String dataNascimento) throws BDException;
	 
	 public ResponseEntity<Response> deleteTodosPets() throws BDException;
	 
	 public ResponseEntity<Response> buscaTodasPets() throws BDException;
}
