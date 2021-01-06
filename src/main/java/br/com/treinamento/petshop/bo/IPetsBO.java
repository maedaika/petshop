package br.com.treinamento.petshop.bo;

import java.util.ArrayList;

import br.com.treinamento.petshop.domain.Pets;
import br.com.treinamento.petshop.exception.BDException;


public interface IPetsBO {
	
	public Pets cadastraPets(Pets pets) throws BDException;
	
	public void deleteTodasPets() throws BDException;	
	
	public ArrayList<Pets> buscaTodasPets() throws BDException;
	
	public void deletaPets(Integer idPets )throws BDException;
	
	public void recebePets(Pets pets)throws BDException;

}
