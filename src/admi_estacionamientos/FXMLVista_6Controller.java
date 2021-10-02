package admi_estacionamientos;

import EstacionamientoAdmi.ValidacionesEtc;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */

public class FXMLVista_6Controller implements Initializable {
    
    IngresarDatos enviar_1 = new IngresarDatos();
    
    String nit = "";
    String cadena_1 = "";
    int opcion = 0;
    int pasa = 0;
    
    @FXML
    private Label mssTitle_2;
    @FXML
    private Label mssNotifica_3;
    @FXML
    private Label mssNotifica_4;
    @FXML
    private TextField textNIT;
    @FXML
    private Button buttonOk_NIT;
    
    @FXML
    private void notificaTitle_1() {
        mssTitle_2.setText("Generar Factura");
    }
    
    @FXML
    private void enviaNit (ActionEvent event) {
        cadena_1 = this.textNIT.getText();
        
        enviar_1.ingresaNit(cadena_1);
        if(enviar_1.valido_4 == true) {
            try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_3.fxml"));
                    Parent root = loader.load();
                    FXMLVista_3Controller controlador = loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.setOnCloseRequest(e -> controlador.closeWindows());
                    Stage myStage = (Stage) this.buttonOk_NIT.getScene().getWindow();
                    myStage.close();
                }catch(IOException ex){
                    Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }if(enviar_1.valido_4 == false) {
            mssNotifica_3.setText("Nit no valido..");
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
