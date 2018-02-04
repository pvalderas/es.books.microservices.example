package application.dao;

public class DAO {
	
	public static ProductoDAO getProductoDAO(){
		return new ProductoDAOImpl();
	}

}
