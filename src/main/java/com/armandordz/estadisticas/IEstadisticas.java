package com.armandordz.estadisticas;

import com.armandordz.estructura.Cell;
import java.util.ArrayList;
import java.lang.Math;

public interface IEstadisticas {


    class StandardDeviation{

        static public float calculate(ArrayList<Cell> columna){
            float sd = 0.0f, suma = 0.0f;
            int numDatos = columna.size();
            float varianza = 0.0f;
            // Convertir ArrayList columna a tipo de dato float.
            ArrayList<Float> columnaF = new ArrayList<>();
            float valueConverted = 0.0f;
            for (int i = 0; i < columna.size(); i++){
                if(columna.get(i).getValue() == "null")
                    break;
                if(columna.get(i).getValue() instanceof  Integer)
                    valueConverted = (int) (columna.get(i).getValue());
                else if(columna.get(i).getValue() instanceof Float)
                    valueConverted = (float) (columna.get(i).getValue());
                columnaF.add(valueConverted);
            }

            // Mean
            for (float n : columnaF){
                suma += n;
            }
            float media = suma/numDatos;

            for (int i = 0; i < columna.size(); i++){
                if(columna.get(i).getValue() == "null") break;
                String strValue = columna.get(i).getValue().toString();
                float value = Float.parseFloat(strValue);
                float rango = (float) Math.pow(value - media, 2f);
                varianza = varianza + rango;
            }
            varianza = varianza / columna.size();
            sd = (float) Math.sqrt(varianza);
            return sd;
        }
    }

    class Count{
        static public int calculate(ArrayList<Cell> columna){
            return columna.size();
        }
    }

    class Mean{
        static public float calculate (ArrayList<Cell> columna){
            float suma = 0.0f;
            for (int i = 0; i < columna.size(); i++) {

                if(columna.get(i).getValue() == "null") // Si es un campo vacío
                    break;

                if(columna.get(i).getValue() instanceof  Integer)
                    suma += (int) (columna.get(i).getValue());
                else if(columna.get(i).getValue() instanceof Float)
                    suma += (float) (columna.get(i).getValue());
            }
            return (suma/columna.size());
        }
    }


    class Min{
        public static float calculate(ArrayList<Cell> columna){
            float min = 0.0f;
            if(columna.get(0).getValue() instanceof  Integer) {
                min = (int) columna.get(0).getValue();
            }else if(columna.get(0).getValue() instanceof Float) {
                min = (float) columna.get(0).getValue();
            }
            float aux = 0.0f;

            for (int i = 0; i < columna.size(); i++){

                if(columna.get(i).getValue() == "null") // Si es un campo vacío
                    break;

                if(columna.get(i).getValue() instanceof  Integer) {
                    aux = (int) columna.get(i).getValue();
                }else if(columna.get(i).getValue() instanceof Float) {
                    aux = (float) columna.get(i).getValue();
                }
                if(min > aux){
                    min = aux;
                }
            }
            return min;
        }

    }

    class Max{
        public static float calculate(ArrayList<Cell> columna){
                float max = 0.0f;
                if(columna.get(0).getValue() instanceof  Integer) {
                    max = (int) columna.get(0).getValue();
                }else if(columna.get(0).getValue() instanceof Float) {
                    max = (float) columna.get(0).getValue();
                }
                float aux = 0.0f;

                for (int i = 0; i < columna.size(); i++){

                    if(columna.get(i).getValue() == "null") // Si es un campo vacío
                        break;

                    if(columna.get(i).getValue() instanceof  Integer) {
                        aux = (int) columna.get(i).getValue();
                    }else if(columna.get(i).getValue() instanceof Float) {
                        aux = (float) columna.get(i).getValue();
                    }
                    if(max < aux){
                        max = aux;
                    }
                }
                return max;

        }
    }



}
