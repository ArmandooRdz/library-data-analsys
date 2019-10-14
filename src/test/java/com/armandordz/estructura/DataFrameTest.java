package com.armandordz.estructura;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataFrameTest {


    private DataFrame intanciarDataFrame(){
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

        return ds;
    }

    @Test
    public void head() {
        DataFrame df = intanciarDataFrame();
        String printHeadMethod = "";

        for (int j = 0; j < df.head().size(); j++){
            for (int c  = 0; c < df.head().get(j).getCellsNumber(); c++)
                printHeadMethod = (df.head().get(j).getCell(c).getValue() + "\t\t");
            System.out.println();
        }

    }

    @Test
    public void testHead() {
    }

    @Test
    public void dtypes() {
    }

    @Test
    public void testDtypes() {
    }

    @Test
    public void describe() {
    }

    @Test
    public void testDescribe() {
    }

    @Test
    public void sort() {
    }

    @Test
    public void testSort() {
    }
}