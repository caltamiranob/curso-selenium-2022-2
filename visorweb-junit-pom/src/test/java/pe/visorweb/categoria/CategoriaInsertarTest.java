package pe.visorweb.categoria;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorWebDriver;
import pe.visorweb.driver.VisorWebDriver.NavegadorWeb;
import pe.visorweb.paginas.categoria.PaginaRegistrarCategoria;
import pe.visorweb.paginas.login.LoginPagina;

public class CategoriaInsertarTest {

	private static WebDriver driver;
	private static LoginPagina paginaLogin;
	private static PaginaRegistrarCategoria paginaRegistrarCategoria;
	
	private String url = "http://localhost:8080/VisorWeb/index.xhtml";
	
	@BeforeAll
	public static void configuracionInicial() {
		driver = VisorWebDriver.obtenerInstancia(NavegadorWeb.CHROME);
		paginaLogin = new LoginPagina(driver);
		paginaRegistrarCategoria = new PaginaRegistrarCategoria(driver);
	}

	@AfterAll
	public static void liberarRecursos() {
		driver.close();
	}
	
	@Test
	public void testInsertarCategoriaExitosa() throws InterruptedException {
		paginaLogin.cargar(url);
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaRegistrarCategoria.cargar();
		paginaRegistrarCategoria.guardar("Categoria con Page Object Model");
		
		String mensajeEsperado = "Se guardó de manera correcta la Categoría";
		String mensajeObtenido = paginaRegistrarCategoria.getMensajeObtenido();
		
		Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
		
	}
	
	@Test
	public void testInsertarCategoriaVacia() throws InterruptedException {
		paginaLogin.cargar(url);
		paginaLogin.iniciarSesion("admin", "clave");
		
		paginaRegistrarCategoria.cargar();
		paginaRegistrarCategoria.guardar("");
		
		String mensajeEsperado = "Nombre: Error de validación: se necesita un valor.";
		String mensajeObtenido = paginaRegistrarCategoria.getMensajeObtenido();
		
		Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
		
	}
	
	
	
}
