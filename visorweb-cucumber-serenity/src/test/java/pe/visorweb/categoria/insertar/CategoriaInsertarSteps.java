package pe.visorweb.categoria.insertar;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import pe.visorweb.paginas.categoria.PaginaRegistrarCategoria;
import pe.visorweb.paginas.login.LoginPagina;

public class CategoriaInsertarSteps {

	@Managed
	private WebDriver driver;
	
	private LoginPagina paginaLogin;
	private PaginaRegistrarCategoria paginaRegistrarCategoria;
	
	@Before
	public void configuracionInicial() {
		driver.manage().window().maximize();
		paginaLogin = new LoginPagina(driver);
		paginaRegistrarCategoria = new PaginaRegistrarCategoria(driver);
	}
	
	@After
	public void liberarRecursos() {
		driver.close();
	}
	
    @Given("cargo la página login del aplicativo Visor Web")
	public void cargarPaginaVisorWeb() {
        paginaLogin.cargar("http://localhost:8080/VisorWeb/index.xhtml");
    }

    @And("inicio sesión con el usuario {string} y la clave {string}")
    public void iniciarSesion(String usuario, String clave) {
        paginaLogin.iniciarSesion(usuario, clave);
    }

    @When("ingreso a la pagina registrar categoría")
    public void cargarPaginaRegistrarCategoria() throws InterruptedException {
        paginaRegistrarCategoria.cargar();
    }

    @And("escribo la categoría {string} y hago clic en el botón guardar")
    public void registrarCategoria(String nombreCategoria) throws InterruptedException {
        paginaRegistrarCategoria.guardar(nombreCategoria);
    }

    @Then("el aplicativo muestra el mensaje {string}")
    public void obtenerRespuesta(String mensajeEsperado) {
        assertEquals(mensajeEsperado, paginaRegistrarCategoria.getMensajeObtenido());
    }
	
}
