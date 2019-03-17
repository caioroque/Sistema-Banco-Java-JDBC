package view;

import java.util.Scanner;

import org.junit.Test;

import dao.UserClienteDAO;
import model.UsuarioCliente;

public class Menu {
	
	
	@Test
	public void menu() {
		ClienteView principal = new ClienteView();
		ContaView conta = new ContaView();
		int op, opmenu, opcliente = 0, opconta = 0;
		
		Scanner input = new Scanner(System.in);
		do{
		
		
		System.out.println("*****MENU*****");
		System.out.println("1- Abrir conta");
		System.out.println("2- Saldo");
		System.out.println("3- Deposito");
		System.out.println("4- Saque");
		System.out.println("5- Transferencia");
		System.out.println("6- Sair");
		opmenu = input.nextInt();
		
		if (opmenu == 1) {
			conta.AbrirConta();
			
		}else if(opmenu == 2){
			conta.BuscarSaldo();
			
		}else if(opmenu == 3){
			conta.Deposito();
			
		}else if(opmenu == 4){
			conta.Saque();
			
		}else if(opmenu == 5){
			conta.Transferecia();
		}
		else if(opmenu == 9119){
			
		System.out.println("*****MENU*****");
		System.out.println("1- Cliente");
		System.out.println("2- Conta");
		System.out.println("3- Sair");
		System.out.println("Digite uma opção");
		op = input.nextInt();
		
		if (op == 1) {
			System.out.println("CLIENTE");
			System.out.println("1- Cadastro de Cliente");
			System.out.println("2- Lista de Cliente");
			System.out.println("3- Buscar Cliente");
			System.out.println("4- Alterar dados");
			System.out.println("5- Excluir Cliente");
			System.out.print("Digite uma opção");
			opcliente = input.nextInt();
			
			if (opcliente == 1) {
				principal.salvarClienteBanco();
				
			}else if(opcliente == 2){
				principal.ListaClientes();
				
			}else if(opcliente == 3){
				
				principal.BuscarCliente();
			
			}else if(opcliente == 4){
			
			principal.UpdateCliente();
			}
				
			else if(opcliente == 5){
				principal.DeletarCliente();
			}
		}else if(op == 2){
			System.out.println("Conta");
			System.out.println("1- Cadastrar Conta");
			System.out.println("2- Lista de Contas");
			System.out.println("3- Buscar Conta");
			System.out.println("4- Alterar dados da conta");
			System.out.println("5- Excluir Conta");
			System.out.print("Digite uma opção");
			opconta = input.nextInt();
			
			if (opconta == 1) {
				conta.AbrirConta();
				
			}else if(opconta == 2){
				conta.ListaContas();
				
			}else if(opconta == 3){
				conta.BuscarConta();
			
			}else if(opconta == 4){
			conta.UpdateConta();
			
			}else if(opconta == 5){
			conta.DeletarConta();
			}
		}
	}
  }while(opmenu != 6);
}
}
	

