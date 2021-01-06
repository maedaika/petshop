package br.com.treinamento.petshop.bo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import br.com.treinamento.petshop.domain.Cliente;
import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.repository.ClienteRepository;


/**
 * @author alessandro.maeda
 *
 */

@Component("ClienteBO")
@Configuration
@ComponentScan("br.com.treinamento")
public class ClienteBO implements IClienteBO {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public Cliente cadastraCliente(Cliente cliente) throws BDException {
		Cliente cadastracliente;
		try {
			cadastracliente = clienteRepository.save(cliente);
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}
		
		return cadastracliente;
	}

	@Override
	public void deleteTodasCliente() throws BDException {
		try {
			clienteRepository.deleteAll();
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}

	}

	@Override
	public ArrayList<Cliente> buscaTodasCliente() throws BDException {
	
		ArrayList<Cliente> todosClientes = new ArrayList<Cliente>();
		try {
			todosClientes = (ArrayList<Cliente>) clienteRepository.findAll();
			
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}
		return todosClientes;
	}

	@Override
	public void deletaCliente(Integer idCliente) throws BDException {
		try {
			clienteRepository.deleteById(idCliente);
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}

	}

	@Override
	public void recebeCliente(Cliente cliente) throws BDException {

		try {
			clienteRepository.delete(cliente);
		} catch (Exception e) {
			throw new BDException(e.getMessage());
		}

	}

}
