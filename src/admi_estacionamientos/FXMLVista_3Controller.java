package admi_estacionamientos;

import java.io.*;
import java.net.*;
import java.text.NumberFormat;
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
        System.out.println("MovedOn!");
        formato.setMinimumIntegerDigits(3);
        cupoAutoFX.setText(formato.format(FXMLVista_2Controller.cupoAuto));
        cupoMotoFX.setText(formato.format(FXMLVista_2Controller.cupoMoto));
        cupoCamiFX.setText(formato.format(FXMLVista_2Controller.cupoCami));
        if("Report_Ingresos".equals(ADMI_ESTACIONAMIENTOS.solicitud_Report)){
            solicitudReport.setText("EnReport_1");
            inReport = 1;
        }if("Report_Estado".equals(ADMI_ESTACIONAMIENTOS.solicitud_Report)){
            solicitudReport.setText("EnReport_2");
            inReport = 2;
        }
    }
    
    @FXML
    private void irIngresarVehiculo (ActionEvent event) {
        try{
            System.out.println("Click InV!");
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
            System.out.println("Click ReV!");
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
            System.out.println("Click Adm!");
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
    
    @FXML
    private void EnvioReporte_1(ActionEvent event) {
        try {
            System.out.println("ButtonEnviar");
            
            Socket enviarReporte = new Socket("192.168.1.41", 8911);
            
            DataOutputStream enviar_Reporte = new DataOutputStream(enviarReporte.getOutputStream());
            if(inReport == 1) {
                enviar_Reporte.writeUTF("Reporte de Ingresos: Q"+ingresosT+".00");
                inReport = 0;
                ADMI_ESTACIONAMIENTOS.solicitud_Report = "";
                solicitudReport.setText("");
            }if(inReport == 2) {
                cupoOcupadoT = EstacionamientoAdmi.Automoviles.numeradorA+
            EstacionamientoAdmi.Camiones.numeradorC+EstacionamientoAdmi.Motos.numeradorM;
                
                cupoLibreT = (FXMLVista_2Controller.cupoAuto+FXMLVista_2Controller.cupoCami+
                        FXMLVista_2Controller.cupoMoto)-cupoOcupadoT;
                
                enviar_Reporte.writeUTF("Reporte Estado: "+cupoOcupadoT+" Estan ocupados y "+
                        cupoLibreT+" libres");
                inReport = 0;
                ADMI_ESTACIONAMIENTOS.solicitud_Report = "";
                solicitudReport.setText("");
            }
            enviar_Reporte.close();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLVista_3Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
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
