package admi_estacionamientos;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pedro
 */

public class FXMLVista_5Controller implements Initializable {
    
    IngresarDatos enviar = new IngresarDatos();
    
    //Obtener hora y fecha
    LocalTime hora = LocalTime.now();
    LocalDate fecha = LocalDate.now();
    DateTimeFormatter fH = DateTimeFormatter.ofPattern("h':'mm");
    DateTimeFormatter fF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    static int envia = 0;
    static int n_TF = 0;
    String cadena = "";
    String placa = cadena;
    int longuitud;
    char caracter;
    
    @FXML
    private Label mssTitle;
    @FXML
    private Label mssNotifica_1;
    @FXML
    private Label mssNotifica_2;
    @FXML
    private TextField textPlaca;
    @FXML
    private Button buttonOk;
    
    @FXML
    private void notificaTitle() {
        n_TF = 0;
        n_TF = FXMLVista_3Controller.nTF;
        if(n_TF == 1){
            mssTitle.setText("Retirar Vehiculo");
        }else{
            mssTitle.setText("Ingresar Vehiculo");
        }
    }
    
    @FXML
    private void enviaPlaca (ActionEvent event) throws InterruptedException {
        n_TF = 0;
        n_TF = FXMLVista_3Controller.nTF;
        if(n_TF == 1) {
            
            cadena = this.textPlaca.getText();
            
            enviar.buscarPlaca(cadena);
            
            if(enviar.valido_4 == true){
                 try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_6.fxml"));
                    Parent root = loader.load();
                    FXMLVista_6Controller controlador = loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.setOnCloseRequest(e -> controlador.closeWindows());
                    Stage myStage = (Stage) this.buttonOk.getScene().getWindow();
                    myStage.close();
                }catch(IOException ex){
                    Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                mssNotifica_1.setText("No se a encontrado la placa...");
            }
            
        }else{
            //Ingresar placa
            
            cadena = this.textPlaca.getText();
            
            if(enviar.ingresarPlaca(FXMLVista_4Controller.indicador, cadena) == true) {
                enviar.agregaLista(FXMLVista_4Controller.indicador, cadena);
                
                Thread.sleep(500);
                
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/admi_estacionamientosVentanas/FXMLVista_4.fxml"));
                    Parent root = loader.load();
                    FXMLVista_4Controller controlador = loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    stage.setOnCloseRequest(e -> controlador.closeWindows());
                    Stage myStage = (Stage) this.buttonOk.getScene().getWindow();
                    myStage.close();
                }catch(IOException ex){
                    Logger.getLogger(FXMLVistaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                if(FXMLVista_4Controller.indicador == 1 ) {
                    mssNotifica_1.setText("Placa no valida, Fromato: P000SSS, 'P' Particular");
                }if(FXMLVista_4Controller.indicador == 2 ) {
                    mssNotifica_1.setText("Placa no valida, Fromato: M000SSS, 'M' Motocicleta");
                }if(FXMLVista_4Controller.indicador == 3 ) {
                    mssNotifica_1.setText("Placa no valida, Fromato: C000SSS, 'C' Comercial");
                }
            }
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
