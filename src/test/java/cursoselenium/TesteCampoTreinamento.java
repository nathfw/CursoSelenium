package cursoselenium;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {

	@Test
	public void  testeTextField () {
			// indicando aonde está salvo o driver para acesso
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			driver.manage().window().maximize();
			
			
			//driver.quit();
	}
	
}
