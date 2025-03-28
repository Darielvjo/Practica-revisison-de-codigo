package screensframework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validaciones {
    
    private Pattern p;
    private Matcher m;
    
    public Validaciones () {}
    
    /******* VALIDAR VACIOS ************/
    public boolean validarVacios(String datos, String nombreCampo) {
        if (datos.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo " + nombreCampo + " no puede estar vacío");
            return false;
        }
        return true;
    }
    
    /********* VALIDAR LONGITUD ****************/
    public boolean validarMaximo(String datos, String nombreCampo, int maximo, int minimo) {
        if (!datos.isEmpty()) {
            if (datos.length() > maximo || datos.length() < minimo) {
                JOptionPane.showMessageDialog(null, "Debe ser entre " + minimo + " y " + maximo + " caracteres para " + nombreCampo);
                return false;
            }
        }
        return true;
    }
    
    /******* VALIDAR CORREO ************/
    public boolean validarCorreo(String datos) {
        p = Pattern.compile("^[a-zA-Z0-9._%+-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$");
        m = p.matcher(datos);
        
        if (!datos.isEmpty()) {
            if (!m.matches()) {  // Cambié find() por matches()
                JOptionPane.showMessageDialog(null, "La dirección de correo es incorrecta");
                return false;
            }
        }
        return true;
    }
    
    /****** SOLO LETRAS *********/
    public boolean soloLetras(String datos) {
        p = Pattern.compile("^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$"); // Se corrigió para no aceptar vacío
        m = p.matcher(datos); 
        
        if (!datos.isEmpty()) {
            if (!m.matches()) {
                JOptionPane.showMessageDialog(null, "Solo se admiten letras");
                return false;
            }
        }
        return true;
    }
    
    /****** SOLO NÚMEROS *********/
    public boolean soloNumeros(String datos) {
        p = Pattern.compile("^[0-9]+$"); // Se corrigió para aceptar solo números
        m = p.matcher(datos); 
        
        if (!datos.isEmpty()) {
            if (!m.matches()) {
                JOptionPane.showMessageDialog(null, "Solo se admiten números");
                return false;
            }
        }
        return true;
    }
    
    /****** PASSWORD *********/
    public boolean validaPassword(String pass1, String pass2) {
        if (!pass1.equals(pass2)) { // Se simplificó la comparación
            JOptionPane.showMessageDialog(null, "Las contraseñas deben ser iguales");
            return false;
        }
        return true;
    }
}
