import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;
/**
 *franciscoJavier, 12 / 07 / 2017
 */
public class Marco_Calculadora extends JFrame{
    JButton botonApagar = new JButton("  APAGAR ");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Marco_Calculadora marco = new Marco_Calculadora();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Marco_Calculadora() {        
        //instaciamos el objeoLamina y lo anadimos al frame.
        Lamina lamina = new Lamina();
        add(lamina);

        //         Lamina2 lamina2 = new Lamina2();
        //         lamina2.add(new JButton("Realizar operación"));
        //         add(lamina2, BorderLayout.NORTH);
        // 
        //         Lamina2 lamina3 = new Lamina2();
        //         lamina3.setLayout(new GridLayout(4, 1, 22, 22));
        //         lamina3.add(new JButton("    +      "));
        //         lamina3.add(new JButton("    -      "));
        //         lamina3.add(new JButton("    *      "));
        //         lamina3.add(new JButton("    /      "));
        //         add(lamina3, BorderLayout.WEST);
        // 
        //         Lamina2 lamina4 = new Lamina2();
        //         lamina4.setLayout(new GridLayout(1, 1, 22, 22));
        //         lamina4.add(new JButton("    =      "));
        //         add(lamina4, BorderLayout.EAST);
        // 
        //         Lamina2 lamina5 = new Lamina2();
        //         //lamina5.setLayout(new GridLayout());
        //         
        //         lamina5.add(botonApagar);
        //         add(lamina5, BorderLayout.SOUTH);
        //         botonApagar.addActionListener(lamina5);

        //coordenadas donde aparecera el marco dentro de pantalla del ordenador.
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
            //asigna una lamina un Tipo de disposicion o Layout
            setLayout(new BorderLayout());
            //boton para mostrar resultado en la calculadora.
            JButton pantalla = new JButton("0");
            pantalla.setEnabled(false);
            add(pantalla, BorderLayout.NORTH);
            
            //otra lamina para los nº de la calculadora.
            JPanel lamina2 = new JPanel();
            lamina2.setLayout(new GridLayout(5, 3));
            
            ArrayList<JButton> botones = new ArrayList<>();
            for(int i = 1; i < 16; i ++){
                String nombre = String.valueOf(i); 
                if(nombre.equals("10")){
                    nombre = "0";
                }else if(nombre.equals("11")){
                    nombre = " + ";
                }else if(nombre.equals("12")){
                    nombre = " - ";
                }else if(nombre.equals("13")){
                    nombre = " * ";
                }else if(nombre.equals("14")){
                    nombre = " / ";
                }else if(nombre.equals("15")){
                    nombre = "   ";
                }else if(nombre.equals("16")){
                    nombre = "  ";
                }
                JButton boton = new JButton(nombre );
                botones.add(boton);
            }
            for(int i = 0; i < botones.size(); i ++){
                lamina2.add(botones.get(i));
            }
            add(lamina2, BorderLayout.CENTER);
            //             add(new JButton("1"));
            //             add(new JButton("2"));
            //             add(new JButton("3"));
            //             add(new JButton("4"));
            //             add(new JButton("5")); 
            //             add(new JButton("6"));
            //             add(new JButton("7"));
            //             add(new JButton("8"));
            //             add(new JButton("9"));
            //             add(new JButton("0"));
        }
    } 
    private class Lamina2 extends JPanel implements ActionListener{
        public Lamina2() { 

        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == botonApagar){
                dispose();
                System.out.println("calculadora cerrada.");
            }
        }
    }

}

