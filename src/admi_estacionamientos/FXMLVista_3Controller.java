package admi_estacionamientos;

import java.io.*;
import java.net.*;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author pedro
 */

public class FXMLVista_3Controller implements Initializable {
    
    DateTimeFormatter f_H = DateTimeFormatter.ofPattern("h':'mm");
    
    NumberFormat formato = NumberFormat.getInstance();
    
    static public int nTF = 0;
    static public int inReport = 0;
    
    static public int ingresosT = 0;
    
    static public int cupoOcupadoT = 0;
    
    static public int cupoLibreT = 0;
    
    @FXML
    private Label cupoAutoFX;
    @FXML
    private Label cupoMotoFX;
    @FXML
    private Label cupoCamiFX;
    @FXML
    private Label solicitudReport;
    @FXML
    private Button buttonIngresar;
    @FXML
    private Button buttonRetirar;
    @FXML
    private Button buttonAdmi;
    
    @FXML
    private void mostrarCupo() {
        FXMLVista_2Controller.cupoAutoTT = FXMLVista_2Controller.cupoAuto-EstacionamientoAdmi.Automoviles.numeradorA;
        FXMLVista_2Controller.cupoMotoTT = FXMLVista_2Controller.cupoMoto-EstacionamientoAdmi.Motos.numeradorM;
        FXMLVista_2Controller.cupoCamiTT = FXMLVista_2Controller.cupoCami-EstacionamientoAdmi.Camiones.numeradorC;
        
        formato.setMinimumIntegerDigits(3);
        cupoAutoFX.setText(formato.format(FXMLVista_2Controller.cupoAutoTT));
        cupoMotoFX.setText(formato.format(FXMLVista_2Controller.cupoMotoTT));
        cupoCamiFX.setText(formato.format(FXMLVista_2Controller.cupoCamiTT));
        
        if(ADMI_ESTACIONAMIENTOS.solicitud_Report != null) {
            if("Report_Ingresos".equals(ADMI_ESTACIONAMIENTOS.solicitud_Report)) {
                inReport = 1;
            }if("Report_Estado".equals(ADMI_ESTACIONAMIENTOS.solicitud_Report)) {
                inReport = 2;
            }
            
            try {
                Socket enviarReporte = new Socket("192.168.1.41", 8911);
            
                DataOutputStream enviar_Reporte = new DataOutputStream(enviarReporte.getOutputStream());
                if(inReport == 1) {
                    enviar_Reporte.writeUTF("Reporte de Ingresos: Q"+ingresosT+".00");
                    inReport = 0;
                    ADMI_ESTACIONAMIENTOS.solicitud_Report = null;
                }if(inReport == 2) {
                    cupoOcupadoT = EstacionamientoAdmi.Automoviles.numeradorA+
                            EstacionamientoAdmi.Camiones.numeradorC+EstacionamientoAdmi.Motos.numeradorM;
                
                    cupoLibreT = (FXMLVista_2Controller.cupoAuto+FXMLVista_2Controller.cupoCami+
                            FXMLVista_2Controller.cupoMoto)-cupoOcupadoT;
                
                    enviar_Reporte.writeUTF("Reporte Estado: "+cupoOcupadoT+" Cupos ocupados y "+
                            cupoLibreT+" libres");
                    inReport = 0;
                    ADMI_ESTACIONAMIENTOS.solicitud_Report = null;
                }
                LocalTime hora_1 = LocalTime.now();
                
                solicitudReport.setText("");
                solicitudReport.setText("Reporte enviado!, "+hora_1.format(f_H));
                enviar_Reporte.close();
            
            } catch (IOException ex) {
                Logger.getLogger(FXMLVista_3Controller.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
    }
    
    @FXML
    private void irIngresarVehiculo (ActionEvent event) {
        try{
            nTF = 0;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_4.fxml"));
            Parent root = loader.load();
            FXMLVista_4Controller controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.buttonIngresar.getScene().getWindow();
            myStage.close();
        }catch(IOException ex){
            Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void irRetirarVehiculo (ActionEvent event) {
         try{
            nTF = 1;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_5.fxml"));
            Parent root = loader.load();
            FXMLVista_5Controller controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.buttonRetirar.getScene().getWindow();
            myStage.close();
        }catch(IOException ex){
            Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void irAdministracion (ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista.fxml"));
            Parent root = loader.load();
            FXMLVistaController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.buttonAdmi.getScene().getWindow();
            myStage.close();
        }catch(IOException ex){
            Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void closeWindows() {
    }       
    
}
