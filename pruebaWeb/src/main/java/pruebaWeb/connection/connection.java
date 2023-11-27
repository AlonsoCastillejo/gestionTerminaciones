 package pruebaWeb.connection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/gestionterminaciones";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controladort");
			e.printStackTrace();
		}
	}
	
	
	public Connection connect() {
		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Conexion con exito");
		} catch (SQLException e){
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	//	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pruebaDatabase?useSSL=false"
//			+"&useTimezonse=true&serverYimezon=UTC"
//			+"&allowPublicKeyRetrievel=true";
//	private static final String JDBC_USER = "root";
//	private static final String JDBC_PASSWORD = "1234";
//	
//	public static Connection getConnection() throws SQLException{
//		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//	}
//	
//	public static void close(ResultSet rs) throws SQLException{
//		rs.close();
//	}
//	public static void close(Statement stm) throws SQLException{
//		stm.close();
//	}
//	public static void close(Connection conn) throws SQLException{
//		conn.close();
//	}
	
	
	
	
//	public static void main(String[] args) {
//		Connection conn = null;
//		try {
//			conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebadatabase","root","1234");
//			
//			if(conn != null) {
//				System.out.print("not conneceted");
//			}
//		} catch (Exception e) {
//			System.out.print("not connected");
//		}
//	}
	
	

}
