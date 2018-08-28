package cursoselenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class TesteCampoTreinamento {

	/*
	 * O texto irá escrever no campo de texto de depois fazer uma verificação se o
	 * valor digitado está no atributo
	 */
	
	@Test
	public void testeTextField() {
		// indicando aonde está salvo o driver para acesso
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		// Localizando o campo e passando informações nele
		driver.findElement(By.id("elementosForm:nome")).sendKeys("testando e agora vai");
		// Verificando o texto digitado
		Assert.assertEquals("testando e agora vai", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		// Para dar erro no teste
		// --Assert.assertEquals("testando e agora vai1",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}

	/*
	 * o teste irá escrever no campo de texto e depois fazer uma verificação se o
	 * valor digitado está no atributo
	 */
	
	@Test
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}

	/*
	 * o teste irá marcar o radio e depois verificar se a opção marcada foi de fato
	 * a escolhida
	 */
	
	@Test
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		// Clicando no elemento de check box
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		// Fazendo checagem em um condicional
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());

	}

	/*
	 * O teste irá marcar o checkbox e depois verificar se a opção marcada foi de
	 * fato a escolhida
	 */
	
	@Test
	public void deveInteragirComCheckBox() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		// Clicando no checkBox
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		// Fazendo a checagem para saber se está marcado
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());

	}

	/*
	 * O teste irá marca o combo e depois verificar a opção marcada de acordo com a
	 * escolhida
	 */
	
	@Test
	public void deveInteragirComCombo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		// Selecionando no combobox
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		// Selecionando por index , elementos que estão enumerados no html
		// --combo.selectByIndex(2);
		// Selecionando por valor, aquilo que apresenta no value (elemento html) do combo
		// --combo.selectByValue("superior");
		// Selecionando pelo texto que está sendo exibido no combo
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
	}

	/* Irá verificar as opções disponiveis no combo e validar se a marcada existe */
	@Test	
	public void deveVerificarValoresCombo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		// Selecionando no combobox
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		// Retorna uma lista de opções de webelement o combo
		List<WebElement> options = combo.getOptions();
		// Verifica a quantidade de opções do combo
		Assert.assertEquals(8, options.size());
		/* Fazendo uma condição para verificar se o valor existe no combo */
		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}

		}
		Assert.assertTrue(encontrou);
	}

	/* Irá marcar várias opções do combo e verificar quantas foram marcadas */
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		// Selecionando no combox com várias opções
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		// Selecionando vários elementos
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");

		// Depois de selecionada as tres opções, verificando se as 3 foram marcadas
		List<WebElement> allSelectOption = combo.getAllSelectedOptions();
		// Validade quantidade opção selecionadas
		Assert.assertEquals(3, allSelectOption.size());

		// Deselecionando a opção natação e validade que duas opções ficaram
		combo.deselectByVisibleText("Natacao");
		Assert.assertEquals(2, allSelectOption.size());

	}
	
	/*Irá clicar no botão e validar o valor que ficará no mesmo depois do click*/
	
	@Test
	public void deveInteragirComBotoes() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		// Para nao fazer duas buscas de elemento, colocamos o valor em uma instancia de webelement
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		// clicando no botão a partir da variavel que acabamos de criar acima
		botao.click();
		// fazendo uma asserção a partir da variavel que acabamod de criar, atraves do
		// atributo do botão em seu valor
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

	}
	
	/*Irá clicar no link, mas ainda não fará nada*/
	
	@Test
	//@Ignore // Ignorar este
	public void deveInteragirComLinks() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Voltar")).click();
		// Irá falhar o teste
		//--Assert.fail();
		
		//Buscando pelo id do botão
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
		
	/*Irá realizar a busca de um elemento na tela*/
	
	@Test
	public void deveBuscarTextosNaPagina() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nathalia.santos\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.manage().window().maximize();
		
		//Realizando busca por elemento na tela e printando no console
		//--System.out.println(driver.findElement(By.tagName("body")).getText());
		
		// Verificar  que contém np body que é string, apesar de funcionar não é viavel e nao mostra aonde está
		//--Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		
		//Verificando através da tag que o texto se encontra "h3"
		Assert.assertEquals("Campo de Treinamento",
				driver.findElement(By.tagName("h3")).getText());
		
		// Buscando elementos pelo elemento do html e trará todos que correspondam ao elemento buscado
		//--Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.tagName("span")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());

			}
}