package admi_estacionamientos;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */

public class ADMI_ESTACIONAMIENTOS extends Application implements Runnable {
    
    static public String solicitud_Report;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
         try {
            Thread ejecuta_2 = new Thread(this);
            ejecuta_2.start(); 
             
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ADMI_ESTACIONAMIENTOS.class.getResource("/admi_estacionamientosVentanas/FXMLVista.fxml"));
            Pane ventana = (Pane) loader.load();
            
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void run() {
        try {  
            ServerSocket recibirSolicitud = new ServerSocket(9999);
            
            while(true) {
                Socket pideReporte=recibirSolicitud.accept();
            
                DataInputStream recibeSolicitud = new DataInputStream(pideReporte.getInputStream());
            
                String reporteSolicitud=recibeSolicitud.readUTF();
            
                solicitud_Report = reporteSolicitud;
            
                pideReporte.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ADMI_ESTACIONAMIENTOS.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
