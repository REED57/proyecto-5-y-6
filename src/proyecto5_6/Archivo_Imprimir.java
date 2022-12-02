/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto5_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static proyecto5_6.MezclaNatural.jTextArea1;
import static proyecto5_6.MezclaNatural.jTextArea3;


public class Archivo_Imprimir {
    
   
  public static int leer(String nom) throws Exception{
      
    FileInputStream  abrir = new FileInputStream (nom);    
    int i = abrir.read();
    abrir.close();
    return i;
  }     
  public static void imprimir() throws Exception{
 
        FileInputStream abrir = new FileInputStream ("Original.txt");
        int dato;
        dato = abrir.read();
        System.out.println("Archivo Original");
        jTextArea1.setText(null);
        jTextArea3.append("Original : ");
        while(dato !=-1){// imprime el archivo original       
             System.out.print(" "+dato); 
              jTextArea3.append(""+dato+", ");
             jTextArea1.append(""+dato+", "); 
             dato = abrir.read();
        }
        abrir.close();
        System.out.print(" \n");  
        try{// // Cuando el archivo original esta ordenado, los dos archivo auxiliares no se crear , como se mandan a imprimir, se presenta un error la cual se atrapa dentro del try
             otros();
        }catch(Exception r){
        System.out.println("Fin");
    }
  }
  
  public static void otros() throws Exception{// imprime los auxiliares 1y2
   FileInputStream    a = new FileInputStream ("Auxi1.txt");
     FileInputStream         a1 = new FileInputStream ("Auxi2.txt");
            int e =a.read();
            int r = a1.read();
            jTextArea3.append("\n Auxi 1 : ");
            while(e !=-1){
                System.out.print(" "+e);
                jTextArea3.append(""+e+", ");
                e=a.read();
            }
            System.out.println("");
            jTextArea3.append("\n Auxi 2 : ");
            while(r !=-1){
                System.out.print(" "+r);
                jTextArea3.append(""+r+", ");
                r=a1.read();
            }
            jTextArea3.append("\n ");
            jTextArea3.append("-------------------------------------\n");
            System.out.println("");
            System.out.println("");
            
            a.close();
            a1.close();
  }
}
