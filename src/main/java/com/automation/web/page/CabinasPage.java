package com.automation.web.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CabinasPage extends PageObject {


    @FindBy(name = "selectRooms[suite]")
    private WebElementFacade tipoSuite;

    @FindBy(name = "selectRooms[twin]")
    private WebElementFacade tipoTwin;

    @FindBy(name = "selectRooms[bunk]")
    private WebElementFacade tipoBunk;

    @FindBy(xpath = "//div[@class='cont-select children']//select")
    private List<WebElementFacade> cantNinios;

    @FindBy(id = "continuar_bae")
    private WebElementFacade btnContinuar;

    @FindBy(className = "sb-content")
    private WebElementFacade popUp;


    public void seleccionarCabina(String tipoCabina, String numeroCabinas) {
        $("//div[@class='contenedor']").waitUntilVisible();
        WebElementFacade webElementFacade = null;
        switch (tipoCabina) {
            case "SUITE":
                webElementFacade = tipoSuite;
                break;

            case "TWIN":
                webElementFacade = tipoTwin;
                break;

            case "BUNK":
                webElementFacade = tipoBunk;
                break;
        }
        withAction().moveToElement(webElementFacade).perform();
        assert webElementFacade != null;
        webElementFacade.selectByVisibleText(numeroCabinas);
    }


    public void seleccionarCantidadNinios(String cantidad) {
        int cant = cantNinios.size();
        System.out.println("cantidad de ninios " + cant);
        for (WebElementFacade ele : cantNinios) {
            ele.selectByVisibleText(cantidad);
        }
    }

    public void clickContinuar() {
        withAction().moveToElement(btnContinuar).perform();
        btnContinuar.click();
    }

    public String obtenerTextoPopUp() {
        return popUp.getText();
    }

}
