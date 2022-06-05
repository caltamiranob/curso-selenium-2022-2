package pe.visorweb.categoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CategoriaInsertarTest {
	
	@Test
	void testInsertarCategoriaExitosa() throws Exception {
		
		//1. configurar el driver (chrome -> chromedriver | firefox -> geckodriver | Ref: https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/)
		WebDriverManager.chromedriver().setup();
		
		//2. crear instancia de la interfaz WebDriver (ChromeDriver | FirefoxDriver | ...)
		WebDriver driver = new ChromeDriver();

		//3. abrir navegador y cargar la pï¿½gina: http://localhost:8080/VisorWeb/index.xhtml
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
		
		//7. ubicar el botï¿½n iniciar sesiï¿½n y hacer clic
		WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
		btnIniciarSesion.click();
		
		//8. ubicar el menï¿½ hamburguesa y hacer clic
		Thread.sleep(1000);
		WebElement menuHamburguesa = driver.findElement(By.xpath("//div[@class=\"menu\"]/div[1]"));
		menuHamburguesa.click();
		
		//9. ubicar el menï¿½ "mod. de almacï¿½n" y hacer clic
		Thread.sleep(1000);
		WebElement menuModuloAlmacen = driver.findElement(By.xpath("//span[contains(text(), \"Mod. de Almacén\")]"));
		menuModuloAlmacen.click();
		
		//10. ubicar el menï¿½ "mnt. categorï¿½a" y hacer clic
		Thread.sleep(1000);
		//WebElement menuMntCategoria = driver.findElement(By.xpath("//a[text()=\"Mnt. de CategorÃ­a\"]"));
		WebElement menuMntCategoria = driver.findElement(By.linkText("Mnt. de Categoría"));
		menuMntCategoria.click();
		
		//11. ubicar el botï¿½n nuevo y hacer clic
		WebElement btnNuevo = driver.findElement(By.id("btnNuevo"));
		btnNuevo.click();
		
		//12. ubicar la caja de texto nombre y escribir la palabra "Selenium"
		WebElement txtNombre = driver.findElement(By.id("txtNombre"));
		txtNombre.sendKeys("Selenium Web Driver");
		
		//13. ubicar el botï¿½n "Guardar" y hacer clic
		WebElement btnGuardar = driver.findElement(By.id("btnGuardar"));
		btnGuardar.click();

		//14. ubicar el mensaje de respuesta obtenido y guardarlo
		Thread.sleep(2000);
		String mensajeEsperado = "Se guardó de manera correcta la Categoría";
		String mensajeObtenido = driver.findElement(By.id("messages")).getText();
		
		//15. punto de verificaciï¿½n: mensajeObtenidd == "Se guardï¿½ de manera correcta la Categorï¿½a"
		Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
		
		//16. cerramos el navegador
		Thread.sleep(2000);
		driver.quit();
		
		
	}
	
	
	
	@Test
	void testInsertarCategoriaVacia() throws Exception {
		
		//1. configurar el driver (chrome -> chromedriver | firefox -> geckodriver | Ref: https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/)
		WebDriverManager.chromedriver().setup();
		
		//2. crear instancia de la interfaz WebDriver (ChromeDriver | FirefoxDriver | ...)
		WebDriver driver = new ChromeDriver();

		//3. abrir navegador y cargar la pï¿½gina: http://localhost:8080/VisorWeb/index.xhtml
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
		
		//7. ubicar el botï¿½n iniciar sesiï¿½n y hacer clic
		WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
		btnIniciarSesion.click();
		
		//8. ubicar el menï¿½ hamburguesa y hacer clic
		Thread.sleep(1000);
		WebElement menuHamburguesa = driver.findElement(By.xpath("//div[@class=\"menu\"]/div[1]"));
		menuHamburguesa.click();
		
		//9. ubicar el menï¿½ "mod. de almacï¿½n" y hacer clic
		Thread.sleep(1000);
		WebElement menuModuloAlmacen = driver.findElement(By.xpath("//span[contains(text(), \"Mod. de Almacén\")]"));
		menuModuloAlmacen.click();
		
		//10. ubicar el menï¿½ "mnt. categorï¿½a" y hacer clic
		Thread.sleep(1000);
		//WebElement menuMntCategoria = driver.findElement(By.xpath("//a[text()=\"Mnt. de CategorÃ­a\"]"));
		WebElement menuMntCategoria = driver.findElement(By.linkText("Mnt. de Categoría"));
		menuMntCategoria.click();
		
		//11. ubicar el botï¿½n nuevo y hacer clic
		WebElement btnNuevo = driver.findElement(By.id("btnNuevo"));
		btnNuevo.click();
		
		//12. ubicar la caja de texto nombre y escribir la palabra "Selenium"
		WebElement txtNombre = driver.findElement(By.id("txtNombre"));
		txtNombre.sendKeys("");
		
		//13. ubicar el botï¿½n "Guardar" y hacer clic
		WebElement btnGuardar = driver.findElement(By.id("btnGuardar"));
		btnGuardar.click();

		//14. ubicar el mensaje de respuesta obtenido y guardarlo
		Thread.sleep(2000);
		String mensajeEsperado = "Nombre: Error de validación: se necesita un valor.";
		String mensajeObtenido = driver.findElement(By.id("messages")).getText();
		
		//15. punto de verificaciï¿½n: mensajeObtenidd == "Se guardï¿½ de manera correcta la Categorï¿½a"
		Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
		
		//16. cerramos el navegador
		Thread.sleep(2000);
		driver.quit();
		
		
	}
	
	
}





