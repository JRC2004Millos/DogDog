package com.example.demo.e2e;

import java.time.Duration;

import org.junit.Before; // Cambiado a JUnit 4
import org.junit.After;
import org.junit.Test; // JUnit 4
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
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
        navegarALogin();
        seleccionarVeterinario();
        validarSeleccionVeterinario();
        ingresarCredencialesVeterinario("1234567890", "1234567890");
        Error();
        seleccionarVeterinario();
        validarSeleccionVeterinario();
        ingresarCredencialesVeterinario("111111", "clave123");
        navegarAClientes();
        agregarCliente("Kris R", "14435", "50422", "KrisR@gmail.com");
        devolverse();
        navegarAMascotas();
        ingresarDatosMascota("Firulo", "Beagle", "14", "5", "Retraso", "https://www.akc.org/wp-content/uploads/2021/01/Beagle-puppy-standing-in-the-grass-1-500x486.jpeg");
        devolverse();
        cerrarSesion();
        seleccionarCliente();
        validarSeleccionCliente();
        ingresarCredencialesCliente("14435");

    }

    // Navega a la página de login y maximiza la ventana
    private void navegarALogin() {
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();
    }

    // Selecciona la opción "Veterinario" en el spinner
    private void seleccionarVeterinario() throws InterruptedException {
        WebElement spinner = wait.until(ExpectedConditions.elementToBeClickable(By.id("user-type")));
        spinner.click();
        // Thread.sleep(2000);
        WebElement opcionVet = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("option[value='1']")));
        opcionVet.click();
    }

    // Valida que la opción "Veterinario" fue seleccionada
    private void validarSeleccionVeterinario() throws InterruptedException {
        WebElement spinner = driver.findElement(By.id("user-type"));
        Select select = new Select(spinner);
        String opcionSeleccionada = select.getFirstSelectedOption().getText().trim();
        System.out.println("Opción seleccionada: " + opcionSeleccionada);
        assert opcionSeleccionada.equals("Veterinario");
        // Thread.sleep(2000);
    }

    // Ingresa las credenciales del veterinario
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

    // Navega a la sección de clientes
    private void navegarAClientes() throws InterruptedException {
        WebElement verClientes = wait.until(ExpectedConditions.elementToBeClickable(By.id("cuadroCliente")));
        verClientes.click();
        Thread.sleep(2000);
    }

    // Agrega un cliente con los datos proporcionados
    private void agregarCliente(String nombre, String cedula, String celular, String correo)
            throws InterruptedException {
        WebElement agregarCliente = wait.until(ExpectedConditions.elementToBeClickable(By.id("agregarCliente")));
        agregarCliente.click();
        // Thread.sleep(2000);

        WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        WebElement inputCedulaCliente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cedula")));
        WebElement inputCelular = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celular")));
        WebElement inputCorreo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        inputNombre.sendKeys(nombre);
        // Thread.sleep(2000);
        inputCedulaCliente.sendKeys(Keys.BACK_SPACE);
        inputCedulaCliente.sendKeys(cedula);
        // Thread.sleep(2000);
        inputCelular.sendKeys(Keys.BACK_SPACE);
        inputCelular.sendKeys(celular);
        // Thread.sleep(2000);
        inputCorreo.sendKeys(correo);
        // Thread.sleep(2000);

        WebElement btnAgregar = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAgregar")));
        btnAgregar.click();
        // Thread.sleep(2000);
    }

    private void Error() {
        WebElement btnError = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnVolver")));
        btnError.click();
    }

    private void devolverse(){
        WebElement salir = wait.until(ExpectedConditions.elementToBeClickable(By.id("volverSesion")));
        salir.click();
    }

    private void ingresarDatosMascota(String nombre, String raza, String edad, String peso, String enfermedad, String fotoURL) throws InterruptedException {
                WebElement inputNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nombre")));
        WebElement inputRaza = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("raza")));
        WebElement inputEdad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edad")));
        WebElement inputPeso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("peso")));
        WebElement inputEnfermedad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enfermedad")));
        WebElement inputFoto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fotoURL")));
        // WebElement spinnerEnfermero =
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cliente")));

        inputNombre.sendKeys(nombre);
        inputRaza.sendKeys(raza);
        inputEdad.sendKeys(edad);
        inputPeso.sendKeys(peso);
        inputEnfermedad.sendKeys(enfermedad);

        WebElement spinner = wait.until(ExpectedConditions.elementToBeClickable(By.id("cliente")));
        spinner.click();
        // Thread.sleep(2000);
        WebElement cliente = wait.until(ExpectedConditions.elementToBeClickable(ByXPath
                .xpath("//*[@id='cliente']/option[52]")));
        cliente.click();

        inputFoto.sendKeys(fotoURL);

        WebElement btnAgregar = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAgregar")));
        btnAgregar.click();
    }


    private void navegarAMascotas() throws InterruptedException {

        WebElement verMascota = wait.until(ExpectedConditions.elementToBeClickable(By.id("cuadroMascota")));
        verMascota.click();

        WebElement agregarMascota = wait.until(ExpectedConditions.elementToBeClickable(By.id("agregar")));
        agregarMascota.click();

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
        WebElement inputCedula = wait.until(ExpectedConditions.elementToBeClickable(By.id("cedulaCliente")));
        inputCedula.sendKeys(cedula);

        WebElement btnIniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnIniciarSesion")));
        btnIniciarSesion.click();

        WebElement spinner = wait.until(ExpectedConditions.elementToBeClickable(By.id("seleccionMascota")));
        spinner.click();
        // Thread.sleep(2000);
        WebElement cliente = wait.until(ExpectedConditions.elementToBeClickable(ByXPath
                .xpath("//*[@id='seleccionMascota']")));
        cliente.click();

    }

}


