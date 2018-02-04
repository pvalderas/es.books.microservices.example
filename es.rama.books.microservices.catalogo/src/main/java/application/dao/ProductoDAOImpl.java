package application.dao;

import java.util.ArrayList;
import java.util.List;

import application.domain.Producto;

public class ProductoDAOImpl implements ProductoDAO {
	
	private static ArrayList<Producto>lista=null;
	
	public ProductoDAOImpl(){
		if(lista==null){
			lista = new ArrayList<Producto>();
			
			Producto p1= new Producto(1,"Apple iPhone 8 Plus","Smartphone con pantalla de 13,9 cm (64 GB, Gris espacial)",571.90);
			Producto p2= new Producto(2,"Samsung Galaxy S8","Smartphone libre de 5.8 QHD+",669.90);
			Producto p3= new Producto(3,"Huawei Mediapad T3 10","Tablet de 9.6 pulgadas IPS HD",145.99);
			
			lista.add(p1);
			lista.add(p2);
			lista.add(p3);
		}
	}

	public List<Producto> getProductos(){
		return lista;
	}
	
	public Producto getProductoById(Integer id){
		for(Producto p:lista){
			if(p.getId()==id) return p;
		}
		return null;
	}
	
	public void addProducto(Producto p){
		lista.add(p);
	}
	
	public void delProductoById(Integer id){
		Producto p= getProductoById(id);
		lista.remove(p);
	}
}
