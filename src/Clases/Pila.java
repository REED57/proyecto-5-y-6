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
public class Pila {
    private Nodo cima;
    
    
    public Pila(){
        cima = null;
        }
    // se crea la pila vacia 
    public boolean pilaVacia()
    {
        return cima == null;
    }
    // aqui estamos insertando metodo para agregar elementos de la pila
    public void insertar(Object elemento){
        Nodo nuevo;
        nuevo = new Nodo (elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }
    // aqui estamos instanciando metodo para quitar elemtos
    public Object quitar() throws Exception
    {
        Object aux;
        if(pilaVacia())
            throw new Exception ("Pila vacia, no se puede extraer.");
        aux = cima.elemento;
        cima =cima.siguiente;
        return aux;
    }
    // con este metodo podemos verlo que mandamos 
    public Object imp(){
        String dato = ":\n";
        Nodo temporal = cima;
        
        while(temporal!=null){
            dato+=temporal.elemento+":\n";
            temporal=temporal.siguiente;
        }
        return dato;
    }
}
