package proyecto5_6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class QuickSort extends JFrame implements ActionListener{
    JLabel etiqueta1, metodos;
    JTextField numero;
    JButton boton0, boton1, boton3, boton4, salir;
    int limite;
    public QuickSort(){
        // Titulo de pestaña de ventana
        super("Quicksort Recursivo");
        Container contenedor=getContentPane();
        contenedor.setLayout(new FlowLayout());
        inicializar();
        // Titulo principal
        etiqueta1=new JLabel("QUICKSORT RECURSIVO");
        etiqueta1.setBackground(Color.BLACK); // Color de fondo 
        etiqueta1.setForeground(Color.BLACK); // Color de texto
        etiqueta1.setFont(new Font("Consolas", 0, 23)); // Tipo y tamaño de letra
        contenedor.add(etiqueta1);
        
        numero=new JTextField(15);
        contenedor.add(numero);
        
        // Boton para ingresar cadenas
        boton0=new JButton("Ingresa");
        boton0.addActionListener(this);
        boton0.setBackground(Color.WHITE); // Color de fondo 
        boton0.setForeground(Color.BLUE); // Color de texto
        boton0.setFont(new Font("Consolas", 0, 20)); // Tipo y tamaño de letra
        contenedor.add(boton0);
        
        // Boton para mostrar cadenas
        boton3=new JButton("Muestra");
        boton3.addActionListener(this);
        boton3.setBackground(Color.WHITE); // Color de fondo 
        boton3.setForeground(Color.BLUE); // Color de texto
        boton3.setFont(new Font("Consolas", 0, 20)); // Tipo y tamaño de letra
        contenedor.add(boton3);
        
        // Subtitulo Metodo
        metodos=new JLabel("MÉTODO n");
        metodos.setBackground(Color.BLACK); // Color de fondo 
        metodos.setForeground(Color.BLACK); // Color de texto
        metodos.setFont(new Font("Consolas", 0, 20)); // Tipo y tamaño de letra
        contenedor.add(metodos);
        
        // Boton Metodo Quicksort Recursivo
        boton1= new JButton("Método Quicksort R.");
        boton1.setBackground(Color.BLUE); // Color de fondo 
        boton1.setForeground(Color.WHITE); // Color de texto
        boton1.setFont(new Font("Consolas", 0, 20)); // Tipo y tamaño de letra
        contenedor.add(boton1);
        boton1.addActionListener(this);
        
        //Boton Regresar
        boton4 = new JButton("Regresar");
        boton4.setBackground(Color.BLUE);
        boton4.setForeground(Color.WHITE);
        boton4.setFont(new Font("Consolas", 0, 20));
        contenedor.add(boton4);
        boton4.addActionListener(this);
        
        
        // JButton que agrega un boton Salir
        salir=new JButton("Salir");
        salir.setBackground(Color.WHITE);
        salir.setForeground(Color.BLUE);
        salir.setFont(new Font("Consolas", 0, 20)); // Tipo y tamaño de letra
        contenedor.add(salir);
        salir.addActionListener(this);
    }
    
    // Main Principal
    public static void main(String[] args) {
        QuickSort aplicacion= new QuickSort();
        // Tamaño de ventana
        aplicacion.setSize(300,300);
        // Visible
        aplicacion.setVisible(true);
        // Centrada
        aplicacion.setLocationRelativeTo(null);
        // Cierre
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Cantidad de valores a ordenar
    String a[];
    int i=0;
    String salida=">Orden Original: n";
    
    // Metodo para ingresar valores
    public void actionPerformed(ActionEvent evento){
        if (evento.getSource()==boton0){
            a[i]=numero.getText();
            salida+=" "+a[i];
            i++;
            numero.setText("");
            if(i==a.length){
                JOptionPane.showMessageDialog(null,">Fin de Ingreso");
            }
        }
        
        // Accion para salir
        if(evento.getSource().equals(salir)) {
            System.exit(0);
        }
         
        if(evento.getSource()==boton1){
           quicksort_recursivo(a);
        }
        
        if (evento.getSource()==boton3){
            salida+="> Nuevo Orden: n";
            muestra(a);
            }
        
        if (evento.getSource().equals(boton4)){
            Gui g = new Gui();
            g.setVisible(true);
            this.dispose();
        }
    }
    
    public void inicializar(){
        String texto = JOptionPane.showInputDialog(">¿Cuantos nombres deseas ingresar?");
        limite = Integer.parseInt(texto);
        a = new String [ limite];      
    }
    
    // Metodo Quicksort Recursivo
    public void quicksort_recursivo(String a1[]) {
        reduce_recursivo(a1, 0, a1.length - 1);
        JOptionPane.showMessageDialog(null,">Cadenas Ordenados");

    }
    // Reduce
    public void reduce_recursivo(String a1[], int ini, int fin) {
        int izq = ini, der = fin, pos = ini;
        String aux="";
        boolean band = true;
        while (band) {
            band = false;
            while ((a1[der].charAt(0) >= a1[pos].charAt(0)) && (pos != der)) der = der - 1; 
            if (pos != der) {
                aux = a1[pos];
                a1[pos] = a1[der];
                a1[der] = aux;
                pos = der;
                while ((a1[izq].charAt(0) < a1[pos].charAt(0)) && (pos != izq)) izq = izq + 1;
                if (pos != izq) {
                    band = true;
                    aux = a1[pos];
                    a1[pos] = a1[izq];
                    a1[izq] = aux;        
                    pos = izq;
                }
            }
        }
        if (ini < (pos - 1)) {
            reduce_recursivo(a1, ini, pos - 1);
        }
        if ((pos + 1) < fin) {
            reduce_recursivo(a1, pos + 1, fin);
        }
    }
     
    // Metodo para mostrar valores
    public void muestra(String a2[]){
        for (int i=0;i<a2.length;i++){
            salida+=a2[i]+" ";
        }
        JOptionPane.showMessageDialog(null,salida);
    }  
}
