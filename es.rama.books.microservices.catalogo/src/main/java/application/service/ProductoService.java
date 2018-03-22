package application.service;

import java.util.List;

import application.domain.Producto;

public interface ProductoService {
	public List<Producto> getProductos();
	public Producto getProductoById(Integer id);
	public void addProducto(Producto p);
	public void delProductoById(Integer id);

}
