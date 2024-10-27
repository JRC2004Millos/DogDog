package com.example.demo.e2e;

import java.time.Duration;

import org.junit.Before; // Cambiado a JUnit 4
import org.junit.After;
import org.junit.Test; // JUnit 4
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class NuevoUsuario {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before // JUnit 4
    public void init() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        // chromeOptions.addArguments("--headless"); Opcional

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /*
     * @After // JUnit 4
     * public void tearDown() {
     * if (driver != null) {
     * driver.quit(); // Asegura cierre del navegador
     * }
     * }
     */
    @Test
    public void SystemTest_VetDetail_VetName() {
        driver.get("http://localhost:4200/mascotas");
        // Aquí puedes añadir aserciones para validar el estado de la página
    }

    @Test
    public void IngresoVeterinario() throws InterruptedException {
        // Navegar a la página de login
        driver.get("http://localhost:4200/login");
        // Maximizar la ventana del navegador
        driver.manage().window().maximize();
    
        // Seleccionar "Veterinario" en el spinner
        WebElement spinner = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-type")));
        spinner.click();
        Thread.sleep(2000);
        WebElement opcionVet = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("option[value='1']")));
        opcionVet.click();
        
    
        // Validar que se ha seleccionado la opción "Veterinario"
        Select select = new Select(spinner);
        String opcionSeleccionada = select.getFirstSelectedOption().getText().trim();
        System.out.println("Opción seleccionada: " + opcionSeleccionada);
        assert opcionSeleccionada.equals("Veterinario");
        Thread.sleep(2000);
    
        // Esperar a que los campos de "Veterinario" aparezcan
        WebElement inputCedula = wait.until(ExpectedConditions.elementToBeClickable(By.id("cedulaVet")));
        WebElement inputContrasena = wait.until(ExpectedConditions.elementToBeClickable(By.id("passVet")));
    
        // Ingresar datos en los campos
        inputCedula.sendKeys("111111");
        Thread.sleep(2000);
        inputContrasena.sendKeys("clave123");
        Thread.sleep(2000);
    
        // Hacer clic en el botón "Iniciar Sesión"
        WebElement iniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnIniciarSesion")));
        iniciarSesion.click();
        Thread.sleep(2000);
        // Interactuar con la página de Clientes
        WebElement verClientes = wait.until(ExpectedConditions.elementToBeClickable(By.id("cuadroCliente")));
        verClientes.click();
        Thread.sleep(2000);
        WebElement agregarCliente = wait.until(ExpectedConditions.elementToBeClickable(By.id("agregarCliente")));
        agregarCliente.click();
        Thread.sleep(2000);
        
        // Ingresar datos del cliente
        WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        WebElement inputCedulaCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cedula")));
        WebElement inputCelular = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celular")));
        WebElement inputCorreo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    
        inputNombre.sendKeys("Kris R");
        Thread.sleep(2000);
        inputCedulaCliente.sendKeys(Keys.BACK_SPACE);
        inputCedulaCliente.sendKeys("12345");
        Thread.sleep(2000);
        inputCelular.sendKeys(Keys.BACK_SPACE);
        inputCelular.sendKeys("121212");
        Thread.sleep(2000);
        inputCorreo.sendKeys("KrisR@gmail.com");
        Thread.sleep(2000);
    
        // Hacer clic en el botón "Agregar"
        WebElement btnAgregar = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAgregar")));
        btnAgregar.click();
    
        // Espera opcional para observar el resultado
        Thread.sleep(2000);
    }
}
