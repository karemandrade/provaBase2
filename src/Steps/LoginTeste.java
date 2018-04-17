package Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pageObject.ConfigPage;
import pageObject.LoginPage;

public class LoginTeste {

	LoginPage login = new LoginPage();
	ConfigPage config = new ConfigPage();

	@Before
	public void acessar() throws InterruptedException {
		config.setUp();
	}

	// logar com sucesso e validar usuário exibido
	@Test
	public void logarComSucesso() throws InterruptedException {
		login.logar("karem.andrade", "12345678");
		Thread.sleep(1000);
		assertTrue(login.checkLoginSucesso().equals("karem.andrade"));
	}

	// Deslogar do site
	@Test
	public void realizarLogout() {
		login.logout();
		assertTrue(login.checkLogout());
	}

	// tentar logar com usuário inválido e comparar a mensagem exibida
	@Test
	public void logarComErro() throws InterruptedException {
		login.logar("invalido@sambatech.com.br", "123456789");
		Thread.sleep(1000);

		assertEquals(login.checkLoginErro(),
				"Your account may be disabled or blocked or the username/password you entered is incorrect.");
	}

}
