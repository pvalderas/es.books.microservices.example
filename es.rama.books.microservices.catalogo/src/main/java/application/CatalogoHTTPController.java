package application;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.dao.DAO;
import application.domain.Producto;
 
@RestController
public class CatalogoHTTPController {
	 
	@RequestMapping(
			  value = "/productos", 
			  method = RequestMethod.GET, 
			  produces = "application/json")
	 public List<Producto> listaProductosJSON() {
		 return DAO.getProductoDAO().getProductos();
	 }
	
	@RequestMapping(
			  value = "/productos/{id}", 
			  method = RequestMethod.GET,
			  produces = "application/json"
			  )
	 public Producto getProductosJSON(@PathVariable(value="id") Integer id) {
		/*int i=0; 
		while(i>=0){
			//throw new RuntimeException("this command always fails");
			System.out.println(i);
			i++;
		 }*/
		 return DAO.getProductoDAO().getProductoById(id);
	 }
	
	@RequestMapping(
			  value = "/productos/{id}", 
			  method = RequestMethod.DELETE
			  )
	 public void delProducto(@PathVariable(value="id") Integer id) {
		 DAO.getProductoDAO().delProductoById(id);
	 }
	
	
	@RequestMapping(
			  value = "/productos", 
			  method = RequestMethod.POST,
			  consumes = "application/json"
			  )
	 public void addProducto(@RequestBody Producto p) {
		 DAO.getProductoDAO().addProducto(p);
	 }
	
}
