package application.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import application.CatalogoHTTPController;
import application.domain.Producto;
import application.service.ProductoService;


@RunWith(MockitoJUnitRunner.class)
public class CatalogoHTTPControllerUnitTest {
	private CatalogoHTTPController catalogoController;
	@Mock
	private ProductoService productoService;	
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		catalogoController = new CatalogoHTTPController();
	}
	@Test
	public void test_getProductoPorId(){
		//Recuperamos el producto #1 del objeto mock
		Producto pMock = productoService.getProductoById(1);
		//Recuperamos el producto #1 del servicio
		Producto pService = catalogoController.getProductosJSON(1);
		assertEquals(pMock, pService);
	}
	@Test
	public void test_getProductos(){
		List<Producto> listaMock = productoService.getProductos();
		List<Producto> listaService = catalogoController.listaProductosJSON();
		assertEquals(listaMock, listaService);
	}
}
