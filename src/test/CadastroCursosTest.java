package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastroCursosTest {

	WebDriver driver;

	@Dado("^Acessar a pagina de cadastro de curso$")
	public void acessar_a_pagina_de_cadastro_de_curso() {

		// definindo o local onde esta o driver do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\teste\\chromedriver.exe");

		// Abrindo o google chrome
		driver = new ChromeDriver();

		// Maximizando a janela do navegador
		driver.manage().window().maximize();

		// Acessando a pagina de cadastro de funcionario
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio08");

	}

	@Dado("^Informar o nome do curso \"([^\"]*)\"$")
	public void informar_o_nome_do_curso(String NomeCurso) {

		driver.findElement(By.xpath("//*[@id=\"NomeCurso\"]")).sendKeys(NomeCurso);

	}

	@Dado("^Informar a carga horaria \"([^\"]*)\"$")
	public void informar_a_carga_horaria(String CargaHoraria) {

		driver.findElement(By.xpath("//*[@id=\"CargaHoraria\"]")).sendKeys(CargaHoraria);

	}

	@Dado("^Selecionar a disciplina \"([^\"]*)\"$")
	public void selecionar_a_disciplina(String Disciplina) {

		new Select(driver.findElement(By.xpath("//*[@id=\"Disciplina\"]"))).selectByVisibleText(Disciplina);

	}

	@Dado("^Selecionar o professor \"([^\"]*)\"$")
	public void selecionar_o_professor(String Professor) {

		new Select(driver.findElement(By.xpath("//*[@id=\"Professor\"]"))).selectByVisibleText(Professor);

	}

	@Quando("^solicitar a realizacao do cadastro$")
	public void solicitar_a_realizacao_do_cadastro() {

		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

	}

	@Então("^o sistema exibea a mensagem \"([^\"]*)\"$")
	public void o_sistema_exibea_a_mensagem(String resultado) {

		// ler a mensagem exibida na tela do sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();

		// Gerar a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String dataAtual = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());

			FileUtils.copyFile(file, new File("c:\\cucumber\\Cadastro de Cursos " + dataAtual + ".png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

	@Entao("^sistema exibe para cada campo a mensagem \"([^\"]*)\"$")
	public void sistema_exibe_para_cada_campo_a_mensagem(String arg1) {

		// ler a mensagem de erro exibida em cada campo
		String erroCurso = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/div[1]/div/span")).getText();
		String erroHoraria = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/div[2]/div/span"))
				.getText();
		String erroDisciplina = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/div[3]/div/span"))
				.getText();
		String erroProfessor = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div/div/span")).getText();

		// comparar o conteudo de cada mensagem
		assertEquals(erroCurso, "Campo obrigatório");
		assertEquals(erroHoraria, "Campo obrigatório");
		assertEquals(erroDisciplina, "Campo obrigatório");
		assertEquals(erroProfessor, "Campo obrigatório");

		// Gerar a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			String dataAtual = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());

			FileUtils.copyFile(file, new File("c:\\cucumber\\Validacao Cadastro de Cursos " + dataAtual + ".png"));
		} catch (Exception e) {

		}

		// fechar o navegador
		driver.close();
		driver.quit();

	}

}
