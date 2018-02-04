package application.dao;

import java.util.ArrayList;
import java.util.List;

import application.domain.Producto;

public class CestaDAOImpl implements CestaDAO {
	
	private static ArrayList<Producto>lista=null;
	
	public CestaDAOImpl(){
		if(lista==null){
			lista = new ArrayList<Producto>();
		}
	}

	public List<Producto> getProductos(){
		return lista;
	}
	
	public void addProducto(Producto p){
		lista.add(p);
	}
	
	public void delProductoById(Integer id){
		Producto p= getProductoById(id);
		lista.remove(p);
	}
	
	private Producto getProductoById(Integer id){
		for(Producto p:lista){
			if(p.getId()==id) return p;
		}
		return null;
	}
}
