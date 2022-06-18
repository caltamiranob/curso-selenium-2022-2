package pe.visorweb.paginas.categoria;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pe.visorweb.menu.MenuPrincipal;

public class PaginaRegistrarCategoria {

	@FindBy(id = "txtNombre")
	private WebElement txtNombre;
	
	@FindBy(id = "btnGuardar")
	private WebElement btnGuardar;
	
	@FindBy(id = "btnVolver")
	private WebElement btnVolver;
	
	@FindBy(id = "messages")
	private WebElement lblMensaje;
	
	private WebDriver driver;
	
	private MenuPrincipal menuPrincipal;

	private String mensajeObtenido;
	
	public PaginaRegistrarCategoria(WebDriver driver) {
		this.driver = driver;
		this.menuPrincipal = new MenuPrincipal(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void cargar() throws InterruptedException {
		menuPrincipal
			.cargarPaginaMantenimientoCategoria()
				.cargarPaginaRegistrarCategoria();
	}
	
	public void guardar(String nombreCategoria) throws InterruptedException {
		txtNombre.clear();
		txtNombre.sendKeys(nombreCategoria);
		
		btnGuardar.click();
		
		Thread.sleep(2000);
		this.mensajeObtenido = lblMensaje.getText();
		
	}
	
	public String getMensajeObtenido() {
		return this.mensajeObtenido;
	}
	
}








