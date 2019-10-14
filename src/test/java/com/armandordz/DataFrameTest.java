package com.armandordz;

import com.armandordz.estructura.DataFrame;
import com.armandordz.estructura.Row;
import com.armandordz.lectura.Archivo;
import com.armandordz.parseo.ParseoDeStrings;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DataFrameTest {

    private DataFrame instanciarDataFrame() throws Exception {
        Archivo file = new Archivo("/media/armando_rdz/Archivos/UPV/VII Cuatrimestre/POO/exam-u1/csv/prueba.csv");
        ParseoDeStrings parse = new ParseoDeStrings(file);

        DataFrame dataFrame = parse.getDataFrame();
        dataFrame.setColumnsNames(file.getColumns());
        System.out.println(">Tabla " + dataFrame.getNombre().toUpperCase());
        return dataFrame;
    }

    @Test
    public void head() throws Exception {
        DataFrame df = instanciarDataFrame();
        ArrayList<Row> rows = new ArrayList<>();

        rows = df.head();

        Assert.assertEquals(7, rows.size());
    }

    @Test
    public void testHead() throws Exception {
        DataFrame df = instanciarDataFrame();
        ArrayList<Row> rows;
        ArrayList<Row> primrasFilas = new ArrayList<>();

        primrasFilas.add(df.getRows().get(0));
        primrasFilas.add(df.getRows().get(1));
        primrasFilas.add(df.getRows().get(2));
        primrasFilas.add(df.getRows().get(3));

        rows = df.head(4);


        Assert.assertEquals(rows, primrasFilas);
        assertNotNull(rows);
        assertNotNull(primrasFilas);

    }

    @Test
    public void dtypes() throws Exception {
        DataFrame df = instanciarDataFrame();
        ArrayList<String> expectedValue = new ArrayList<>();
        ArrayList<String> actualValue ;

        actualValue = df.Dtypes();
        expectedValue.add("String");
        expectedValue.add("String");
        expectedValue.add("Float");
        expectedValue.add("String");
        expectedValue.add("Integer");
        expectedValue.add("String");

        assertNotNull(actualValue);
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testDtypes() throws Exception {
        DataFrame df = instanciarDataFrame();
        ArrayList<String> expectedValue = new ArrayList<>();
        ArrayList<String> actualValue ;
        int[] cols = {1,3,4};

        actualValue = df.Dtypes(cols);
        expectedValue.add("String");
        expectedValue.add("String");
        expectedValue.add("Integer");

        assertNotNull(actualValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void describe() throws Exception {
        DataFrame df = instanciarDataFrame();
        int[] indiceColumnas = {2,4};
        df.describe(indiceColumnas);
    }

    @Test
    public void sort() {
    }

    @Test
    public void testSort() {
    }
}