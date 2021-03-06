/*
 * Clase padre para los tipos de vehiculos
 */
package EstacionamientoAdmi;

/**
 *
 * @author pedro
 */

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vehiculos {
    
    static public String inicio;
    
    protected int id;
    private String placa;
    private String fechaIngreso;
    private String horaIngreso;
    
    //Variables para validar numero randon
    int contador = 0;
    int iV;
    int j = 0;
    int cantidad = 10;
    int arreglo[] = new int[cantidad];
    
    protected double tarifaTotal;
    
    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formatoH = DateTimeFormatter.ofPattern("h':'mm");
    DateTimeFormatter formatoF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /**
     * 
     * Constructores
     *
     */ 
    
    /**
     * 
     * @param placa
     */
    
    public Vehiculos(String placa) {
        LocalTime horaActual = LocalTime.now();
        
        setId();
        this.id = getId();
        this.placa = placa;
        this.fechaIngreso = fechaActual.format(formatoF);
        this.horaIngreso = horaActual.format(formatoH);
    }
    
        public Vehiculos() {
    }
        
    /**
     * 
     * Metodos
     * 
     * @return 
     */
        
    public String MostrarDatos() {
    
        return id + " " + placa + " " +  fechaIngreso + " " +  horaIngreso;
        
    }
    
    public boolean MostrarDatos(String comparar) {
        if(placa.equals(comparar)) {
            this.inicio = horaIngreso;
            return true;
        }else{
            return false;
        }
    }

    private int getId() {
        return id;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }
    
    public void setId() {
        this.id = 0;
    }
        
     public void NumeroRandom(int rango){
        contador++;
        iV = 0;
        arreglo[0] = 0;
               while(iV != 1){ 
                   arreglo[contador] = (int) (Math.random() * rango);
                        for(j = contador; j > -1; j--){
                            if(arreglo[contador] == arreglo[j]){
                                arreglo[contador] = (int) (Math.random() * rango);
                                j = contador;
                            }else{
                                iV = 1;
                            }
                        }
               }
    }
    
}
