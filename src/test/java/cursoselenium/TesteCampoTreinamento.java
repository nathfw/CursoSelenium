package cursoselenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TesteCampoTreinamento {

	@Test
	public void  testeTextField () {
			// indicando aonde está salvo o driver para acesso
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			driver.manage().window().maximize();
			// Localizando o campo e passando informações nele
			driver.findElement(By.id("elementosForm:nome")).sendKeys("testando e agora vai");
			// Verificando o texto digitado 
			Assert.assertEquals("testando e agora vai",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
			//Para dar erro no teste
			//Assert.assertEquals("testando e agora vai1",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
			driver.quit();
	}
	
}
