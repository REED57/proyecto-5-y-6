package proyecto5_6;


public class Vector {
    
    int longitud;
    int[] arreglo;
    int[] arrtemp;
    
    public int getLongitud(){
        return longitud;
    }
    
    public void setLongitud(int longitud){
        this.longitud = longitud;
    }
    
    public int[] getArreglo(){
        return arreglo;
        
    }
    
    public void setArreglo(int[] arreglo){
        this.arreglo = arreglo;
    }
    
    public Vector ( ){
        this.longitud = 0;
        this.arreglo = null;
    }
    
    public Vector (int l){
        this.longitud = l;
        this.arreglo = new int [this.longitud];
    }
    
    public void inicializarVector(){
        if(this.arreglo == null){
            this.arreglo = new int [this.longitud];
        }
    }
    
    public void insertar (int pos, int val){
        if (this.arreglo !=null){
            this.arreglo[pos] = val;
        }
    }
    
    public String imprimir (){
        String datos = "";
        for (int i = 0; i < longitud; i++) {
            datos = datos + " " + String.valueOf(arreglo[i]);            
        }
        return datos;
    }
    
    public String imprimir (int[] arreglo){
        String datos = "";
        for (int i = 0; i < arreglo.length; i++) {
            datos = datos + " " + String.valueOf(arreglo[i]);
        }
        return datos;
    }
    
    public String busquedaSecuencial (int dato){
        String datos="";
        if (this.longitud>0){
            for (int i=0; i<this.longitud; i++){
                if(this.arreglo[i]==dato){
                    datos = datos + "Posición: "+ i + "\n";
                }
            }
        }
        if (datos.length()==0){
            return "No se encontró el dato: "+ dato + " en el vector";
        }
        else{
            return datos;
        }
    }
    
    public double promedio(){
        double suma=0;
        for(int i=0; i<this.longitud; i++){
            suma=suma+this.arreglo[i];
        }
        return (double) suma/this.longitud;
    }
    
    public int maximo(){
        int dato;
        dato=this.arreglo[0];
        
        for (int i=0; i<this.longitud; i++){
            if (dato<this.arreglo[i]){
                dato = this.arreglo[i];
            }
        }
        return dato;
    }
    public int minimo(){
        int dato;
        dato=this.arreglo[0];
        
        for (int i=0; i<this.longitud; i++){
            if(dato>this.arreglo[i]){
                dato=this.arreglo[i];
            }
        }
        return dato;
    }
    
    public boolean esNumero(String cadena){
        try{
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
