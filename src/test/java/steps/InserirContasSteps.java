package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jonathan\\drivers\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://seubarriga.wcaquino.me/login");
    }

    @Quando("informo o usuário {string}")
    public void informoOUsuário(String string) {
        driver.findElement(By.id("email")).sendKeys(string);
    }

    @Quando("a senha {string}")
    public void aSenha(String string) {
        driver.findElement(By.id("senha")).sendKeys(string);
    }

    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        SoftAssert softAssert = new SoftAssert();

        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

        softAssert.assertEquals("Bem vindo, Jkevin!", texto, "Validação tela inicial");

        softAssert.assertAll();
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
       driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("informo a conta {string}")
    public void informoAConta(String string) {
        driver.findElement(By.id("nome")).sendKeys(string);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("a conta é inserida com sucesso")
    public void aContaÉInseridaComSucesso() {
        SoftAssert softAssert = new SoftAssert();

        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

        softAssert.assertEquals("Conta adicionada com sucesso!", texto, "Validação tela inicial");

        softAssert.assertAll();
    }
}