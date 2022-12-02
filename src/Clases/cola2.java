/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author neima
 */
//se crea la clase junto con el objeto 
public class cola2 {
    Object Cola[] = new Object[5];
    int colas = 0;

    public void push(String x) {
        if (colas < 5) {
            Cola[colas] = x;
            colas++;
        }
    }
// este metodo nos ayuda a quitar los elementos de las listas
    public void pop() {
        if (colas > 0) {
            Cola[0] = null;
            for (int z = 1; z < colas; z++) 
                Cola[z-1] = Cola[z];
         
        }
        colas--;
    }
//aqui se ven los elementos de las pilas
    public String VerCola() {
        String v = "";
        if (colas == 0) {
            v = "No hay elementos";
        } else {
            for (int s = 0; s < colas; s++) 
                v += ("Elemento:  " + (s) + " -> " + Cola[s] + "\n");
        }
        return v;
    }
// no dice el numero de elelementos dentro de la cola
    public String Elementos() {
        String elementos;
        elementos = (" Num. de elementos " + colas);
        return elementos;
    }
// este metodo nos ayuda a saber si la lista esta vacia o llena 
    public String Tope() {
        String llena = "";
        if (colas == 5) {
            llena = "llena";
        } else {
            llena = "no esta llena";
        }
        return llena;

    }

    public String Vacia() {
        String vacia = "";
        if (colas <=0) {
            vacia = "vacia";
        } else {
            vacia = "no esta vacia";
        }
        return vacia;
    }

    public String PrimerElemnto() {
        String pri = " ";
        if (Cola[0] != null) {
            pri = ("Primer elemento:  " + Cola[0]);

        } else {
            pri = "No hay elementos ";
        }
        return pri;
    }

    public String UltimoElemento() {
        String u;
        if (Cola[0] != null) {
            u = (" Ultimo elemento:  " + Cola[colas-1]);

        } else {
            u = (" No hay elementos bro ._.");
        }
        return u;
    }

    public void VaciarC() {
        
        for (int i = colas - 1; i >= 0; i--) 
            Cola[i] = null;
            colas = 0;
 
            }
}
