package com.armandordz;

import com.armandordz.estructura.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args ) {
        crearDataFrame();
    }
    public static void crearDataFrame(){
        metododeprueba();
    }

    // TODO: Instanciar clases para testearlas
    private static void metododeprueba() {

        ArrayList<Cell> celdas = new ArrayList<>();
        StringClass strCell = new StringClass("Armando");
        celdas.add(strCell);
        StringClass strCell2 = new StringClass("Rodriguez");
        celdas.add(strCell2);
        IntClass intCell = new IntClass(20);
        celdas.add(intCell);
        FloatClass floatClass = new FloatClass(1020.02f);
        celdas.add(floatClass);
        BooleanClass booleanClass = new BooleanClass(true);
        celdas.add(booleanClass);


        ArrayList<Cell> celdas2 = new ArrayList<>();
        StringClass strCell3 = new StringClass("Karla");
        celdas2.add(strCell3);
        StringClass strCell4 = new StringClass(null);
        celdas2.add(strCell4);
        IntClass intCell2 = new IntClass(19);
        celdas2.add(intCell2);
        FloatClass floatClass2 = new FloatClass(4092.27f);
        celdas2.add(floatClass2);
        BooleanClass booleanClass2 = new BooleanClass(false);
        celdas2.add(booleanClass2);


        ArrayList<Cell> celdas3 = new ArrayList<>();
        StringClass str = new StringClass("Steve");
        celdas3.add(str);
        StringClass str2 = new StringClass("Jobs");
        celdas3.add(str2);
        IntClass i = new IntClass(18);
        celdas3.add(i);
        FloatClass f = new FloatClass(1109.10f);
        celdas3.add(f);
        BooleanClass b = new BooleanClass(true);
        celdas3.add(b);

        Row fila = new Fila();
        fila.setArrayCells(celdas);
        Row fila2 = new Fila();
        fila2.setArrayCells(celdas2);
        Row fila3 = new Fila(celdas3);

        ArrayList<Row> rows = new ArrayList<>();
        rows.add(fila);
        rows.add(fila2);
        rows.add(fila3);


        ArrayList<String> cabecera = new ArrayList<>();
        cabecera.add("NOMBRE");
        cabecera.add("APELLIDO");
        cabecera.add("EDAD");
        cabecera.add("SUELDO");
        cabecera.add("BONO");


        DataFrame ds = new DataFrame();
        ds.setNombre("Tabal1");
        ds.setRows(rows);

        ds.setColumnsNames(cabecera);

        for (int j = 0; j < ds.getColumnsNames().size(); j++){
            System.out.print(ds.getColumnsNames().get(j) + "\t\t\t");
        }
        System.out.println();
        ds.printDataSet();


        System.out.println("\nMetodo Head()");
        for (int j = 0; j < ds.head().size(); j++){
            for (int c  = 0; c < ds.head().get(j).getCellsNumber(); c++)
                System.out.print(ds.head().get(j).getCell(c).getValue() + "\t\t");
            System.out.println();
        }


        System.out.println("\nMetodo Head(int n)");
        for (int j = 0; j < ds.head(21).size(); j++){
            for (int c  = 0; c < ds.head(21).get(j).getCellsNumber(); c++)
                System.out.print(ds.head(21).get(j).getCell(c).getValue() + "\t\t");
            System.out.println();
        }


        ArrayList<String> dataTypes;
        dataTypes = ds.Dtypes();
        System.out.println("\nMétodo Dtypes()");
        for (int z = 0; z < ds.Dtypes().size(); z++){
            System.out.println(dataTypes.get(z));
        }


        System.out.println();
        int[] c = {0,3,4,8};
        dataTypes = ds.Dtypes(c);
        System.out.println("Método Dtypes(int[] cols)");
        for (int z = 0; z < dataTypes.size(); z++){
            System.out.println(dataTypes.get(z));
        }


        int[] cols = {2,3};
        ds.describe(cols);


    }





}
