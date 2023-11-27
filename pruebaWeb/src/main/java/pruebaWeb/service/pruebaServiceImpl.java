package pruebaWeb.service;

import java.sql.SQLException;
import java.util.List;

import pruebaWeb.dao.TerminacionesDao;
import pruebaWeb.dao.TerminacionesDaoImpl;
import pruebaWeb.domain.Terminaciones;

public class pruebaServiceImpl implements pruebaService{
		
	static TerminacionesDao terminacionesDao = new TerminacionesDaoImpl();
	
	public List<Terminaciones> allTerminaciones() throws SQLException{
		return terminacionesDao.select();
	}
}
