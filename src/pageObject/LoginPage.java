package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends ConfigPage{

		/** Método para logar no site
	 * @param email a ser preenchido no campo referente ao email.
	 * @param senha a ser preenchida no campo referente a senha
	 */
	public void logar(String username, String password) {
		WebElement emailElement = getDriver().findElement(By.name("username"));
		WebElement senhaElement = getDriver().findElement(By.name("password"));
		WebElement botao = getDriver().findElement(By.className("button"));
		emailElement.clear();
		emailElement.sendKeys(username);
		senhaElement.clear();
		senhaElement.sendKeys(password);
		botao.click();
	}
	
	public String checkLoginSucesso(){
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
