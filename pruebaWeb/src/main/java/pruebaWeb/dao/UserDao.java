package pruebaWeb.dao;

import java.sql.SQLException;
import java.util.List;

import pruebaWeb.domain.User;

public interface UserDao {
	public List<User> select() throws SQLException;
	
	
}
