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

public class FXMLVistaController implements Initializable {
    
    static public double tarifaY = 0;
    static public double cobroX = 0;
    static public double tiempoX = 3600;
    
    @FXML
    private Label mssConfirmarTarifa;
    @FXML
    private Label mssConfirmarTarifa1;
    @FXML
    private TextField tiempoFX;
    @FXML
    private TextField tarifaFX;
    @FXML
    private Button buttonNextScena;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
            tarifaY = Double.parseDouble(this.tarifaFX.getText());
            cobroX = Double.parseDouble(this.tiempoFX.getText());
            
                    mssConfirmarTarifa.setText("Se a definido: Cobrar Q"+tarifaY+"0 por "+cobroX+"0 seg");
                    mssConfirmarTarifa1.setText("de utilizacion del estacionamiento.");
        }catch(NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("ERROR");
            alerta.setContentText("El dato ingresado no es valido.");
            alerta.showAndWait();
        }
    }
    
    @FXML
    private void nextScena_1(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_2.fxml"));
            Parent root = loader.load();
            FXMLVista_2Controller controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.buttonNextScena.getScene().getWindow();
            myStage.close();
        }catch(IOException ex){
            Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param url
     * @param rb 
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_3.fxml"));
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
