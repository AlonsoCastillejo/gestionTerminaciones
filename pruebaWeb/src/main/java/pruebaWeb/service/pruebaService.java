package pruebaWeb.service;

import java.sql.SQLException;
import java.util.List;

import pruebaWeb.domain.Terminaciones;
import pruebaWeb.domain.User;

public interface pruebaService {
	public List<Terminaciones> allTerminaciones() throws SQLException;
}
