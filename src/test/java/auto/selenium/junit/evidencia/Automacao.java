package auto.selenium.junit.evidencia;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import metodos.MetodosAutoEvidencia;

public class Automacao {

	MetodosAutoEvidencia metodos = new MetodosAutoEvidencia();

	@Before
	public void setUp() throws Exception {

		metodos.abrirUrl("https://www.amazon.com.br");

	}

	@After
	public void tearDown() throws Exception {

		metodos.fecharNavegador();

	}

	@Test
	public void google() throws InterruptedException, IOException {

		metodos.validarTexto("Amazon.com.br | Tudo pra você, de A a Z.");
		metodos.EvidenciaDoTeste("CT01 - validando teste");

	}

}
