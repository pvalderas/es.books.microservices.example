package application.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import application.CatalogoHTTPController;
import application.service.ProductoService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=CatalogoHTTPController.class)
public class CatalogoHTTPControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ProductoService productoService;	
	
	private static final String PRODUCTO_TO_JSON =
		      "{"
		          + "'id': '1',"
		          + "'nombre':'Apple iPhone 8 Plus',"
		          + "'descripcion':'Smartphone con pantalla de 13,9 cm (64 GB, Gris espacial)',"
		          + "'precio':'571.9'"
		      + "}";
	
	@Test
	public void test_getProductoPorId() throws Exception {
		MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/productos/1")
                                .accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json(PRODUCTO_TO_JSON));
	}
	@Test
	public void test_getProductos() throws Exception{
		MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/productos")
                                .accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(builder)
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
