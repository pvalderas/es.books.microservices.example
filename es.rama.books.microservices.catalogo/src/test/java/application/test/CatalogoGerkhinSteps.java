package application.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration 
public class CatalogoGerkhinSteps {
	  @Autowired
	  private TestRestTemplate restTemplate;
	  
	  //Inputs
	  private Integer id;
	  private String nombre;
	  private String descripcion;
	  private Double precio;
	// output
	  private ResponseEntity<String> response; 
	  @Given("I use a id (.*), nombre (.*), descripcion (.*) and a precio (.*)")
	  public void getProducto(Integer id, String nombre, String descripcion, Double precio) {
	    this.id = id;
	    this.nombre = nombre;
	    this.descripcion = descripcion;
	    this.precio = precio;
	  }
	  @When("I request an expense creation")
	  public void requestProductoCreation() {
		  HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		  MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		  map.add("id", this.id);
		  map.add("nombre", this.nombre);
		  map.add("descripcion", this.descripcion);
		  map.add("precio", this.precio);
		  HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		  response = restTemplate.postForEntity( "/productos", request , String.class );
		  }	  
	  @Then("I should get a response with HTTP status code (.*)")
	  public void shouldGetResponseWithHttpStatusCode(int statusCode) {
	    assertThat(response.getStatusCodeValue()).isEqualTo(statusCode);
	  }	  
}
