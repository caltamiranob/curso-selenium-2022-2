package pe.visorweb.categoria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CategoriaListarTest {

	@Test
	void testFiltrarConNombre() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/VisorWeb/index.xhtml");
		driver.manage().window().maximize();
		
		WebElement txtUsuario = driver.findElement(By.id("txtUsuario"));
		txtUsuario.clear();
		txtUsuario.sendKeys("admin");
		
		WebElement txtClave = driver.findElement(By.id("txtClave"));
		txtClave.clear();
		txtClave.sendKeys("clave");
		
		WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
		btnIniciarSesion.click();
		
		Thread.sleep(1000);
		WebElement menuHamburguesa = driver.findElement(By.xpath("//div[@class=\"menu\"]/div[1]"));
		menuHamburguesa.click();
		
		Thread.sleep(1000);
		WebElement menuModuloAlmacen = driver.findElement(By.xpath("//span[contains(text(), \"Mod. de Almacén\")]"));
		menuModuloAlmacen.click();
		
		Thread.sleep(1000);
		WebElement menuMntCategoria = driver.findElement(By.linkText("Mnt. de Categoría"));
		menuMntCategoria.click();
		
		String filtro = "SELENIUM";
		WebElement txtFiltro = driver.findElement(By.id("txtFiltro"));
		txtFiltro.sendKeys(filtro);
		
		WebElement btnFiltrar = driver.findElement(By.id("btnFiltrar"));
		btnFiltrar.click();
		
		Thread.sleep(1000);
		List<WebElement> filas = driver.findElements(By.xpath("//tbody[@id=\"tablaCategorias_data\"]/tr"));
		System.out.println("Cantidad de filas encontradas: " + filas.size());
		assertTrue(filas.size() >= 1);
		
		String xpathCelda = "//tbody[@id=\"tablaCategorias_data\"]/tr/td[contains(text(), \"" + filtro +"\")]";
		WebElement celdaNombre = driver.findElement(By.xpath(xpathCelda));
		System.out.println("valor de celda: " + celdaNombre.getText());
		assertEquals(filtro, celdaNombre.getText());
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
}








