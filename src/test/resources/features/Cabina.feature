Feature: Cabinas

  @Cabinas
  Scenario: Mostrar mensaje cuando solo se ha seleccionado niños como pasajeros
    Given el usuario ingresa a la pagina de PeruRail
    And selecciono el destino, ruta, tren, mes_anio y dia
    And selecciono "1 CABIN" del tipo "SUITE" con 2 pasajeros niños
    When doy click en continuar en la pagina de cabinas
    Then se mostrara un popup con el mensaje "You must select at least 1 adult"