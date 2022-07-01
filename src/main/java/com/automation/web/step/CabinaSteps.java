package com.automation.web.step;

import com.automation.web.page.CabinasPage;
import com.automation.web.page.CalendarioPage;
import com.automation.web.page.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CabinaSteps {

    HomePage homePage;
    CalendarioPage calendarioPage;
    CabinasPage cabinasPage;

    @Given("el usuario ingresa a la pagina de PeruRail")
    public void elUsuarioIngresaALaPaginaDePeruRail() {
        homePage.open();
    }

    @And("selecciono el destino, ruta, tren, mes_anio y dia")
    public void seleccionoElDestinoRutaTrenMes_anioYDia(){
        homePage.seleccionarDestino("Cusco");
        homePage.seleccionarRuta("Puno > Cusco");
        homePage.seleccionarTren("Andean Explorer, A Belmond Train");
        calendarioPage.seleccionarSalida("August 2022", "17");
        homePage.clickBuscar();

    }

    @And("selecciono {string} del tipo {string} con {int} pasajeros niños")
    public void seleccionoDelTipoConPasajerosNiños(String cant, String cabina, int cantNinios) {
        cabinasPage.seleccionarCabina(cabina, cant);
        cabinasPage.seleccionarCantidadNinios(Integer.toString(cantNinios));
    }

    @When("doy click en continuar en la pagina de cabinas")
    public void doyClickEnContinuarEnLaPaginaDeCabinas() {
        cabinasPage.clickContinuar();
    }

    @Then("se mostrara un popup con el mensaje {string}")
    public void seMostraraUnPopupConElMensaje(String mensaje) {
        Assert.assertEquals(mensaje,cabinasPage.obtenerTextoPopUp());

    }
}
