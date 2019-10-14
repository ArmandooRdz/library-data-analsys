package com.armandordz.estructura;

import java.util.ArrayList;

public interface FuncionalidadDF {

    ArrayList<Row> head(); // Las primeras 10

    ArrayList<Row> head(int n); // n filas

    ArrayList<String> Dtypes(); // tipo de dato de cada columna

    ArrayList<String> Dtypes(int[] cols); // tipo de dato de la columna con indice tal

    void describe(int[] cols); // Solo para datos numericos



    void Sort(String columnName);

    void Sort(int columnIndex);

    }
