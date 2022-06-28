package com.automation.web.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.perurail.com/")
public class HomePage extends PageObject {


    @FindBy(id = "destinoSelect")
    private WebElementFacade cboDestino;

    @FindBy(id = "rutaSelect")
    private WebElementFacade btnRuta;

    @FindBy(id = "cbTrenSelect")
    private WebElementFacade btnTren;

    @FindBy(id = "btn_search")
    private WebElementFacade btnBuscar;


    public void seleccionarDestino(String destino){
        cboDestino.selectByVisibleText(destino);
    }

    public void seleccionarRuta(String ruta){
        btnRuta.selectByVisibleText(ruta);
    }

    public void seleccionarTren(String tren){
        btnTren.selectByVisibleText(tren);
    }

    public void clickBuscar(){
        element(btnBuscar).click();
    }

}
