package br.com.treinamento.petshop.bo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import br.com.treinamento.petshop.domain.Cliente;
import br.com.treinamento.petshop.exception.BDException;
import br.com.treinamento.petshop.repository.ClienteRepository;
import br.com.treinamento.petshop.util.DataUtil;


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

	@Override
	public ArrayList<Cliente> lerArquivos() throws BDException, IOException {
		DataUtil dataUtil = new DataUtil();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alessandro.maeda\\eclipse-workspace\\petshop\\src\\main\\resources\\cachorro.txt"));
			String linha;

			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
				String[] array = linha.split(",");
				System.out.println(array[0]);
				System.out.println(array[1]);
				System.out.println(array[2]);
				System.out.println(array[3]);
				
				Cliente cli = new Cliente();
				//Integer pets = new Integer();
				cli.setNome(array[0]);
				cli.setEndereco(array[1]);
				cli.setDataNascimento(dataUtil.parseDataBanco(array[2]));
				//pets.setIdPets(new Integer(array[3]));
				String teste = array[3];
				cli.setPets(new Integer(teste));
				clienteRepository.save(cli);
			}
			br.close();

		} catch (Exception e) {
			System.err.println("err:" + e.getMessage());
		}
		return null;
	}
}
