package admi_estacionamientos;

import EstacionamientoAdmi.Automoviles;
import EstacionamientoAdmi.Camiones;
import EstacionamientoAdmi.Motos;
import EstacionamientoAdmi.Vehiculos;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author pedro
 */

public class IngresarDatos {
    //Obtener hora y fecha
    LocalTime hora = LocalTime.now();
    LocalDate fecha = LocalDate.now();
    DateTimeFormatter fH = DateTimeFormatter.ofPattern("h':'mm");
    DateTimeFormatter fF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    NumberFormat formato = NumberFormat.getInstance();
    
    //ArrayList
    static ArrayList<Vehiculos> listaVehiculos = new ArrayList<Vehiculos>();
    Automoviles nAuto = new Automoviles();
    Motos nMoto = new Motos();
    Camiones nCami = new Camiones();
    
    EstacionamientoAdmi.ValidacionesEtc metodo = new EstacionamientoAdmi.ValidacionesEtc();
    
    static String agregar = "";
    String placa = "";
    char caracter;
    static int indicar;
    int longuitud = 0;
    int contador_1 = 0;
    int contador_2 = 0;
    int aleatorio;
    boolean valido_1 = false;
    boolean valido_2 = false;
    boolean valido_3 = false;
    boolean valido_4 = false;
    
    int rr = 1;
    
    public boolean ingresarPlaca(int opcion, String cadena) {
        contador_1 = 0;
        contador_2 = 0;
        
        switch(opcion){
            
            case 1:
                placa = cadena;
                char []contar_1 = placa.toCharArray();
                longuitud = placa.length() - 1;
                if(longuitud == 6) {
                    for(int i = 0; i <= longuitud; i ++) {  // Recorrer la cadena de 0 a 6
                        caracter = contar_1[i];
                        switch(i) {
                            case 0:
                                if(caracter == 'P'){        //Autos: 'P' particular
                                    valido_1 = true;
                                    indicar = 1;
                                }else{
                                    valido_1 = false;
                                }
                                break;
                            case 1: case 2: case 3:
                                metodo.Numeros(caracter);
                                contador_1 = contador_1 + metodo.enviaValido;
                                if(contador_1 == 3){
                                    valido_2 = true;
                                }else{
                                    valido_2 = false;
                                }
                                break;
                            case 4: case 5: case 6:
                                metodo.Alfabeticos(caracter);
                                contador_2 = contador_2 + metodo.enviaValido;
                                if(contador_2 == 3){
                                    valido_3 = true;
                                }
                                else{
                                    valido_3 = false;
                                }
                                break;
                                //Fin switch
                        }
                        //Fin recorrer cadena
                    }
                }else{
                    valido_1 = false;
                    valido_2 = false;
                    valido_3 = false;
                }
                break;
                
            case 2:
                placa = cadena;
                char []contar_2 = placa.toCharArray();
                longuitud = placa.length() - 1;
                if(longuitud == 6) {
                    for(int i = 0; i <= longuitud; i ++) {  // Recorrer la cadena de 0 a 6
                        caracter = contar_2[i];
                        switch(i) {
                            case 0:
                                if(caracter == 'M'){        //Motos: 'M' motos
                                    valido_1 = true;
                                    indicar = 2;
                                }else{
                                    valido_1 = false;
                                }
                                break;
                            case 1: case 2: case 3:
                                metodo.Numeros(caracter);
                                contador_1 = contador_1 + metodo.enviaValido;
                                if(contador_1 == 3){
                                    valido_2 = true;
                                }else{
                                    valido_2 = false;
                                }
                                break;
                            case 4: case 5: case 6:
                                metodo.Alfabeticos(caracter);
                                contador_2 = contador_2 + metodo.enviaValido;
                                if(contador_2 == 3){
                                    valido_3 = true;
                                }else{
                                    valido_3 = false;
                                }
                                break;
                                //Fin switch
                        }
                        //Fin recorrer cadena
                    }
                }else{
                    valido_1 = false;
                    valido_2 = false;
                    valido_3 = false;
                }
                break;
                
            case 3:
                placa = cadena;
                char []contar_3 = placa.toCharArray();
                longuitud = placa.length() - 1;
                if(longuitud == 6) {
                    for(int i = 0; i <= longuitud; i ++) {  // Recorrer la cadena de 0 a 6
                        caracter = contar_3[i];
                        switch(i) {
                            case 0:
                                if(caracter == 'C'){        //Camiones: 'C' Comercial
                                    valido_1 = true;
                                    indicar = 3;
                                }else{
                                    valido_1 = false;
                                }
                                break;
                            case 1: case 2: case 3:
                                metodo.Numeros(caracter);
                                contador_1 = contador_1 + metodo.enviaValido;
                                if(contador_1 == 3){
                                    valido_2 = true;
                                }else{
                                    valido_2 = false;
                                }
                                break;
                            case 4: case 5: case 6:
                                metodo.Alfabeticos(caracter);
                                contador_2 = contador_2 + metodo.enviaValido;
                                if(contador_2 == 3){
                                    valido_3 = true;
                                }else{
                                    valido_3 = false;
                                }
                                break;
                                //Fin switch
                        }
                        //Fin recorrer cadena
                    }
                }else{
                    valido_1 = false;
                    valido_2 = false;
                    valido_3 = false;
                }
                break;
        }
        System.out.println("Si termino el metodo");
         /**
          * if final que manda la validacion
          */
         if((valido_1 == true) && (valido_2 == true) && (valido_3 == true)) {
             return true;
         }else{
             return false;
         }
    }
    
