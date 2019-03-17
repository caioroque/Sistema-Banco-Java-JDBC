package view;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import dao.UserClienteDAO;
import model.UsuarioCliente;

public class ClienteView {
	Scanner input = new Scanner(System.in);
	
	String nome_cliente, cpf_cliente, rg_cliente, email_cliente, endereco_cliente, telefone_cliente;
	int idade_cliente;
	
	@Test
	//public static void main(String[] args) {
	public void salvarClienteBanco(){
		UsuarioCliente usuariocliente = new UsuarioCliente();
		UserClienteDAO cliente = new UserClienteDAO();
		
		try{
			
		System.out.print("Digite o nome do cliente: ");
		nome_cliente = input.nextLine();
		usuariocliente.setNomeCliente(nome_cliente);	
		
		System.out.print("Digite o CPF do cliente:");
		cpf_cliente = input.nextLine();
		usuariocliente.setCpfCliente(cpf_cliente);;
		
		System.out.print("Digite o RG do cliente: ");
		rg_cliente = input.nextLine();
		usuariocliente.setRgCliente(rg_cliente);
		
		System.out.print("Digite o E-mail do cliente: ");
		email_cliente = input.nextLine();
		usuariocliente.setEmailCliente(email_cliente);;
		
		System.out.print("Digite o endereço do cliente: ");
		endereco_cliente = input.nextLine();
		usuariocliente.setEnderecoCliente(endereco_cliente);;
		
		System.out.print("Digite o telefone do cliente");
		telefone_cliente = input.nextLine();
		usuariocliente.setTelefoneCliente(telefone_cliente);;
		
		System.out.print("Digite a idade do cliente");
		idade_cliente = input.nextInt();
		usuariocliente.setIdadeCliente(idade_cliente);
		
		cliente.SalvarCliente(usuariocliente);
		
		System.out.println("Cliente cadastro com sucesso");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cliente não cadastrado !!");
		}
	}

	@Test
	public void ListaClientes(){
		try {
			UserClienteDAO lista = new UserClienteDAO();
			
			List<UsuarioCliente> list = lista.ListaClientes();
						
			for(UsuarioCliente usuariocliente : list){
				System.out.println(usuariocliente);
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void UpdateCliente(){
		UserClienteDAO pessoa = new UserClienteDAO();
		String nome_clientes;
		
		try {			
			//System.out.println("Informe o cogido do cliente há ser alterado: ");
			//id_cliente = input.nextInt();
			
			
			UsuarioCliente objetoBanco = pessoa.PesquisarCliente(3);
			System.out.println(objetoBanco);
			
			if (3 == objetoBanco.getIdCliente()) {	
				
				System.out.print("Digite o nome do cliente: ");
				nome_clientes = input.nextLine();
				objetoBanco.setNomeCliente(nome_clientes);	
				
				System.out.print("Digite o CPF do cliente: ");
				cpf_cliente = input.nextLine();
				objetoBanco.setCpfCliente(cpf_cliente);
				
				System.out.print("Digite o RG do cliente: ");
				rg_cliente = input.nextLine();
				objetoBanco.setRgCliente(rg_cliente);
				
				System.out.print("Digite o E-mail do cliente: ");;
				email_cliente = input.nextLine();
				objetoBanco.setEmailCliente(email_cliente);
				
				System.out.print("Digite o endereço do cliente: ");
				endereco_cliente = input.nextLine();
				objetoBanco.setEnderecoCliente(endereco_cliente);
				
				System.out.print("Digite o telefone do cliente");
				telefone_cliente = input.nextLine();
				objetoBanco.setTelefoneCliente(telefone_cliente);
				
				System.out.print("Digite a idade do cliente");
				idade_cliente = input.nextInt();
				objetoBanco.setIdadeCliente(idade_cliente);
				
				System.out.println(objetoBanco);
				
				pessoa.EditarCliente(objetoBanco);
				System.out.println("Cliente alterado com sucesso !!");
			}else{
				System.out.println("Cliente não alterado");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cliente não alterado !!");
		}
		
	}
	
	@Test
	public void BuscarCliente(){
		UserClienteDAO pessoa = new UserClienteDAO();
		
		int id_cliente;
		
		try {
			System.out.println("Informe o codigo do cliente há ser buscado: ");
			id_cliente = input.nextInt();
			
			UsuarioCliente objetoBanco = pessoa.PesquisarCliente(id_cliente);
			
			System.out.println(objetoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void DeletarCliente(){
		
		UserClienteDAO pessoa = new UserClienteDAO();
		UsuarioCliente cliente = new UsuarioCliente();
		
		try {
			System.out.println("Informe o CPF do cliente há ser excluido: ");
			cpf_cliente = input.nextLine();
			cliente.setCpfCliente(cpf_cliente);
			
			pessoa.deletarCliente(cpf_cliente);
			
			System.out.println("Cliente deletado com sucesso !!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cliente não deletado !!");
		}

		
	}
}
