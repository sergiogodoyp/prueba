import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJenkins {


    protected static WebDriver driver = null;

    @BeforeEach
    void lanzarNavegador(){
        driver = crearChromeDriver();
        driver.manage().window().maximize();


    }

    @AfterEach
    void cerrarNavegador(){
        driver.quit();
    }

    @Test
    void test01(){
        driver.get("http://www.amazon.com");
    }

    @Test
    void test02(){
        driver.get("https://the-internet.herokuapp.com/");
        WebElement formAuthenticationLink = driver.findElement(By.linkText("Form Authentication"));
        formAuthenticationLink.click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");
        WebElement login = driver.findElement(By.className("radius"));
        login.submit();
        String mensajeActual = driver.findElement(By.className("success")).getText();
        String mensajeEsperado = "You logged into a secure area!";
        assertTrue(mensajeActual.contains(mensajeEsperado), "Login Incorrecto");
    }

    public static WebDriver crearChromeDriver(){
        return new ChromeDriver();
    }
}