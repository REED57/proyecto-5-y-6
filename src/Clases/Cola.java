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
public class Cola {
    protected Nodo frente;
    protected Nodo fin;
    //constructor: se crea cola vacia
    public Cola()
    {
        frente = fin =null;
    }
    
    // insertar: pone el elemento por el final
    public void insertar (Object elemento)
    {
        Nodo a;
        a= new Nodo(elemento);
        if(colaVacia())
        {
            frente = a;
        } else
        {
            fin.siguiente = a;
        }
        fin =a;
    }
    
    // añadimos este metodo para agregar elementos
    public Object quitar() throws Exception{
    Object aux;
    if(!colaVacia())
    {
        aux= frente.elemento;
        frente = frente.siguiente;
    }else
        throw new Exception("Eliminar de una cola vacia");
        return aux;
    }
    

    public boolean colaVacia(){
        return (frente == null);
    }
    
    public Object ImprimitC(){
        String dato = ":\n";
        Nodo temporal=frente;
        while (temporal!=null){
            dato+=temporal.elemento+":\n";
            temporal=temporal.siguiente;
        }
        return dato;
    }
}
