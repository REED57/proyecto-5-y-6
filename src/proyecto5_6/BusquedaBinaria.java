package proyecto5_6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BusquedaBinaria extends JFrame implements ActionListener{
    JLabel etiqueta1, metodos;
    JTextField numero;
    JButton boton0, boton1, boton2, boton3, salir;
    int limite;
    public BusquedaBinaria(){
        // Titulo de pestaña de ventana
        super("Búsqueda Binaria");
        Container contenedor=getContentPane();
        contenedor.setLayout(new FlowLayout());
        inicializar();
        // Titulo principal
        etiqueta1=new JLabel("BÚSQUEDA BINARIA");
        etiqueta1.setBackground(Color.BLACK); // Color de fondo 
        etiqueta1.setForeground(Color.BLACK); // Color de texto
        etiqueta1.setFont(new Font("Consolas", 0, 23)); // Tipo y tamaño de letra
        contenedor.add(etiqueta1);
        
        numero=new JTextField(15);
        contenedor.add(numero);
        
        // Boton para ingresar cadenas
        boton0=new JButton("Ingresa Nombre del Alumno");
        boton0.addActionListener(this);
        boton0.setBackground(Color.WHITE); // Color de fondo 
        boton0.setForeground(Color.BLUE); // Color de texto
        boton0.setFont(new Font("Consolas", 0, 20)); // Tipo y tamaño de letra
        contenedor.add(boton0);
        
        // Subtitulo Metodo
        metodos=new JLabel("MÉTODO n");
        metodos.setBackground(Color.BLACK); // Color de fondo 
        metodos.setForeground(Color.BLACK); // Color de texto
        metodos.setFont(new Font("Consolas", 0, 20)); // Tipo y tamaño de letra
        contenedor.add(metodos);
        
        // Boton Metodo Busqueda Binaria
        boton2= new JButton("Método Búsqueda Binaria");
        boton2.setBackground(Color.BLUE); // Color de fondo 
        boton2.setForeground(Color.WHITE); // Color de texto
        boton2.setFont(new Font("Consolas", 0, 20)); // Tipo y tamaño de letra
        contenedor.add(boton2);
        boton2.addActionListener(this);
                
        //Boton Regresar
        boton3 = new JButton("Regresar");
        boton3.setBackground(Color.BLUE);
        boton3.setForeground(Color.WHITE);
        boton3.setFont(new Font("Consolas", 0, 20));
        contenedor.add(boton3);
        boton3.addActionListener(this);
        
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
        BusquedaBinaria aplicacion= new BusquedaBinaria();
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
            salida+=" "+ a[i];
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
        
        if(evento.getSource().equals(boton3)){
            Gui g = new Gui();
            g.setVisible(true);
            this.dispose();
        }
        
        if(evento.getSource()==boton2){
           String dato;
           dato = JOptionPane.showInputDialog(null,">¿Que alumno quieres buscar?");
           Binaria(a, dato);
        }
    }
    
    public void inicializar(){
        String texto = JOptionPane.showInputDialog(">¿Cuantos alumnos deseas ingresar?");
        limite = Integer.parseInt(texto);
        a = new String [limite];      
    }
    
    // Metodo Busqueda Binaria
   public void Binaria(String A[], String X) {
          int izq, der, cen = 0;
          boolean band=false;
          izq=0; der=A.length-1;
          while((izq<=der) && (band==false)) {
          cen=((izq+der)/2);
          if((int)X.charAt(0) == (int)A[cen].charAt(0)){
          band=true;
          } else {
          if((int)X.charAt(0)<=(int)A[cen].charAt(0)){
          izq=cen+1;
          } else
          der=cen-1;   
          }
          }
          if(band==true){
          JOptionPane.showMessageDialog(null,">El alumno se encuentra en la posicion:"+cen);
          } else{          
          JOptionPane.showMessageDialog(null,">El alumno no se encuentra...");
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