package application.dao;

public class DAO {
	
	public static CestaDAO getCestaDAO(){
		return new CestaDAOImpl();
	}

}
