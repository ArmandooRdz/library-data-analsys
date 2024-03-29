package com.armandordz;

import com.armandordz.estructura.*;
import com.armandordz.lectura.Archivo;
import com.armandordz.parseo.ParseoDeStrings;

public class App {

    public static void main(String[] args ) throws Exception {
        instanciasDePrueba();
    }

    public static void instanciasDePrueba() throws Exception {

        Archivo file = new Archivo("/media/armando_rdz/Archivos/UPV/VII Cuatrimestre/POO/exam-u1/csv/prueba.csv");
        ParseoDeStrings parse = new ParseoDeStrings(file);

        DataFrame dataFrame = parse.getDataFrame();
        dataFrame.setColumnsNames(file.getColumns());
        System.out.println(">Tabla " + dataFrame.getNombre().toUpperCase());
        dataFrame.printDataSet();

        System.out.println("\n\n>Metodo Head() ");
        for (int i = 0; i < dataFrame.head().size(); i++){
            for (int f = 0; f < dataFrame.getRows().get(0).getCellsNumber(); f++)
                System.out.print(dataFrame.head().get(i).getCell(f).getValue()+ "       ");
            System.out.println();
        }
        System.out.println();


        System.out.println("\n\n>Metodo Head(int n) ");
        for (int i = 0; i < dataFrame.head(3).size(); i++){
            for (int f = 0; f < dataFrame.getRows().get(0).getCellsNumber(); f++)
                System.out.print(dataFrame.head(3).get(i).getCell(f).getValue()+ "       ");
            System.out.println();
        }
        System.out.println();

        System.out.println("\n\n>Metodo Dtypes()");
        for (int i = 0; i < dataFrame.Dtypes().size(); i++){
            System.out.println(dataFrame.Dtypes().get(i));
        }
        System.out.println();

        System.out.println("\n\n>Metodo Dtypes(int[] indexCols)");
        int[] indiceColumnas = {2,4};
        for (int i = 0; i < dataFrame.Dtypes(indiceColumnas).size(); i++){
            System.out.println(dataFrame.Dtypes(indiceColumnas).get(i));
        }
        System.out.println();

        System.out.println(">Metodo Describe(int[] indexCols)");
        int[] indiceColumnasDescribir = {2,4};
        dataFrame.describe(indiceColumnasDescribir);



    }





}
