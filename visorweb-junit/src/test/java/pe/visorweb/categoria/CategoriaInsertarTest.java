package pe.visorweb.categoria;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CategoriaInsertarTest {
	
	@Test
	void testInsertarCategoriaExitosa() throws Exception {
		
		//1. configurar el driver (chrome -> chromedriver | firefox -> geckodriver | Ref: https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/)
		WebDriverManager.chromedriver().setup();
		
		//2. crear instancia de la interfaz WebDriver (ChromeDriver | FirefoxDriver | ...)
		WebDriver driver = new ChromeDriver();

		//3. abrir navegador y cargar la p�gina: http://localhost:8080/VisorWeb/index.xhtml
		driver.get("http://localhost:8080/VisorWeb/index.xhtml");
		
		//4. maximizar la ventana del navegador
		driver.manage().window().maximize();
		
		//5. ubicar la caja de texto usuario y escribir la palabra admin
		WebElement txtUsuario = driver.findElement(By.id("txtUsuario"));
		txtUsuario.clear();
		txtUsuario.sendKeys("admin");
		
		//6. ubicar la caja de texto clave y escribir la palabra clave
		WebElement txtClave = driver.findElement(By.id("txtClave"));
		txtClave.clear();
		txtClave.sendKeys("clave");
		
		//7. ubicar el bot�n iniciar sesi�n y hacer clic
		WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
		btnIniciarSesion.click();
		
		//8. ubicar el men� hamburguesa y hacer clic
		Thread.sleep(1000);
		WebElement menuHamburguesa = driver.findElement(By.xpath("//div[@class=\"menu\"]/div[1]"));
		menuHamburguesa.click();
		
		//9. ubicar el men� "mod. de almac�n" y hacer clic
		Thread.sleep(1000);
		WebElement menuModuloAlmacen = driver.findElement(By.xpath("//span[contains(text(), \"Mod. de Almacén\")]"));
		menuModuloAlmacen.click();
		
		//10. ubicar el men� "mnt. categor�a" y hacer clic
		Thread.sleep(1000);
		//WebElement menuMntCategoria = driver.findElement(By.xpath("//a[text()=\"Mnt. de Categoría\"]"));
		WebElement menuMntCategoria = driver.findElement(By.linkText("Mnt. de Categoría"));
		menuMntCategoria.click();
		
		//11. ubicar el bot�n nuevo y hacer clic
		WebElement btnNuevo = driver.findElement(By.id("btnNuevo"));
		btnNuevo.click();
		
		//12. ubicar la caja de texto nombre y escribir la palabra "Selenium"
		WebElement txtNombre = driver.findElement(By.id("txtNombre"));
		txtNombre.sendKeys("Selenium Web Driver");
		
		//13. ubicar el bot�n "Guardar" y hacer clic
		WebElement btnGuardar = driver.findElement(By.id("btnGuardar"));
		btnGuardar.click();

		//14. ubicar el mensaje de respuesta obtenido y guardarlo
		Thread.sleep(2000);
		String mensajeEsperado = "Se guardó de manera correcta la Categoría";
		String mensajeObtenido = driver.findElement(By.id("message")).getText();
		
		//15. punto de verificaci�n: mensajeObtenidd == "Se guard� de manera correcta la Categor�a"
		
		
		
	}
	
	
}





