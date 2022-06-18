package pe.visorweb.paginas.categoria;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pe.visorweb.menu.MenuPrincipal;

public class PaginaMantenimientoCategoria {

	@FindBy(id = "btnNuevo")
	private WebElement btnNuevo;

	private MenuPrincipal menuPrincipal;
	
	private WebDriver driver;
	
	public PaginaMantenimientoCategoria(WebDriver driver) {
		this.driver = driver;
		this.menuPrincipal = new MenuPrincipal(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void cargarPaginaRegistrarCategoria() {
		btnNuevo.click();
	}
	
	public void cargar() throws InterruptedException {
		menuPrincipal
			.cargarPaginaMantenimientoCategoria();
	}
	
}
