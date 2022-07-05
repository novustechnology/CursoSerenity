package com.automation.web.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


@DefaultUrl("https://demoqa.com/automation-practice-form")
public class CsvPage extends PageObject {

    String CSV_FILE_PATH = "src/test/resources/data/data.csv";

    @FindBy(id = "firstName")
    private WebElementFacade txtNombre;

    @FindBy(id = "lastName")
    private WebElementFacade txtApellido;

    @FindBy(id = "userEmail")
    private WebElementFacade txtEmail;

    @FindBy(id = "userNumber")
    private WebElementFacade txtCelular;

    @FindBy(id = "uploadPicture")
    private WebElementFacade btnCargar;


    public void ingresarDatos() {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("nombre", "apellido", "email", "genero", "celular", "hobbies")
                    .withSkipHeaderRecord()
                    .withTrim());

            for (CSVRecord csvRecord : csvParser) {
                txtNombre.type(csvRecord.get(0));
                txtApellido.type(csvRecord.get(1));
                txtEmail.type(csvRecord.get("email"));
                find("//label[text()='" + csvRecord.get("genero") + "']").click();
                txtCelular.type(csvRecord.get("celular"));
                find("//label[text()='" + csvRecord.get("hobbies") + "']").click();
            }
            upload("src/test/resources/data/imagen.png").to(btnCargar);
            Serenity.takeScreenshot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
