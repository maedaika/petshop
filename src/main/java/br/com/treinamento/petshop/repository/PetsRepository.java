package br.com.treinamento.petshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.treinamento.petshop.domain.Pets;


/**
 * @author alessandro.maeda
 *
 */
@Component("petsRepository")
public interface PetsRepository extends CrudRepository<Pets, Integer> {

}
