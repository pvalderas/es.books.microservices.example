package application.dao;

import java.util.List;

import application.domain.Producto;

public interface ProductoDAO {
	public List<Producto> getProductos();
	public Producto getProductoById(Integer id);
	public void addProducto(Producto p);
	public void delProductoById(Integer id);
}
