package testeselenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastroCampoTreinamento {

	@Test
	public void preencheTodosOsCampos() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + 
			"/src/main/resources/campoTreinamento.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Lucas");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Monteiro");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		
		Select selectEscolaridade = new Select(driver.findElement(By.
			id("elementosForm:escolaridade")));
		selectEscolaridade.selectByVisibleText("Superior");
		
		Select selectEsporte = new Select(driver.findElement(By.
			id("elementosForm:esportes")));
		selectEsporte.selectByVisibleText("Futebol");
		selectEsporte.selectByVisibleText("Corrida");
		
		driver.findElement(By.id("elementosForm:sugestoes")).
			sendKeys("Mudar a cor do formulário para verde.");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
				
		Assert.assertEquals("Cadastrado!", driver.findElement(By.
			xpath("//div[@id='resultado']/span")).getText());
		Assert.assertEquals("Lucas", driver.findElement(By.
			xpath("//div[@id='descNome']/span")).getText());
		Assert.assertEquals("Monteiro", driver.findElement(By.
			xpath("//div[@id='descSobrenome']/span")).getText());
		Assert.assertEquals("Masculino", driver.findElement(By.
			xpath("//div[@id='descSexo']/span")).getText());
		Assert.assertEquals("Pizza", driver.findElement(By.
			xpath("//div[@id='descComida']/span")).getText());
		Assert.assertEquals("superior", driver.findElement(By.
			xpath("//div[@id='descEscolaridade']/span")).getText());
		Assert.assertEquals("Futebol Corrida", driver.findElement(By.
			xpath("//div[@id='descEsportes']/span")).getText());
		Assert.assertEquals("Mudar a cor do formulário para verde.", 
			driver.findElement(By.xpath("//div[@id='descSugestoes']/span")).getText());
		
		driver.quit();		
	}
}
