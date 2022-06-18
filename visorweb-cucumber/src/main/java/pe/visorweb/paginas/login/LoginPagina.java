package pe.visorweb.paginas.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagina {

	@FindBy(id = "txtUsuario")
	private WebElement txtUsuario;
	
	@FindBy(id = "txtClave")
	private WebElement txtClave;
	
	@FindBy(id = "btnIniciarSesion")
	private WebElement btnIniciarSesion;
	
	private WebDriver driver;
	
	public LoginPagina(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void iniciarSesion(String usuario, String clave) {
		txtUsuario.clear();
		txtUsuario.sendKeys(usuario);
		
		txtClave.clear();
		txtClave.sendKeys(clave);
		
		btnIniciarSesion.click();
	}
	
	public void cargar(String url) {
		this.driver.get(url);
	}
	
}
















