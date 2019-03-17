package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Conta;

public class ContaDAO {
	private Connection connection;
	
	public ContaDAO(){
		connection = SingleConnection.getConnection();
	}

	public void abrirConta(Conta conta){
		
		try {
			String sql = "insert into conta (numero_conta, saldo_conta, tipo_conta, cliente_conta ) "
					+ " values (?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, conta.getNumero_conta());
			insert.setFloat(2, conta.getSaldo_conta());
			insert.setString(3, conta.getTipo_conta());
			insert.setInt(4, conta.getCliente_conta());
			insert.execute();
			connection.commit();
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void Saque(Conta conta){
		
		try{
		String sql = "update conta set saldo_conta=? where id_conta =" + conta.getId_conta();
		PreparedStatement update = connection.prepareStatement(sql);
		
		//update.setString(1, conta.getNumero_conta());
		update.setFloat(1, conta.getSaldo_conta());
		//update.setString(3, conta.getTipo_conta());
		//update.setInt(4, conta.getCliente_conta());
		update.execute();
		connection.commit();
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public List<Conta> listaContas(){
		try {
			List<Conta> listacontas = new ArrayList<Conta>();
			PreparedStatement lista = this.connection.prepareStatement("select * from conta");
			ResultSet rs = lista.executeQuery();
			while(rs.next()){
				Conta conta = new Conta();
				conta.setId_conta(rs.getInt("id_conta"));
				conta.setNumero_conta(rs.getString("numero_conta"));
				conta.setSaldo_conta(rs.getFloat("saldo_conta"));
				conta.setTipo_conta(rs.getString("tipo_conta"));
				conta.setCliente_conta(rs.getInt("cliente_conta"));
				
				listacontas.add(conta);
			}
			rs.close();
			lista.close();
			return listacontas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void editarConta(Conta conta){
		try{
		String sql = "update conta set numero_conta=?, saldo_conta=?, tipo_conta=? whre id_conta =" + conta.getId_conta();
		PreparedStatement update = connection.prepareStatement(sql);
		
		update.setString(1, conta.getNumero_conta());
		update.setFloat(2, conta.getSaldo_conta());
		update.setString(3, conta.getTipo_conta());
		update.setInt(4, conta.getCliente_conta());
		update.execute();
		connection.commit();
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public Conta pesquisarConta(int id) throws Exception{
		Conta buscar = new Conta();
		
		String sql = "select * from conta where id_conta =" + id;
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			buscar.setId_conta(rs.getInt("id_conta"));
			buscar.setNumero_conta(rs.getString("numero_conta"));
			buscar.setSaldo_conta(rs.getFloat("saldo_conta"));
			buscar.setTipo_conta(rs.getString("tipo_conta"));
			buscar.setCliente_conta(rs.getInt("cliente_conta"));
		}
		return buscar;
	}

	public void deletarConta(String numero_conta){
		try {
			String sql = "delete from conta where numero_conta =" + numero_conta;
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
