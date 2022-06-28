package com.automation.web.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CabinaSteps {
    @Given("el usuario ingresa a la pagina de PeruRail")
    public void elUsuarioIngresaALaPaginaDePeruRail() {
    }

    @And("selecciono el destino, ruta, tren, mes_anio y dia")
    public void seleccionoElDestinoRutaTrenMes_anioYDia() {
    }

    @And("selecciono {string} del tipo {string} con {int} pasajeros niños")
    public void seleccionoDelTipoConPasajerosNiños(String arg0, String arg1, int arg2) {
    }

    @When("doy click en continuar en la pagina de cabinas")
    public void doyClickEnContinuarEnLaPaginaDeCabinas() {
    }

    @Then("se mostrara un popup con el mensaje {string}")
    public void seMostraraUnPopupConElMensaje(String arg0) {
    }
}
