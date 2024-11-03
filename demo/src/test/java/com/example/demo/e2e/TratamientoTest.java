package com.example.demo.e2e;

import java.time.Duration;

import org.junit.Before; // Cambiado a JUnit 4
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; // JUnit 4
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

        navegarALogin();
        seleccionarAdmin();
        validarSeleccionAdmin();
        ingresarCredencialesAdmin("admin", "Jave1234*");
        verDashboard();
        devolverse();
        cerrarSesion();
        seleccionarVeterinario();
        validarSeleccionVeterinario();
        ingresarCredencialesVeterinario("111111", "clave123");
        navegarTratamientos();
        addTratamientos();
        devolverse();
        cerrarSesion();
        seleccionarCliente();
        validarSeleccionCliente();
        ingresarCredencialesCliente("123456");
        cerrarSesion();
        seleccionarAdmin();
        validarSeleccionAdmin();
        ingresarCredencialesAdmin("admin", "Jave1234*");
        verDashboard();

    }

    private void navegarALogin() {
        driver.get(BASE_URL + "/login");
        driver.manage().window().maximize();
    }

    private void seleccionarVeterinario() {
        WebElement spinner = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-type")));
        spinner.click();
        // Thread.sleep(2000);
        WebElement opcionVet = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("option[value='1']")));
        opcionVet.click();
    }

    private void validarSeleccionVeterinario() throws InterruptedException {
        WebElement spinner = driver.findElement(By.id("user-type"));
        Select select = new Select(spinner);
        String opcionSeleccionada = select.getFirstSelectedOption().getText().trim();
        System.out.println("Opción seleccionada: " + opcionSeleccionada);
        assert opcionSeleccionada.equals("Veterinario");
        // Thread.sleep(2000);
    }

    private void ingresarCredencialesVeterinario(String cedula, String contrasena) throws InterruptedException {
        WebElement inputCedula = wait.until(ExpectedConditions.elementToBeClickable(By.id("cedulaVet")));
        WebElement inputContrasena = wait.until(ExpectedConditions.elementToBeClickable(By.id("passVet")));

        inputCedula.sendKeys(cedula);
        // Thread.sleep(2000);
        inputContrasena.sendKeys(contrasena);
        // Thread.sleep(2000);

        WebElement iniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnIniciarSesion")));
        iniciarSesion.click();
        // Thread.sleep(2000);
    }

    private void navegarTratamientos() {
        WebElement verTratamientos = wait.until(ExpectedConditions.elementToBeClickable(By.id("cuadroTratamientos")));
        verTratamientos.click();

        WebElement btnAgregar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agregar")));
        btnAgregar.click();
    }

    private void addTratamientos() throws InterruptedException {
        WebElement spinnerMascota = wait.until(ExpectedConditions.elementToBeClickable(By.id("mascota")));
        spinnerMascota.click();
        WebElement opcionMascota = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mascota']//option[2]")));
        opcionMascota.click();

        WebElement spinnerDroga = wait.until(ExpectedConditions.elementToBeClickable(By.id("droga")));
        spinnerDroga.click();
        Thread.sleep(2000);
        WebElement opcionDroga = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='droga']/option[45]")));
        Thread.sleep(2000);
        opcionDroga.click();

        WebElement spinnerVet = wait.until(ExpectedConditions.elementToBeClickable(By.id("veterinario")));
        spinnerVet.click();
        WebElement opcionVeterinario = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='veterinario']/option[2]")));
        opcionVeterinario.click();

        WebElement spinnerCant = wait.until(ExpectedConditions.elementToBeClickable(By.id("cantidad")));
        spinnerCant.click();
        WebElement opcionCantidad = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cantidad']/option[1]")));
        opcionCantidad.click();

        Thread.sleep(2000);

        WebElement btnGuardar = wait.until(ExpectedConditions.elementToBeClickable(By.id("botonAgregar")));
        btnGuardar.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

    }

    private void devolverse() {
        WebElement salir = wait.until(ExpectedConditions.elementToBeClickable(By.id("volverSesion")));
        salir.click();
    }

    private void cerrarSesion() throws InterruptedException {

        WebElement salir = wait.until(ExpectedConditions.elementToBeClickable(By.id("cerrarSesion")));
        salir.click();
    }

    private void seleccionarCliente() throws InterruptedException {
        WebElement spinner = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-type")));
        spinner.click();
        // Thread.sleep(2000);
        WebElement opcionVet = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("option[value='3']")));
        opcionVet.click();
    }

    private void validarSeleccionCliente() throws InterruptedException {
        WebElement spinner = driver.findElement(By.id("user-type"));
        Select select = new Select(spinner);
        String opcionSeleccionada = select.getFirstSelectedOption().getText().trim();
        System.out.println("Opción seleccionada: " + opcionSeleccionada);
        assert opcionSeleccionada.equals("Cliente");
        // Thread.sleep(2000);
    }

    private void ingresarCredencialesCliente(String cedula) throws InterruptedException {
        // Ingresar el número de cédula
        WebElement inputCedula = wait.until(ExpectedConditions.elementToBeClickable(By.id("cedulaCliente")));
        inputCedula.sendKeys(cedula);

        // Iniciar sesión
        WebElement btnIniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnIniciarSesion")));
        btnIniciarSesion.click();

        // Seleccionar la mascota
        WebElement spinner = wait.until(ExpectedConditions.elementToBeClickable(By.id("seleccionMascota")));
        spinner.click();
        WebElement cliente = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='seleccionMascota']")));
        cliente.click();

        // Scroll hacia abajo hasta el final de la página
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000); // Espera para asegurar que el scroll se complete

        // Scroll hacia arriba hasta el elemento específico
        WebElement element = driver.findElement(By.id("header")); // Cambia "header" al selector correcto
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000); // Espera para asegurarse de que el scroll hacia arriba se complete
    }

    private void seleccionarAdmin() throws InterruptedException {
        WebElement spinner = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-type")));
        spinner.click();
        // Thread.sleep(2000);
        WebElement opcionVet = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("option[value='2']")));
        opcionVet.click();
    }

    private void validarSeleccionAdmin() throws InterruptedException {
        WebElement spinner = driver.findElement(By.id("user-type"));
        Select select = new Select(spinner);
        String opcionSeleccionada = select.getFirstSelectedOption().getText().trim();
        System.out.println("Opción seleccionada: " + opcionSeleccionada);
        assert opcionSeleccionada.equals("Administrador");
        // Thread.sleep(2000);
    }

    private void ingresarCredencialesAdmin(String usuario, String contrasena) throws InterruptedException {
        WebElement inputUsuario = wait.until(ExpectedConditions.elementToBeClickable(By.id("usuarioAdmin")));
        WebElement inputContrasena = wait.until(ExpectedConditions.elementToBeClickable(By.id("passAdmin")));

        inputUsuario.sendKeys(usuario);
        // Thread.sleep(2000);
        inputContrasena.sendKeys(contrasena);
        // Thread.sleep(2000);

        WebElement iniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnIniciarSesion")));
        iniciarSesion.click();
        // Thread.sleep(2000);
    }

    private void verDashboard() throws InterruptedException {
        WebElement verDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNegocio")));
        verDashboard.click();

        Thread.sleep(2000);
    }

}