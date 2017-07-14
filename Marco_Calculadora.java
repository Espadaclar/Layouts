import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;
/**
 *franciscoJavier, 12 / 07 / 2017
 */
public class Marco_Calculadora extends JFrame{
    private String cifra;//---------------ALMACENA LA CIFRA TECLEADA Y EL CARACTER DE LA OPERACION; '+', '*'
    private int valor1;// -----------------PRIMERA CIFRA ALMACENADA EN EL ARRAY num
    private int valor2;// -----------------SEGUNDA CIFRA ALMACENADA EN EL ARRAY num

    private String[] cifra1;
    private JPanel lamina2;

    private ArrayList<JButton> botones;
    private Matematica operacion = new Matematica();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marco_Calculadora marco = new Marco_Calculadora();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Marco_Calculadora() { 
        botones = new ArrayList<>();
        cifra = "";

        lamina2 = new JPanel();

        //instaciamos el objeoLamina y lo anadimos al frame.
        Lamina lamina = new Lamina();
        add(lamina);

        setBounds(100, 100, 450, 350);
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

            lamina2.setLayout(new GridLayout(5, 4));  
            creaBoton("7");// ----- DIBUJA VARIOS BOTONES EN Lamina2
            creaBoton("8");
            creaBoton("9");
            creaBoton("AC");
            creaBoton("4");
            creaBoton("5");
            creaBoton("6");
            creaBoton("/");
            creaBoton("1");
            creaBoton("2");
            creaBoton("3");
            creaBoton("*");
            creaBoton("0");
            creaBoton("=");
            creaBoton("-");
            creaBoton("+");
            creaBoton("");
            creaBoton("");
            creaBoton("");
            creaBoton("");

            //recorre todos los botones, ' auxBoton.addActionListener(oyente);' pone cada boton a la escucha
            //la accion que realiza cada uno de ello esta codificada en el mt 'actionPerformed(ActionEvent e)'
            for(int i = 0; i < botones.size(); i ++){
                JButton auxBoton = new JButton();
                auxBoton = botones.get(i);
                OyenteLamina oyente = new OyenteLamina();
                auxBoton.addActionListener(oyente);
            }

            add(lamina2, BorderLayout.CENTER); // ---- EN VEZ DE ANADIR LOS BOTONES, ANADE UNA LAMIMA CON VARIOS
            // BOTONES, Y LA SITUA EN LA ZONA CENTRO DEL MARCO
        }
    } 

    private void creaBoton(String nombre){
        JButton boton = new JButton(nombre);
        lamina2.add(boton);
        botones.add(boton);
    }

    private class OyenteLamina extends JPanel implements ActionListener{
        private String[] num;// ---------------ALMACENA LA CIFRA TECLEADA SEPARADA POR EL CARACTER DE LA OPERACION; '+', '*'     

        public OyenteLamina() { 
            num = new String[cifra.length()];
        }

        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand() != "=" && e.getActionCommand() != "AC"){// -- si se cumple la condicion
                cifra += e.  getActionCommand();//--- se almacenan el valor de cada boton pulsado en la variable `'cifra'
            }else if(e.getActionCommand() == "="){// -- si se cumple la condicion  ¡¡¡¡¡¡¡
                numerosTecleados();
            }
            else if(e.getActionCommand() == "AC"){// -- si se cumple la condicion  ¡¡¡¡¡¡¡
                dispose();
                System.out.println("Hasta la proxima. ¡¡¡¡");
            }
        }

        /**
         * divide el String tecleado en nº enteros para operar con ellos.
         */
        public void numerosTecleados(){

            if(cifra.contains("+") ){
                cifra1 =  cifra.split("\\+");
                valor1 = Integer.parseInt(cifra1[0]);
                valor2 = Integer.parseInt(cifra1[1]);
                operacion.suma(valor1, valor2);// -----llamada al mt suma() de la cl Matematica
            }else if(cifra.contains("*") ){
                cifra1 =  cifra.split("\\*");
                valor1 = Integer.parseInt(cifra1[0]);
                valor2 = Integer.parseInt(cifra1[1]);
                operacion.multiplica(valor1, valor2);
            }
            cifra = "";
        }
    }
}

