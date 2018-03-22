package application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import application.dao.ProductoDAO;
import application.domain.Producto;
import application.service.ProductoService;

@Service("productoService")
@Transactional
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoDAO productoDAO;	
	
	public List<Producto> getProductos(){
		return productoDAO.findAll();
	}
	
	public Producto getProductoById(Integer id){
		return productoDAO.findOne(id);
	}
	
	public void addProducto(Producto p){
		productoDAO.save(p);
	}
	
	public void delProductoById(Integer id){
		productoDAO.delete(id);
	}
}
