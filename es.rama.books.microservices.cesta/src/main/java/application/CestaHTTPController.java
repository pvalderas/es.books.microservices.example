package application;
import java.io.IOException;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import application.dao.DAO;
import application.domain.Producto;
import application.eureka.EurekaClient;
 
@RestController 
public class CestaHTTPController {
	
	@Autowired
	private EurekaClient eureka;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}
	
	@HystrixCommand
	@RequestMapping(
			  value = "/cesta", 
			  method = RequestMethod.GET, 
			  produces = "application/json")
	 public List<Producto> cesta() throws IOException, JSONException {
			
		return DAO.getCestaDAO().getProductos();
	 }
	
	@RequestMapping(
			  value = "/cesta/producto/{id}", 
			  method = RequestMethod.DELETE)
	 public void delProductoCesta(@PathVariable(value="id") Integer id) throws IOException, JSONException {
		DAO.getCestaDAO().delProductoById(id);
	 }
	
	@HystrixCommand(fallbackMethod="fallbackMethod")
	@RequestMapping(
			  value = "/cesta/producto/{id}", 
			  method = RequestMethod.POST
			  )
	 public void addProductoCesta(@PathVariable(value="id") Integer id) throws IOException, JSONException {
		
		//URI catalogoURI=eureka.getUri("SERVICIO.CATALOGO");
		//Producto p=restTemplate.getForObject(catalogoURI.resolve("/productos/"+id), Producto.class);
		
		Producto p=restTemplate.getForObject("http://SERVICIO.CATALOGO/productos/"+id, Producto.class);
		DAO.getCestaDAO().addProducto(p);

	 }
	
	private void fallbackMethod(Integer id){
		System.out.println("Entro ");
	}
	

}
