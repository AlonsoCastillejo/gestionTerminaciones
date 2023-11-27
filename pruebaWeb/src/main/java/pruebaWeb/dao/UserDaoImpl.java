package pruebaWeb.dao;

//import static pruebaWeb.connection.connection.getConnection;
//
//import static pruebaWeb.connection.connection.close;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pruebaWeb.connection.connection;
import pruebaWeb.domain.User;

public class UserDaoImpl implements UserDao {


	private static final String SQL_SELECT = "SELECT * FROM user";
	private static final String SQL_SELECTED_ID = "SELECT * FROM user WHERE idUser = ?";
	private static final String SQL_INSERT = "INSERT INTO user ( "
			+ "userName,"
			+ "password"
			+ ") VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE user SET"
			+ "userName = ?"
			+ "password = ?"
			+ "WHERE idUser = ?";
	private static final String SQL_DELETE = "DELETE FROM user WHERE idUser = ?";
	
	
	@Override
	public List<User> select() throws SQLException {
		connection conexion = new connection();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		User user = null;
		List<User> users = new ArrayList<>();
		
		try {
			cn = conexion.connect();
			stm = cn.createStatement();
			rs = stm.executeQuery(SQL_SELECT);
			
			while(rs.next()) {
				int idUser = rs.getInt("idUser");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				
				users.add(new User(idUser, userName, password));
			}
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}


//		
//		close(rs);
//		close(stmt);
//		close(conn);
		
		return users;
		
	}
	
	
}
