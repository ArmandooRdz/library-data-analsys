package com.armandordz.estructura;

public interface Cell {

    /**
     * Sobrecarga de métodos para crear objeto que implemente Cell según el tipo de dato:
     *  - StringClass
     *  - FloatClass
     *  - IntClass
     *  - BooleanClass
     *  Retorna la instancia dependiento el parametro:
     */
    class NewContent{
        static Cell receiveNewContent(String str){
            Cell celdaStr = new StringClass(str.trim());
            return celdaStr;
        }
        static Cell receiveNewContent(Float f){
            Cell celdaFloat = new FloatClass(f);
            return celdaFloat;
        }
        static Cell receiveNewContent(int i){
            Cell celdaInt = new IntClass(i);
            return celdaInt;
        }
        static Cell receiveNewContent(boolean b){
            Cell celdaInt = new BooleanClass(b);
            return celdaInt;
        }
    }

    void printValue(); // Imprimir contenido

    void toNaN(); // Coloca la denominacion NaN = celda vacía.

    Object getValue();



}
