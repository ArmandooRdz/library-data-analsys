package com.armandordz.estadisticas;

import com.armandordz.estructura.Cell;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.functors.PredicateTransformer;

import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;

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

                if(columna.get(i).getValue() == "NaN") // Si es un campo vacío
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
            float min = (float)columna.get(0).getValue();

            for (int i = 0; i < columna.size(); i++){

                if(columna.get(i).getValue() == "NaN") // Si es un campo vacío
                    break;

                float aux = (float)columna.get(i).getValue();
                if(min > (float)columna.get(i).getValue()){

                }
            }
            return min;
        }

    }


}
