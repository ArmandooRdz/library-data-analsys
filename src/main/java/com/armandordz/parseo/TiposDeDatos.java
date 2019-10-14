
package com.armandordz.parseo;


public class TiposDeDatos {
    
    private Object dato;
    private String tipoDeDato;
    private float floatAux;
    private int intAux;
    private boolean boolAux;
    private String strAux;
    
    
    public TiposDeDatos(Object dato){
        this.dato = dato;
        this.tipoDeDato = saberTipoDeDato();
    }
    
    
    // Se hace la conversion del tipo de dato que realmente es con expresiones regulares
    public String saberTipoDeDato(){
        String auxDato;
        auxDato = this.dato.toString();
        
        if (auxDato.contains("NaN")){
            this.dato = "null";
            return "null";
            
        }else if (auxDato.matches("^-?[0-9]+$")){
           this.intAux = Integer.parseInt(auxDato);
           this.dato = (intAux);
           return "Integer";
        
        }else if (auxDato.matches("^-?[0-9]*+.{1}+[0-9]+$")){
            this.floatAux = Float.parseFloat(auxDato);
            this.dato = (floatAux);
            return "Float";
            
        }else if (auxDato.contains("true") || auxDato.contains("false")){
            this.boolAux = Boolean.parseBoolean(auxDato);
            this.dato = (boolAux);
            return "Boolean";
            
        }else{
           this.strAux = String.valueOf(auxDato);
           this.dato = (strAux);
            return "String";
        }
        
    }

    //-----Metodos get / set------
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
    
    public String getTipoDeDato(){
        return tipoDeDato;
    }
    
    public boolean getBoolAux(){
        return boolAux;
    }
    
    public float getFloatAux() {
        return floatAux;
    }

    public int getIntAux() {
        return intAux;
    }

    public boolean isBoolAux() {
        return boolAux;
    }

    public String getStrAux() {
        return strAux;
    }
    
    
    
    
    
    
}
