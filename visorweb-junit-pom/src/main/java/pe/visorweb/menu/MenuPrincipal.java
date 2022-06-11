package pe.visorweb.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPrincipal {

	@FindBy(xpath = "//div[@class=\"menu\"]/div[1]")
	private WebElement menuHamburguesa;
	
	@FindBy(xpath = "//span[contains(text(), \"Mod. de Almac�n\")]")
	private WebElement menuModuloAlmacen;
	
	@FindBy(linkText = "Mnt. de Categor�a")
	private WebElement menuMantenimientoCategoria;
	
	
	
}