        public void agregaLista(int indica, String cadena) {
        int x;
        switch(indica){
            
            case 1:
                listaVehiculos.add(new Automoviles(cadena));
                x = FXMLVista_2Controller.cupoAuto + 1;
                
                nAuto.NumeroRandom(x);
                aleatorio = nAuto.arregloA[nAuto.contadorA];
                formato.setMinimumIntegerDigits(3);
                
                metodo.GenerarTicket("Estacionamiento N°: "+formato.format(aleatorio), 
                       "Placa, "+cadena,"Fecha: "+fecha.format(fF),"Hora: "+hora.format(fH), 
                       "Tarifa de Q" + FXMLVistaController.tarifaY + "0 por " + FXMLVistaController.cobroX + 
                       "0 segundos");
                for(Vehiculos e: listaVehiculos){
                    System.out.println(e.MostrarDatos());
                }
                break;
                
            case 2:
                listaVehiculos.add(new Motos(cadena));
                x = FXMLVista_2Controller.cupoMoto + 1;
                
                nMoto.NumeroRandom(x);
                aleatorio = nMoto.arregloM[nMoto.contadorM];
                formato.setMinimumIntegerDigits(3);
                 
                metodo.GenerarTicket("Estacionamiento N°: "+formato.format(aleatorio), 
                       "Placa, "+cadena+"  'Aplica 10% de descuento'","Fecha: "+fecha.format(fF),
                       "Hora: "+hora.format(fH), "Tarifa de Q" + FXMLVistaController.tarifaY + "0 por " + FXMLVistaController.cobroX + 
                       "0 segundos");
                break;
                
            case 3:
                listaVehiculos.add(new Camiones(cadena));
                x = FXMLVista_2Controller.cupoCami + 1;
                 
                nCami.NumeroRandom(x);
                aleatorio = nCami.arregloC[nCami.contadorC];
                formato.setMinimumIntegerDigits(3);
                
                metodo.GenerarTicket("Estacionamiento N°: "+formato.format(aleatorio), 
                       "Placa, "+cadena+"  'Q5.00 de recargo por periodo'","Fecha: "+fecha.format(fF),
                       "Hora: "+hora.format(fH), "Tarifa de Q" + FXMLVistaController.tarifaY + "0 por " + FXMLVistaController.cobroX + 
                       "0 segundos");
                break;
        }
    }
        
    public void buscarPlaca (String cadena) {
        valido_4 = false;
        
        indicar = 0;
        
        agregar = cadena;
        
        LocalTime actual = LocalTime.now();
        DateTimeFormatter formt = DateTimeFormatter.ofPattern("h':'mm");
        
        Vehiculos arrayVehiculos[] = new Vehiculos[listaVehiculos.size()];
        
        listaVehiculos.toArray(arrayVehiculos);
        
        for(int z = 0; z < arrayVehiculos.length; z++) {
            if(arrayVehiculos[z].MostrarDatos(cadena) == true){
                valido_4 = true;
                System.out.println("Hola dije que es verdad");
        
                metodo.CalcularTiempo(FXMLVistaController.tiempoX, Vehiculos.inicio, actual.format(formt));
                
                System.out.println("Aqui va antes del calcular pago");
        
                char []contar = cadena.toCharArray();
                longuitud = cadena.length() - 1;
                caracter = contar[0];
                
                if(caracter == 'P') {
                    metodo.CalcularPago(0, 0);
                    indicar = 1;
                    System.out.println("Es un carro");
                }if(caracter == 'M') {
                    metodo.CalcularPago(0.1, 0);
                    indicar = 2;
                    System.out.println("Es una moto");
                }if(caracter == 'C') {
                    metodo.CalcularPago(0, 5);
                    indicar = 3;
                    System.out.println("Es un camion");
                }
            }
        }
        
    }
    
    public void ingresaNit(String cadena) {
        valido_4 = false;
        
        int pasa = 0;
        
        metodo.ValidarNit(cadena);
        pasa = metodo.enviaValido;
        if(pasa < 9){
            valido_4 = false;
        }else{
            valido_4 = true;
            if(indicar == 1) {
                metodo.GenerarFactura("Nit: "+cadena, "Por "+metodo.periodosT+"0 periodos de"
                       + " tiempo utilizado", "Tarifa: Q"+FXMLVistaController.tarifaY+"0", "Descuento: N/A"
                       , "Recargo: N/A", "Total: Q"+metodo.totalCancelar+"0 ", agregar);
            }if(indicar == 2) {
                metodo.GenerarFactura("Nit: "+cadena, "Por "+metodo.periodosT+"0 periodos de"
                       + " tiempo utilizado", "Tarifa: Q"+FXMLVistaController.tarifaY+"0", "Descuento: 10%, Es de: Q"
                       +metodo.totalDescuento+"0"
                       , "Recargo: N/A", "Total: Q"+metodo.totalCancelar+"0 ", agregar);
            }if(indicar == 3) {
                metodo.GenerarFactura("Nit: "+cadena, "Por "+metodo.periodosT+"0 periodos de"
                       + " tiempo utilizado", "Tarifa: Q"+FXMLVistaController.tarifaY+"0", "Descuento: N/A"
                       , "Recargo: Q5.00 por periodo, Es de: Q"+metodo.extra+"0"
                       , "Total: Q"+metodo.totalCancelar+"0 ", agregar);
            }
        }
    }
    
}
