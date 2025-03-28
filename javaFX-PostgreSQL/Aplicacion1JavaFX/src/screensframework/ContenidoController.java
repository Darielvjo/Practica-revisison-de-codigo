package screensframework;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Wil
 */
public class ContenidoController implements Initializable, ControlledScreen {
    
    private ScreensController controlador;
    private final ControlesBasicos controlesBasicos = new ControlesBasicos();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Código de inicialización si es necesario
    }    

    @Override
    public void setScreenParent(ScreensController pantallaPadre) {
        this.controlador = pantallaPadre; 
    }
    
    @FXML
    private void irMantenimientoProducto(ActionEvent event) {
        if (controlador != null) {
            controlador.setScreen(ScreensFramework.mantenimientoProductoID);
        } else {
            mostrarAlerta("Error", "No se pudo cambiar de pantalla.");
        }
    }
    
    @FXML
    private void salir(ActionEvent event) {
        Platform.exit();
    }
    
    @FXML
    private void cerrarSesion(ActionEvent event) {
        if (controlador != null) {
            controlador.setScreen(ScreensFramework.loginID);
        } else {
            mostrarAlerta("Error", "No se pudo cerrar sesión.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
