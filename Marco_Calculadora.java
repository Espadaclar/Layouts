import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;
/**
 *franciscoJavier, 12 / 07 / 2017
 */
public class Marco_Calculadora extends JFrame{
    
    private JPanel lamina2;
    private JButton AC;

    private Matematica operacion = new Matematica();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marco_Calculadora marco = new Marco_Calculadora();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Marco_Calculadora() { 
        lamina2 = new JPanel();
        
        //instaciamos el objeoLamina y lo anadimos al frame.
        Lamina lamina = new Lamina();
        add(lamina);

        setBounds(100, 100, 350, 450);
        setTitle("Ventana para Layout");
        setVisible(true);

        //elimina el icono que java da por defecto, y pone miIcono.
        Toolkit ic = Toolkit.getDefaultToolkit();
        Image icono = ic.getImage("../icono2.gif");
        setIconImage(icono);        
    }

    /**
     * Crea una lamina utilizando un Layout de tipo BorderLayout.
     */
    private class Lamina extends JPanel{
        public Lamina() { 
            //asignaMOS una lamina AL MARCO  de disposicion o Layout BorderLayout()
            setLayout(new BorderLayout());
            //boton para mostrar resultado en la calculadora.
            JButton pantalla = new JButton("0");
            pantalla.setEnabled(false); ////----------  anula el boton.
            add(pantalla, BorderLayout.NORTH);//---- anade el boton a la lamina en la zona norte.
            
            lamina2.setLayout(new GridLayout(4, 4));     
            creaBoton("7");
            creaBoton("8");
            creaBoton("9");
            creaBoton("/");
            creaBoton("4");
            creaBoton("5");
            creaBoton("6");
            creaBoton("*");
            creaBoton("1");
            creaBoton("2");
            creaBoton("3");
            creaBoton("-");
            creaBoton("0");
            creaBoton(",");
            //creaBoton("AC");
            creaBoton2();
            creaBoton(" +");

            OyenteLamina oyente = new OyenteLamina();
            AC.addActionListener(oyente);
            add(lamina2, BorderLayout.CENTER); // ---- EN VEZ DE ANADIR LOS BOTONES, ANADE UNA LAMIMA CON VARIOS
            // BOTONES, Y LA SITUA EN LA ZONA CENTRO DEL MARCO
        }
    } 

    private void creaBoton(String nombre){
        JButton boton = new JButton(nombre);
        lamina2.add(boton);
    }
     private void creaBoton2(){
        AC = new JButton("AC");
        lamina2.add(AC);        
    }

    private class OyenteLamina extends JPanel implements ActionListener{
        public OyenteLamina() { 

        }

        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand() == "AC"){
                dispose();
                //System.out.println("calculadora cerrada.");
            }
        }
    }

}

