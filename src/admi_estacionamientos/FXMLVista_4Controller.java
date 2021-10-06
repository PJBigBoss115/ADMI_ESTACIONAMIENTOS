package admi_estacionamientos;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */

public class FXMLVista_4Controller implements Initializable {
    
    static public int indicador = 0;
    
    NumberFormat formato = NumberFormat.getInstance();
    
    @FXML
    private Label cupoAutoFX;
    @FXML
    private Label cupoMotoFX;
    @FXML
    private Label cupoCamiFX;
    @FXML
    private Button buttonAuto;
    @FXML
    private Button buttonMoto;
    @FXML
    private Button buttonCami;
    @FXML
    private Button buttonReturn;
    
    @FXML
    private void mostrarCupo_2() {
        FXMLVista_2Controller.cupoAutoTT = FXMLVista_2Controller.cupoAuto-EstacionamientoAdmi.Automoviles.numeradorA;
        FXMLVista_2Controller.cupoMotoTT = FXMLVista_2Controller.cupoMoto-EstacionamientoAdmi.Motos.numeradorM;
        FXMLVista_2Controller.cupoCamiTT = FXMLVista_2Controller.cupoCami-EstacionamientoAdmi.Camiones.numeradorC;
        
        formato.setMinimumIntegerDigits(3);
        cupoAutoFX.setText(formato.format(FXMLVista_2Controller.cupoAutoTT));
        cupoMotoFX.setText(formato.format(FXMLVista_2Controller.cupoMotoTT));
        cupoCamiFX.setText(formato.format(FXMLVista_2Controller.cupoCamiTT));
    }
    
    @FXML
    private void addAuto (ActionEvent event) {
        if(FXMLVista_2Controller.cupoAuto == EstacionamientoAdmi.Automoviles.numeradorA) {
            Alert alertaIn = new Alert(Alert.AlertType.ERROR);
            alertaIn.setContentText("Ya no hay espacios disponibles!");
            alertaIn.showAndWait();
        }else{
            try{
                indicador = 1;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_5.fxml"));
                Parent root = loader.load();
                FXMLVista_5Controller controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.buttonAuto.getScene().getWindow();
                myStage.close();
            }catch(IOException ex){
                Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void addMoto (ActionEvent event) {
        if(FXMLVista_2Controller.cupoMoto == EstacionamientoAdmi.Motos.numeradorM) {
            Alert alertaIn = new Alert(Alert.AlertType.ERROR);
            alertaIn.setContentText("Ya no hay espacios disponibles!");
            alertaIn.showAndWait();
        }else{
            try{
                indicador = 2;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_5.fxml"));
                Parent root = loader.load();
                FXMLVista_5Controller controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.buttonMoto.getScene().getWindow();
                myStage.close();
            }catch(IOException ex){
                Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void addCami (ActionEvent event) {
        if(FXMLVista_2Controller.cupoCami == EstacionamientoAdmi.Camiones.numeradorC) {
            Alert alertaIn = new Alert(Alert.AlertType.ERROR);
            alertaIn.setContentText("Ya no hay espacios disponibles!");
            alertaIn.showAndWait();
        }else{
            try{
                indicador = 3;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_5.fxml"));
                Parent root = loader.load();
                FXMLVista_5Controller controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.buttonCami.getScene().getWindow();
                myStage.close();
            }catch(IOException ex){
                Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void returnScena (ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_3.fxml"));
            Parent root = loader.load();
            FXMLVista_3Controller controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.buttonReturn.getScene().getWindow();
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
