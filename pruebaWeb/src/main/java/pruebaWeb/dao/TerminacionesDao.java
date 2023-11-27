package pruebaWeb.dao;

import java.sql.SQLException;
import java.util.List;

import pruebaWeb.domain.Terminaciones;
import pruebaWeb.domain.User;

public interface TerminacionesDao {
	public List<Terminaciones> select() throws SQLException;
	
	
}
