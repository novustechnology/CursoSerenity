package com.automation.web.step;

import com.automation.web.page.CsvPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CsvSteps {

    CsvPage csvPage;

    @Given("el usuario ingresa a la pagina de Toolsqa")
    public void elUsuarioIngresaALaPaginaDeToolsqa() {
        csvPage.open();
    }

    @When("ingresamos la data")
    public void ingresamosLaData() {
        csvPage.ingresarDatos();
    }
}
