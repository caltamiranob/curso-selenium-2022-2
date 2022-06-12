package pe.visorweb.categoria;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import pe.visorweb.driver.VisorWebDriver;
import pe.visorweb.driver.VisorWebDriver.NavegadorWeb;
import pe.visorweb.paginas.categoria.PaginaRegistrarCategoria;
import pe.visorweb.paginas.login.LoginPagina;

public class CategoriaInsertarCsvTest {

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
	
	@ParameterizedTest
	@CsvFileSource(resources = "/categoria/datos-insertar-categoria.csv", numLinesToSkip = 1)
	public void testInsertarCategoria(
			String usuario,
			String clave,
			String nombreCategoria,
			String mensajeEsperado
			) throws InterruptedException {
		
		paginaLogin.cargar(url);
		paginaLogin.iniciarSesion(usuario, clave);
		
		paginaRegistrarCategoria.cargar();
		paginaRegistrarCategoria.guardar(nombreCategoria);
		
		Assertions.assertEquals(mensajeEsperado, paginaRegistrarCategoria.getMensajeObtenido());
		
	}
	
}
