package view;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import dao.ContaDAO;
import model.Conta;



public class ContaView {
	String numeroconta, tipoconta;
	float saldoconta;
	int clienteconta;
	Scanner input = new Scanner(System.in);
	
	
	@Test
	public void AbrirConta(){
		Conta conta = new Conta();
		ContaDAO contaDAO = new ContaDAO();
		
		try{
			System.out.print("Digite o numero da conta: ");
			numeroconta = input.nextLine();
			conta.setNumero_conta(numeroconta);	
			
			System.out.print("Digite o tipo da conta: ");
			tipoconta = input.nextLine();
			conta.setTipo_conta(tipoconta);
			
			System.out.print("Digite o codigo do cliente: ");
			clienteconta = input.nextInt();
			conta.setCliente_conta(clienteconta);
			
			System.out.print("Digite o saldo da conta:");
			saldoconta = input.nextFloat();
			conta.setSaldo_conta(saldoconta);
			
			System.out.println(conta);
			contaDAO.abrirConta(conta);
			System.out.println("Conta aberta !");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não foi possivel abrir a conta.");
		}
	}
	
	@Test
	public void ListaContas(){
try {
			ContaDAO lista = new ContaDAO();
			
			List<Conta> list = lista.listaContas();
						
			for(Conta contas : list){
				System.out.println(contas);
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	@Test
	public void UpdateConta(){
		ContaDAO contaDAO = new ContaDAO();
		int id_conta;
		
		try {			
			System.out.println("Informe o cogido da conta há ser alterado: ");
			id_conta = input.nextInt();
			
			
			Conta objetoBanco = contaDAO.pesquisarConta(id_conta);
			System.out.println(objetoBanco);
			
			if (id_conta == objetoBanco.getId_conta()) {	
				
				System.out.print("Digite o numero da conta: ");
				numeroconta = input.nextLine();
				objetoBanco.setNumero_conta(numeroconta);	
				
				System.out.print("Digite o saldo da conta: ");
				saldoconta = input.nextFloat();
				objetoBanco.setSaldo_conta(saldoconta);
				
				System.out.print("Digite o tipo da conta: ");
				tipoconta = input.nextLine();
				objetoBanco.setTipo_conta(tipoconta);
				
				System.out.println(objetoBanco);
				
				contaDAO.editarConta(objetoBanco);
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
	public void BuscarConta(){
		ContaDAO dao = new ContaDAO();
		int id_conta;
		
		try {
			System.out.println("Informe o codigo da conta há ser buscado: ");
			id_conta = input.nextInt();
			
			Conta objetoBanco = dao.pesquisarConta(id_conta);
			
			if (id_conta == objetoBanco.getId_conta() ) {
				System.out.println(objetoBanco);
			}else{
				System.out.println("Conta não encontrada");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void BuscarSaldo(){
		ContaDAO dao = new ContaDAO();

		int id_conta;
		
		try {
			System.out.println("Informe o codigo da conta há ser buscado: ");
			id_conta = input.nextInt();
			
			Conta objetoBanco = dao.pesquisarConta(id_conta);
			
			if (id_conta == objetoBanco.getId_conta() ) {
				System.out.println("Seu saldo é: " + objetoBanco.getSaldo_conta());
			}else{
				System.out.println("Conta não encontrada");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void DeletarConta(){
		Conta conta = new Conta();
		ContaDAO dao = new ContaDAO();
		try {
			ListaContas();
			System.out.println("Informe o numero da conta há ser excluido: ");
			numeroconta = input.nextLine();
			conta.setNumero_conta(numeroconta);
			
			dao.deletarConta(numeroconta);
			
			System.out.println("Conta deletada com sucesso !!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Conta não deletada !!");
		}

		
	}

	@Test
	public void Deposito(){

		ContaDAO dao = new ContaDAO();
		float saldo_novo;
		int id_conta;
		
		try {			
			System.out.println("Informe o cogido da conta para fazer o deposito: ");
			id_conta = input.nextInt();
			
			Conta objetoBanco = dao.pesquisarConta(id_conta);
			
			if(id_conta == objetoBanco.getId_conta()){
			System.out.println("Saldo atual " + objetoBanco.getSaldo_conta());
			System.out.println("Digite o valor que deseja depositar: ");
			saldo_novo = input.nextFloat();
			//objetoBanco.setSaldo_conta(saldo_novo);
			//System.out.println(objetoBanco.getSaldo_conta());
			saldo_novo = saldo_novo + objetoBanco.getSaldo_conta();
			
			objetoBanco.getNumero_conta();
			objetoBanco.getSaldo_conta();
			objetoBanco.getTipo_conta();
			objetoBanco.getCliente_conta();
			objetoBanco.setSaldo_conta(saldo_novo);
			
			dao.Saque(objetoBanco);
			
			System.out.println("Novo saldo " + saldo_novo);
			}else{
				System.out.println("deposito não realizado !!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void Saque(){
		ContaDAO dao = new ContaDAO();
		float saldo_novo;
		int id_conta;
		
		try {			
			System.out.println("Informe o cogido da conta para fazer o saque: ");
			id_conta = input.nextInt();
			
			Conta objetoBanco = dao.pesquisarConta(id_conta);
			
			if(id_conta == objetoBanco.getId_conta()){
			System.out.println("Saldo atual " + objetoBanco.getSaldo_conta());
			System.out.println("Digite o valor que deseja sacar: ");
			saldo_novo = input.nextFloat();
			saldo_novo = objetoBanco.getSaldo_conta() - saldo_novo;
			
			objetoBanco.getNumero_conta();
			objetoBanco.getSaldo_conta();
			objetoBanco.getTipo_conta();
			objetoBanco.getCliente_conta();
			objetoBanco.setSaldo_conta(saldo_novo);

			dao.Saque(objetoBanco);
			
			System.out.println("Novo saldo " + saldo_novo);
			}else{
				System.out.println("saque não realizado !!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void Transferecia(){
		ContaDAO dao = new ContaDAO();
		int id_conta, id_conta1;
		float saldo_novo, saldo;
		
		try {			
			System.out.println("Informe o cogido da sua conta: ");
			id_conta = input.nextInt();
			
			Conta objetoBanco = dao.pesquisarConta(id_conta);
			
			if(id_conta == objetoBanco.getId_conta()){
			System.out.println("Saldo atual " + objetoBanco.getSaldo_conta());
			System.out.println("Digite o valor que deseja transferir: ");
			saldo_novo = input.nextFloat();
			saldo = objetoBanco.getSaldo_conta() - saldo_novo;
			
			objetoBanco.getNumero_conta();
			objetoBanco.getSaldo_conta();
			objetoBanco.getTipo_conta();
			objetoBanco.getCliente_conta();
			objetoBanco.setSaldo_conta(saldo);
			
			dao.Saque(objetoBanco);
			System.out.println(saldo_novo);
			
			System.out.println("Informe o cogido da sua conta há transferir: ");
			id_conta1 = input.nextInt();
			System.out.println("Saldo atual " + objetoBanco.getSaldo_conta());
			
			objetoBanco = dao.pesquisarConta(id_conta1);
			
			saldo_novo = objetoBanco.getSaldo_conta() + saldo_novo;
			
			objetoBanco.getNumero_conta();
			objetoBanco.getSaldo_conta();
			objetoBanco.getTipo_conta();
			objetoBanco.getCliente_conta();
			objetoBanco.setSaldo_conta(saldo_novo);

			dao.Saque(objetoBanco);
			
			System.out.println("Novo saldo " + saldo_novo);
			
			ListaContas();
			}else{
				System.out.println("saque não realizado !!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
