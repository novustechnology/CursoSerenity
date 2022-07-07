package com.automation.web.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static java.time.temporal.ChronoUnit.SECONDS;

public class MetodoDePagoPage extends PageObject {


    @FindBy(xpath = "//div[@class='title-pasajero']")
    private WebElementFacade tituloPago;

    @FindBy(id = "chk_tercon")
    private WebElementFacade rdbtnTerminos;

    @FindBy(id = "ingresar_tarjeta")
    private WebElementFacade btnIngresarTarjeta;


    @FindBy(name = "CREDITCARDNUMBER")
    private WebElementFacade txtNroTarjeta;

    @FindBy(name = "EXPIRYDATE_MM")
    private WebElementFacade dropdownMesExp;

    @FindBy(name = "EXPIRYDATE_YY")
    private WebElementFacade dropdownAnioExp;

    @FindBy(name = "CVV")
    private WebElementFacade txtCodigoSeguridad;

    @FindBy(name = "NAME")
    private WebElementFacade txtNombre;


    public String obtenerTituloPago() {
        withTimeoutOf(7, SECONDS);
        waitForTextToAppear(tituloPago.getText());
        return tituloPago.getText();
    }

    public void clickMetodoPago(String metodo_pago) {
        element("//input[@id='" + metodo_pago + "']").waitUntilClickable().click();
    }

    public void clickTerminos() {
        rdbtnTerminos.click();
        Serenity.takeScreenshot();
    }

    public void ingresarDatosTarjeta(String nro_tajerta, String mes_expiracion, String anio_expiracion, String codigo_seguridad, String nombre) {
        btnIngresarTarjeta.waitUntilClickable().click();
        waitForRenderedElementsToBePresent(By.xpath("//div[@class='datos-tarjeta']"));
        getDriver().switchTo().frame("global");
        txtNroTarjeta.type(nro_tajerta);
        dropdownMesExp.selectByVisibleText(mes_expiracion);
        dropdownAnioExp.selectByVisibleText(anio_expiracion);
        txtCodigoSeguridad.type(codigo_seguridad);
        txtNombre.type(nombre);
        Serenity.takeScreenshot();
    }
}
