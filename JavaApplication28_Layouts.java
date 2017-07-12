import java.awt.*;
import javax.swing.*;

/**
 *franciscoJavier, 12 / 07 / 2017
 */
public class JavaApplication28_Layouts extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaApplication28_Layouts marco = new JavaApplication28_Layouts();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JavaApplication28_Layouts() {
        //instaciamos el objeoLamina y lo anadimos al frame.
        Lamina lamina = new Lamina();
        //para poder modificar el coportamiento por defecto, del Layout, se lo indicamos en el parametro del constructor.
         FlowLayout laminaMod = new FlowLayout(FlowLayout.RIGHT);
        lamina.setLayout(laminaMod);//---- asigna la modificacion a la lamina. 
        add(lamina);

        setBounds(100, 100, 890, 450);
        setTitle("Ventana para Layout");
        setVisible(true);
        
        Toolkit ic = Toolkit.getDefaultToolkit();
        Image icono = ic.getImage("../icono2.gif");
        setIconImage(icono);
        
        
    }
    
    private class Lamina extends JPanel{

        public Lamina() {
            add(new JButton("Azul"));
            add(new JButton("Rojo"));
            add(new JButton("Amarillo"));
        }
        
    }    
    
}























