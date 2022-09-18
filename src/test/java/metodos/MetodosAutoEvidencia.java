package metodos;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MetodosAutoEvidencia {

	WebDriver driver;

	public void abrirUrl(String url) {

		// Caminho da pasta Driver google
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

	public void validarTexto(String textoEsperado) {
		// Valida o texto esperado e captura a Url
		// Armazena o texto na String texto
		String texto = driver.getTitle();
		// Captura a Url
		String currentUrl = driver.getCurrentUrl();
		// Imprimi a url capturada
		System.out.println(currentUrl);
		// Faz a comparação entre o texto encontrado e o esperado.
		assertEquals(textoEsperado, texto);

	}

	public void delay(String pausa) throws InterruptedException {

		// Tempo que pode ser utilizado para preenchimento elementos ou tirar evidencias
		Thread.sleep(0);

	}

	public void fecharNavegador() {

		// Fecha os testes ao final
		driver.quit();

	}

	public void EvidenciaDoTeste(String nomeEvidencia) throws IOException {
		// Variavel que Libera a permissão para uso do print
		TakesScreenshot scrAshot = (TakesScreenshot) driver;
		// Variavel que recebe o print da camera foto
		File scrFile = scrAshot.getScreenshotAs(OutputType.FILE);
		// Pega o arquivo scrFile e aramzena no diretorio evidencia.
		File desFile = new File("./evidencias/" + nomeEvidencia + ".png");
		FileUtils.copyFile(scrFile, desFile);

	}

}
