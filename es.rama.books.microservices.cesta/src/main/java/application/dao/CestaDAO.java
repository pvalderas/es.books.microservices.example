package application.dao;

import java.util.List;

import application.domain.Producto;

public interface CestaDAO {
	public List<Producto> getProductos();
	public void addProducto(Producto p);
	public void delProductoById(Integer id);
}
