package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends ConfigPage{

	
		/** Método para logar no site
	 * @param email a ser preenchido no campo referente ao email.
	 * @param senha a ser preenchida no campo referente a senha
	 */
	public void logar(String username, String password) {
		
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		getDriver().findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[2]/td[2]/input")).click();
		getDriver().findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[2]/td[2]/input")).sendKeys(username);
		getDriver().findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[3]/td[2]/input")).click();
		getDriver().findElement(By.xpath("html/body/div[3]/form/table/tbody/tr[3]/td[2]/input")).sendKeys(password);
		WebElement botao = getDriver().findElement(By.className("button"));
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		botao.click();
	}
	
	public String checkLoginSucesso(){
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement nome = getDriver().findElement(By.xpath("html/body/table[1]/tbody/tr/td[1]/span[1]"));
		return nome.getText();
	}
	
	public void logout(){
		getDriver().findElement(By.xpath(".//*[text()='Logout']")).click();
	}
	
	public Boolean checkLogout(){
		return getDriver().findElement(By.name("login_form")).isDisplayed();
	}

	public String checkLoginErro(){
		return getDriver().findElement(By.xpath("html/body/div[2]/font")).getText();
	}
	
}
