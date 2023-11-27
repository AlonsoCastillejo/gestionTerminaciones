package pruebaWeb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pruebaWeb.connection.connection;
import pruebaWeb.domain.Terminaciones;
import pruebaWeb.domain.User;

public class TerminacionesDaoImpl implements TerminacionesDao{


	private static final String SQL_SELECT = "SELECT * FROM terminacion";
	private static final String SQL_SELECTED_ID = "SELECT * FROM terminacion WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO terminacion ( "
			+ "etiqueta,"
			+ "valor"
			+ ") VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE terminacion SET"
			+ "etiqueta = ?"
			+ "valor = ?"
			+ "WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM terminacion WHERE id = ?";
	
	
	@Override
	public List<Terminaciones> select() throws SQLException {
		connection conexion = new connection();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		Terminaciones terminacion = null;
		List<Terminaciones> terminacionesAll = new ArrayList<>();
		
		try {
			cn = conexion.connect();
			stm = cn.createStatement();
			rs = stm.executeQuery(SQL_SELECT);
			
			while(rs.next()) {
				String etiqueta = rs.getString("etiqueta");
				int valor = rs.getInt("valor");
				
				terminacionesAll.add(new Terminaciones(etiqueta, valor));
			}
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		
		return terminacionesAll;
		
	}
	
	
}