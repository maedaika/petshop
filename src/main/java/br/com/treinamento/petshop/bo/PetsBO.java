package br.com.treinamento.petshop.bo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import br.com.treinamento.petshop.domain.Pets;
import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.repository.PetsRepository;

/**
 * @author alessandro.maeda
 *
 */

@Component("petsBO")
@Configuration
@ComponentScan("br.com.treinamento")
public class PetsBO implements IPetsBO {

	/*
	 * estancia da interface de persistencia (Repository)
	 */
	@Autowired
	PetsRepository petsRepository; 
	
	@Override
	public Pets cadastraPets(Pets pets) throws BDException {
		
		Pets cadastroPets = null;
		try {
			cadastroPets = petsRepository.save(pets);
		} catch (Exception e) {

			throw new BDException(e.getMessage());
		}
		// retorna sucesso com o que foi cadastrado
		return cadastroPets;
	}

	@Override
	public void deleteTodasPets() throws BDException {
		try {
			petsRepository.deleteAll();
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}
	}

	
	@Override
	public ArrayList<Pets> buscaTodasPets() throws BDException {
		ArrayList<Pets> todosPets = new ArrayList<Pets>();
		
		try {
			todosPets =(ArrayList<Pets>)petsRepository.findAll();
			
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}
		return todosPets;
	}

	@Override
	public void deletaPets(Integer idPets) throws BDException {
	try {
		petsRepository.deleteById(idPets);
	} catch (Exception e) {
		throw new BDException(e.getMessage());
  }

} 

	@Override
	public void recebePets(Pets pets) throws BDException {
		try {
			petsRepository.delete(pets);
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}

	}

}
