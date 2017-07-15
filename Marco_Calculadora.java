import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;
/**
 *franciscoJavier, 12 / 07 / 2017
 *
 *ACTUALIZAMOS LA CALCULADORA;
 *  1º ---- H ADD UN NUEVO PARAM, QUE IMPLEMENTE (ActionListener), A LOS BOTONES NUMERICOS PARA QUE ESTEN A LA ESCUCHA
 *  2º ---- CODIGO EN 'actionPerformed(ActionEvent e)' PARA MOSTRAR LOS Nº EN LA PANTALLA DE LA CALCU.
 *  3º ---- DESARROLLAR EL ATRIBUTO 'boolean principio' PARA ELIMINAR UN 0 QUE APARECE EN LA CALCU.
 *  4º ---- ADD FUNCIONALIDAD A LOS BOTONES, para ello 1º anadimos los botones de las operaciones y creamos una nueva
 *              --clase inerna con la interface ActionListener  'AccionOrden implements ActionListener'.
 *  5º ----  private double resultado; // ------almacena el resultado de las operaciones que se van realizando.
 */
public class Marco_Calculadora extends JFrame{

    private boolean principio;// ----------DETECTA SI HAY TEXTO ESCRITO EN LA PANTALLA DE LA CALCULADORA
    // ---por defecto java a inicializa a false, pero la inicializamos a true al crear la lamina.
    private JPanel lamina2;
    private JButton pantalla ;// ------ muestra las operaciones de la calculadora.

    private double resultado; // ------almacena el resultado de las operaciones que se van realizando.
    //private String operacion; // ------almacena de texto de la tecla pulsada, su nombre en 'AccionOrden implements ActionListener{'
    private String ultimaOperacion;
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
            principio = true;// --el constructor de Lamina solo se ejecuta una vez en el programa 

            //asignaMOS una lamina AL MARCO  de disposicion o Layout BorderLayout()
            setLayout(new BorderLayout());// --EN LAS ZONAS DE ESTA LAMINA PEGAREMOS OTRAS LAMINAS
            //boton para mostrar resultado en la calculadora, ASIGNADO EN LA ZONA NORTE DE LA LAMINA.
            pantalla = new JButton("0");
            pantalla.setEnabled(false); ////----------  anula el boton.
            add(pantalla, BorderLayout.NORTH);//---- anade el boton a la lamina en la zona norte.

            lamina2.setLayout(new GridLayout(5, 4)); 
            ActionListener insertar = new InsertaNumero();//--- INSTANCIA PARA PASAR PARAMETRO A LOS BOTONES NUMERICOS
            ActionListener orden  = new AccionOrden();//--- INSTANCIA PARA PASAR PARAMETRO A LOS BOTONES DE OPERACIONES

            creaBoton("7", insertar);// ----- DIBUJA VARIOS BOTONES EN Lamina2
            creaBoton("8", insertar);
            creaBoton("9", insertar);
            creaBoton("AC", orden);
            creaBoton("4", insertar);
            creaBoton("5", insertar);
            creaBoton("6", insertar);
            creaBoton("/", orden);
            creaBoton("1", insertar);
            creaBoton("2", insertar);
            creaBoton("3", insertar);
            creaBoton("*", orden);
            creaBoton("0", insertar);
            creaBoton("=", orden);
            creaBoton("-", orden);
            creaBoton("+", orden);
            creaBoton("CerrarCalcu", orden);
            creaBoton("", orden);
            creaBoton("", orden);
            creaBoton("√", orden);

            add(lamina2, BorderLayout.CENTER); // ---- EN VEZ DE ANADIR LOS BOTONES, ANADE UNA LAMIMA CON VARIOS
            // BOTONES, Y LA SITUA EN LA ZONA CENTRO DEL MARCO

            ultimaOperacion = "=";
        }
    } 

    //  ADEMAS DE CREAR UN BOTON LO PONE A LA ESCUCHA MEDIANTe EL PARAMETRO 'ActionListener oyente'
    private void creaBoton(String nombre, ActionListener oyente){
        JButton boton = new JButton(nombre);
        boton.addActionListener(oyente); // ----------pone al boton a la escucha.
        lamina2.add(boton);
    }

    /**
     * Clase para gestionar los eventos
     */
    private class InsertaNumero implements ActionListener{

        public InsertaNumero() { 
        }

        //CADA VEZ QUE SE PRESIONA UN BOTON NUERICO SE EJECUTA EL CODIGO DE ESTE METODO.
        public void actionPerformed(ActionEvent e){
            //captura las teclas pulsadas
            String entrada = e.  getActionCommand();//--- se almacenan el valor del  boton pulsado 

            // ---- CODIGO PARA ELIMINAR EL 0 QUE APARECE POR DEFECTO EN LA PANTALLA DE LA CALCULADORA
            // cada vez que pulsamos un boton, el programa mira lo que vale principio, si es true, borra el tx de la calcu
            if(principio){//---------------si principio es verdadero, 
                pantalla.setText("");// ---elimina lo que aparece en la pantalla
                principio = false;// ------y pone a principio en false para que no borre mas, pero como java inicializa
                // a false, hay que inicializarlo a true cuando creamos la lamina. y cuando pulsemos un boton se borra
                // el 0 de la pantalla
            }
            pantalla.setText(pantalla.getText() + entrada);// ---pantalla.getText()' recupera el texto escrito anteriormente
        }
    }

    /**
     * Clase para gestionar los eventos de los botones de las operaciones; +, -, *, /
     */
    private class AccionOrden implements ActionListener{

        //CADA VEZ QUE SE PRESIONA UN BOTON DE OPERACIONES SE EJECUTA EL CODIGO DE ESTE METODO.
        public void actionPerformed(ActionEvent e){
            String operacion = e.getActionCommand();//--almacena el nombre de la tecla pulsada.

            // ---LLAMADA AL MT, ENCARGDO DE REALIZAR LAS OPERACIONES, LE PASAMOS COMO PARÁMETRO EL TEXTO QUE APARECE EN LA CALCULADORA.
            // --cada vez que pulsemos un boton de operacion le pasammoss a este mt el texto que tenemos en la pantalla de la calcu.
            calcular(Double.parseDouble(pantalla.getText())); // el texto en String lo pasamos a double

            ultimaOperacion = operacion;// --- para capturar el = y mostrar el resultado

            // --para eliminar la cifra de la pantalla cuando pulsamos un boton de operacion, utilizamos el boolean principio.
            principio= true;
        }

        /**
         * calcula todas las operaciones de los botones, es el cerebro de la calculadora.
         */
        public void calcular(double x){
            if(ultimaOperacion.equals("+")){
                resultado += x;
            }
            else if(ultimaOperacion.equals("-")){
                resultado -= x;
            }else if(ultimaOperacion.equals("*")){
                resultado *= x;
            }else if(ultimaOperacion.equals("/")){
                resultado /= x;
            }else if(ultimaOperacion.equals("√")){
                resultado = Math.sqrt(resultado);
            }else if(ultimaOperacion.equals("=")){
                resultado = x;
            }else if(ultimaOperacion.equals("AC")){
                resultado = 0;
            }else if(ultimaOperacion.equals("CerrarCalcu")){
                dispose();
            }
            pantalla.setText(""+resultado);
        }
    }
}




