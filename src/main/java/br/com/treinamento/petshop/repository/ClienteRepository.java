package br.com.treinamento.petshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.treinamento.petshop.domain.Cliente;

/**
 * @author alessandro.maeda
 *
 */
@Component("clienteRepository")
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
