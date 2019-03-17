package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.UsuarioCliente;

public class UserClienteDAO {
	
	private Connection connection;
	
	public UserClienteDAO(){
		connection = SingleConnection.getConnection();
	}
	
	public void SalvarCliente(UsuarioCliente usuariocliente){
		
		try {
			
			String sql = 
			"insert into usercliente (nome_cliente, cpf_cliente, rg_cliente, email_cliente, endereco_cliente, telefone_cliente, idade_cliente ) "
			+ "values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, usuariocliente.getNomeCliente());
			insert.setString(2, usuariocliente.getCpfCliente());
			insert.setString(3, usuariocliente.getRgCliente());
			insert.setString(4, usuariocliente.getEmailCliente());
			insert.setString(5, usuariocliente.getEnderecoCliente());
			insert.setString(6, usuariocliente.getTelefoneCliente());
			insert.setLong(7, usuariocliente.getIdadeCliente());
			insert.execute();
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
	
	public List<UsuarioCliente> ListaClientes() {
		try {
			List<UsuarioCliente> listapessoas = new ArrayList<UsuarioCliente>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from usercliente");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto do banco
				UsuarioCliente pessoa = new UsuarioCliente();
				pessoa.setIdCliente(rs.getInt("id_cliente"));
				pessoa.setNomeCliente(rs.getString("nome_cliente"));
				pessoa.setCpfCliente(rs.getString("cpf_cliente"));
				pessoa.setRgCliente(rs.getString("rg_cliente"));
				pessoa.setEmailCliente(rs.getString("email_cliente"));
				pessoa.setEnderecoCliente(rs.getString("endereco_cliente"));
				pessoa.setTelefoneCliente(rs.getString("telefone_cliente"));
				pessoa.setIdadeCliente(rs.getInt("idade_cliente"));

				// adicionando o contato a lista
				listapessoas.add(pessoa);
			}
			rs.close();
			stmt.close();
			return listapessoas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void EditarCliente(UsuarioCliente usuariocliente){
		try {
			String sql = "update usercliente set nome_cliente=?, cpf_cliente=?, rg_cliente=?, email_cliente=?, endereco_cliente=?, telefone_cliente=?, idade_cliente=? where id_cliente = " + usuariocliente.getIdCliente();
			
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, usuariocliente.getNomeCliente());
			update.setString(2, usuariocliente.getCpfCliente());
			update.setString(3, usuariocliente.getRgCliente());
			update.setString(4, usuariocliente.getEmailCliente());
			update.setString(5, usuariocliente.getEnderecoCliente());
			update.setString(6, usuariocliente.getTelefoneCliente());
			update.setInt(7, usuariocliente.getIdadeCliente());

			update.execute();
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
	
	public UsuarioCliente PesquisarCliente(int id) throws Exception {
			UsuarioCliente buscar = new UsuarioCliente();
			
			String sql = "select * from usercliente where id_cliente = " + id;
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto do banco
				buscar.setIdCliente(rs.getInt("id_cliente"));
				buscar.setNomeCliente(rs.getString("nome_cliente"));
				buscar.setCpfCliente(rs.getString("cpf_cliente"));
				buscar.setRgCliente(rs.getString("rg_cliente"));
				buscar.setEmailCliente(rs.getString("email_cliente"));
				buscar.setEnderecoCliente(rs.getString("endereco_cliente"));
				buscar.setTelefoneCliente(rs.getString("telefone_cliente"));
				buscar.setIdadeCliente(rs.getInt("idade_cliente"));

			}

			return buscar;
	    }
	
	public void deletarCliente(String cpf){
		try {
			String sql = "delete from usercliente where cpf_cliente = " + cpf;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
