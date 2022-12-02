/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto5_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Ordenar {
      FileOutputStream  archivo;
      FileInputStream a1;
      FileInputStream a2;
      int con1=1;
      int con2=1;
      int b1=0,b2=0;
      
      int asta;
      int k;

    public Ordenar(int ast) {          
            this.asta = ast;
            k=asta;// contien el tamaño de cada Subdivisión
    }
      
    public  void ordenar() throws IOException, Exception{      
        archivo = new FileOutputStream(new File("Original.txt"),true);  // VOLVEMOS A CREAR EL ARCHIVO ORIGINAL   
        a1 = new FileInputStream ("Auxi1.txt");
        a2 = new FileInputStream ("Auxi2.txt");        
        b1 =a1.read();//leemos el primer dato de cada archivo
        b2= a2.read();
        while(b1 != -1 || b2 != -1){ //se repite hasta que algunos de los dos auxiliares estén vacío
          if(b1==-1){ pp2(); break;}// si el archivo auxilar uno está vací se pasa directamente el archivo 2 al original 
          else if(b2==-1){pp1();break;}  // si el archivo auxilar 2 está vací se pasa directamente el archivo 1 al original 
         
         while(true){
             if(b1==-1){ pp2(); break;}
             else if(b2==-1){pp1();break;}
             if(b1<b2){//se va comparando  si el número que contiene el archivo 1 es menor que el del archivo 2 pasa directamente al archivo original 
                archivo.write(b1);       // se escribe en el original                
                b1 = a1.read(); //se lee para pasar a la sig. posición 
                con1++;
             }
             else{
                  archivo.write(b2);                      
                  b2 = a2.read(); 
                  con2++;// variable Para saber si ya se leyó el último elemento de la subdivision  del archivo, si es del mismo tamaño de de k+1
             }
             /*
             ejemplo 2,5,8,2,64,1
             para la primera division i = 0 por tanto asta vale 1  asta = (int) Math.pow(2, i);
             
             auxi1 = 2,8,64
             auxi2 = 5,2,1
             donde k toma el valor de asta
             
             luego el original quedaria = 2 2 5 8 1 64        

             
             segunda division, esta se hace despues de haber mesclado los dos archiovos 
             
             */
             
             
             
             //System.out.println(""+asta);
            if(con1 == k+1){
              pasar2();break;
            }
            if(con2 == k+1){
              pasar1();break;
            }
       }
         k  += asta;
     }
   archivo.close();
   a1.close();
   a2.close();
   Archivo_Imprimir.imprimir();
    }
    void pasar1() throws IOException{
      while(con1<=k && b1 !=-1){
            archivo.write(b1);
            b1 =a1.read();
            con1++;       
      }  
    }
    void pasar2() throws IOException{
      while(con2<=k && b2 !=-1){
            archivo.write(b2);
            b2 =a2.read();
            con2++;       
      }  
    }
    void pp1() throws IOException{
        while(b1 !=-1){
            archivo.write(b1);
            b1 =a1.read();                 
      } 
    }
    void pp2() throws IOException{
        while(b2 !=-1){
            archivo.write(b2);
            b2 =a2.read();
                 
      } 
    }
    
}
