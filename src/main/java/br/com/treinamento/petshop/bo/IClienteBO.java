package br.com.treinamento.petshop.bo;

import java.util.ArrayList;

import br.com.treinamento.petshop.domain.Cliente;
import br.com.treinamento.petshop.exception.BDException;

public interface IClienteBO {

	public Cliente cadastraCliente(Cliente cliente) throws BDException;
	public void deleteTodasCliente() throws BDException;	
	public ArrayList<Cliente> buscaTodasCliente() throws BDException;
	public void deletaCliente(Integer idCliente )throws BDException;
	public void recebeCliente(Cliente cliente)throws BDException;
	
}
