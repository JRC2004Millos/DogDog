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

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TratamientoTest {

    private final String BASE_URL = "http://localhost:4200";

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

    @Test
    public void registroTratamiento() throws InterruptedException {
        
        driver.get(BASE_URL + "/home");

        driver.manage().window().maximize();

        WebElement irLogin = wait.until(ExpectedConditions.elementToBeClickable(By.id("iniciarSesion")));
        irLogin.click();

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

        WebElement verTratamientos = wait.until(ExpectedConditions.elementToBeClickable(By.id("cuadroTratamientos")));
        verTratamientos.click();
        Thread.sleep(2000);

        WebElement btnAgregar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agregar")));
        btnAgregar.click();
        Thread.sleep(2000);

        // Seleccionar "Veterinario" en el spinner
        WebElement spinnerMascota = wait.until(ExpectedConditions.elementToBeClickable(By.id("mascota")));
        spinnerMascota.click();
        Thread.sleep(2000);
        WebElement opcionMascota = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mascota']//option[2]")));
        opcionMascota.click();

        WebElement spinnerDroga = wait.until(ExpectedConditions.elementToBeClickable(By.id("droga")));
        spinnerDroga.click();
        Thread.sleep(2000);
        WebElement opcionDroga = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='droga']//option[1]")));
        opcionDroga.click();

        WebElement spinnerVet = wait.until(ExpectedConditions.elementToBeClickable(By.id("veterinario")));
        spinnerVet.click();
        Thread.sleep(2000);
        WebElement opcionVeterinario = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='veterinario']/option[2]")));
        opcionVeterinario.click();

        WebElement spinnerCant = wait.until(ExpectedConditions.elementToBeClickable(By.id("cantidad")));
        spinnerCant.click();
        Thread.sleep(2000);
        WebElement opcionCantidad = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cantidad']/option[2]")));
        opcionCantidad.click();

        WebElement btnGuardar = wait.until(ExpectedConditions.elementToBeClickable(By.id("botonAgregar")));
        btnGuardar.click();
        Thread.sleep(2000);
        /*/
        // Validar que se ha seleccionado la opción "Veterinario"
        Select seleccion = new Select(spinner);
        String opSeleccionada = seleccion.getFirstSelectedOption().getText().trim();
        System.out.println("Opción seleccionada: " + opSeleccionada);
        assert opSeleccionada.equals("Luna");
        Thread.sleep(2000);
        */








    }
    
}
