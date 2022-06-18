package pe.visorweb.categoria.insertar;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoriaInsertarSteps {

    @Given("cargo la página login del aplicativo Visor Web")
	public void cargarPaginaVisorWeb() {
        System.out.println("cargar pagina visor web...");
    }

    @And("inicio sesión con el usuario {string} y la clave {string}")
    public void iniciarSesion(String usuario, String clave) {
        System.out.println("iniciar sesion el usuario: " + usuario + " y clave: " + clave);
    }

    @When("ingreso a la pagina registrar categoría")
    public void cargarPaginaRegistrarCategoria() {
        System.out.println("cargando pagina registrar categoría...");
    }

    @And("escribo la categoría {string} y hago clic en el botón guardar")
    public void registrarCategoria(String nombreCategoria) {
        System.out.println("registrar categoria: "  + nombreCategoria);
    }

    @Then("el aplicativo muestra el mensaje {string}")
    public void obtenerRespuesta(String mensajeEsperado) {
        System.out.println("valor obtenido == " + mensajeEsperado);
    }
	
}
