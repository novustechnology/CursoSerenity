@PeruRail
Feature: PeruRail

  Scenario Outline:Automatización Web PeruRail
    Given el usuario ingresa a la pagina de PeruRail
    When selecciono el destino "<destino>", la ruta "<ruta>" y seleccionamos el tren "<tren>"
    And selecciona la fecha de salida "<mesAnioSalida>" y "<diaSalida>"
    And selecciono el tipo de cabina "<tipo_cabina>" y la cantidad de cabinas "<cant_cabinas>"
    And ingresamos la informacion de los pasajeros
      | nombre | apellido | fecha_cumpleanio | nacionalidad | tipo_documento      | nro_documento | sexo | telefono  | email                |
      | York   | Correa   | 31-12-1988       | Peru         | Identification Card | 45497868      | Male | 958748774 | yorkcorrea@novus.com |
    When doy click en continuar en la pagina de pasajeros
    Then se mostrara la pantalla de pago "PAYMENT METHOD"
    And elegiremos como "<metodo_pago>" metodo de pago e ingresaremos el "<nro_tajerta>", "<mes_expiracion>", "<anio_expiracion>", "<codigo_seguridad>" y "<nombre>"
    Examples:
      | destino | ruta         | tren                             | mesAnioSalida | diaSalida | tipo_cabina | cant_cabinas | metodo_pago | nro_tajerta      | mes_expiracion | anio_expiracion | codigo_seguridad | nombre |
      | Cusco   | Puno > Cusco | Andean Explorer, A Belmond Train | August 2022   | 17        | SUITE       | 1 CABIN      | visa        | 4242424242424242 | 12             | 25              | 666              | Novus  |