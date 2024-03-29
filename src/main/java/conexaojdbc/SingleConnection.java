package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:mysql://localhost:3306/bancojavajdbc?useTimezone=true&serverTimezone=UTC";
	private static String user = "caio";
	private static String password = "caio";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnection(){
		
		conectar();
	}
	
	private static void conectar(){
		
		try{
			
			if(connection == null){
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectado com sucesso !! ");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return connection;
	}

	
}
