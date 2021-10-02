package admi_estacionamientos;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author pedro
 */

public class FXMLVista_2Controller implements Initializable {
    
    static public int cupoAuto = 0;
    static public int cupoMoto = 0;
    static public int cupoCami = 0;
    
    @FXML
    private TextField automovilesFX;
    @FXML
    private TextField motosFX;
    @FXML
    private TextField camionesFX;
    @FXML
    private Label mssCupoV;
    @FXML
    private Button buttonNextScena_2;
    
    @FXML
    private void ingresarDatos(ActionEvent event) {
        try{
            cupoAuto = Integer.parseInt(this.automovilesFX.getText());
            cupoMoto = Integer.parseInt(this.motosFX.getText());
            cupoCami = Integer.parseInt(this.camionesFX.getText());
            
                    System.out.println("Click Accept!");
                    mssCupoV.setText("Se a definido correctamente!");
        }catch(NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("ERROR");
            alerta.setContentText("El dato ingresado no es valido.");
            alerta.showAndWait();
        }
    }
    
    
    @FXML
    private void nextScena_2(ActionEvent event) {
        try{
            System.out.println("Click Next!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_3.fxml"));
            Parent root = loader.load();
            FXMLVista_3Controller controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.buttonNextScena_2.getScene().getWindow();
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
     try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
 }    
    
}