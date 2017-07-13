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
            // 1º Para aplicar la disposicon o Layout 'BorderLayout()' instanciamos la clase directamente en 
            //    el mt setLayout(...), utilizando en este caso el constructor por defecto.
            setLayout(new BorderLayout(23, 45));
            // 2º tenemos que indicar a nuestros botones en que zona han de ubicarse N, S, E, O o en el CENTRO
            //    el mt, add() de la clase JPanel, admite un 2º argumento, que es la posicion que utiliza el componente.
            add(new JButton("Azul"),  BorderLayout.NORTH);
            add(new JButton("Rojo"), BorderLayout.SOUTH);
            add(new JButton("Amarillo"), BorderLayout.WEST);
            add(new JButton("Verde"), BorderLayout.CENTER);
            add(new JButton("Anaranjado"), BorderLayout.EAST);  
            //asigna la posicion de los objetos.
            //setLayout(new FlowLayout(FlowLayout.CENTER, 80, 100));
            // setLayout(new BorderLayout());
        }

    }    

}












