package com.armandordz.estructura;

import com.armandordz.estadisticas.IEstadisticas;
import java.util.ArrayList;

/**
 * Representa a una tabla. Posee:
 *  - Filas (ArrayList<Row>)
 *  - Cabecera o nombres columnas (ArrayList<String>)
 */

public class DataFrame implements FuncionalidadDF {

    private String nombre = "";
    private int columnsNumber = 0;
    private ArrayList<Row> rows = new ArrayList<>();
    private ArrayList<String> columnsNames = new ArrayList<>();
    private boolean objetoInstanciado = false;



    public DataFrame(){ }

    public DataFrame(String dataSetName, ArrayList<String> columnsNames){
        if(!rowsMismoNumeroColumnas(rows)){
            System.out.println("ERROR: El ArrayList no contiene el mismo numero de columnas para todas las filas\n" +
                    "o se encuentra vacío.");
            return;
        }
        if(rows.size() > 0 && columnsNames.size() != rows.get(0).getCellsNumber()){
            System.out.println("ERROR: Los ArrayList de entrada no coinciden en numero de columnas.");
            return;
        }
        this.nombre = dataSetName;
        this.columnsNumber = columnsNames.size();
        setColumnsNames(columnsNames);
        this.rows = rows;
        objetoInstanciado = true;
    }

    public DataFrame(String dataSetName, ArrayList<String> columnsNames, ArrayList<Row> rows){
        if(!rowsMismoNumeroColumnas(rows)){
            System.out.println("ERROR: El ArrayList no contiene el mismo numero de columnas para todas las filas\n" +
                    "o se encuentra vacío.");
            return;
        }
        if(rows.size() > 0 && columnsNames.size() != rows.get(0).getCellsNumber()){
            System.out.println("ERROR: Los ArrayList de entrada no coinciden en numero de columnas.");
            return;
        }
        this.nombre = dataSetName;
        this.columnsNumber = columnsNames.size();
        setColumnsNames(columnsNames);
        this.rows = rows;
        objetoInstanciado = true;
    }





    public void setColumnsNames(ArrayList<String> nomCol){
        this.columnsNames = nomCol;
    }


    public boolean rowsMismoNumeroColumnas(ArrayList<Row> rows){
        if(rows.size() == 0){
            System.out.println("ADVERTENCIA: DataSet no contiene filas.");
            return false;
        }
        int numColumnasPrimeraFila = rows.get(0).getCellsNumber();
        for (int i = 0; i < rows.size(); i++){
            if(numColumnasPrimeraFila != rows.get(i).getCellsNumber())
                return false;
        }
        return true;
    }

    // FIXME: No agrega la fila.
    public void setNewRow(Row f){
        if(f.getCellsNumber() != columnsNumber) {
            System.out.println("ERROR: No puede agregar una fila con campos nulos. " +
                    "Debe especificar \nla cadena NaN para campos vacíos si este es el caso.");
            return;
        }
        rows.add(f);
    }

    public ArrayList<Cell> recorrerColumna(String nomColumna){
        //TODO: Regregar todas las Cell de la columna [nomColumna].
        nomColumna = nomColumna.trim();
        int columnIndex = -1;
        ArrayList<Cell> columna = new ArrayList<>();
        for(int i = 0; i < columnsNames.size(); i++)
            if(columnsNames.get(i).equals(nomColumna.trim()))
                columnIndex = i;
        if(columnIndex == -1){
            System.out.println("ERROR: No se encontró la columna de nombre " + nomColumna + " y por tanto el\n" +
                    "método recorrerColumna() retornó null.");
            return null;
        }
        for (int i = 0; i < rows.size(); i++){
            columna.add(rows.get(i).getCell(columnIndex));
        }
        return columna;
    }

    public void printDataSet(){
        for (int i = 0; i < columnsNames.size(); i++){
            System.out.print(columnsNames.get(i) + "         ");
        }
        System.out.println();
        for (int f = 0; f < rows.size(); f++){
            for (int c = 0; c < rows.get(f).getCellsNumber(); c++){
                if(rows.get(f).getCell(c).getValue() == null){
                    System.out.print("NaN");
                    break;
                }
                System.out.print(" " + rows.get(f).getCell(c).getValue() + "           ");
            }
            System.out.println();
        }
    }


    public ArrayList<String> getColumnsNames(){
        return columnsNames;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        if(!rowsMismoNumeroColumnas(rows)){
            System.out.println("ERROR: No se puede asignar el grupo de filas al DataFrame. Asegúrese de que todas" +
                    "las filas cumplen con el mismo numero de columnas");
            return;
        }
        this.rows = rows;
    }

    @Override
    public ArrayList<Row> head() {
        if(rows.size() <= 10){
            return rows;
        }
        ArrayList<Row> rows2 = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            rows2.add(rows.get(i));
        }
        return rows2;
    }

    @Override
    public ArrayList<Row> head(int n) {
        ArrayList<Row> rowsretorno = new ArrayList<>();
        if(rows.size() <= n)
            return rows;
        for (int i = 0; i < n; i++)
            rowsretorno.add(rows.get(i));
        return rowsretorno;
    }

    @Override
    public ArrayList<String> Dtypes() {
        ArrayList<String> dataTypes = new ArrayList<>();
        for (int i = 0; i < rows.get(0).getCellsNumber(); i++){
            dataTypes.add(rows.get(0).getCell(i).getValue().getClass().getSimpleName());
        }
        return dataTypes;
    }

    @Override
    public ArrayList<String> Dtypes(int[] cols) {
        ArrayList<String> dataTypes = new ArrayList<>();
        for (int i = 0; i < cols.length; i++){
           for (int f = 0; f < rows.get(0).getCellsNumber(); f++){
               if(cols[i] == f){
                   dataTypes.add(rows.get(0).getCell(f).getValue().getClass().getSimpleName());
               }
           }
        }
        return dataTypes;
    }

    @Override
    public void describe(int[] cols) {


        float standardDeviation = 0.0f;
        float tendenciaC = 0.0f;
        for (int i = 0; i < cols.length; i++) {
            ArrayList<Cell> celdas = new ArrayList<>();
            if (!(rows.get(0).getCell(cols[i]).getValue() instanceof Integer) &&
                    !(rows.get(0).getCell(cols[i]).getValue() instanceof Float)) {
                break;
            }
            if (cols[i] >= rows.get(0).getCellsNumber() || cols[i] < 0)
                break;

            for (int f = 0; f < rows.size(); f++) {
                celdas.add(rows.get(f).getCell(cols[i]));
            }

            // impresiones
            System.out.println(" > Columna No." + cols[i]);
            System.out.println("Count              " + IEstadisticas.Count.calculate((celdas)));
            System.out.println("Mean               " + IEstadisticas.Mean.calculate(celdas));
            System.out.println("Std                " + IEstadisticas.StandardDeviation.calculate(celdas));
            System.out.println("Min                " + IEstadisticas.Min.calculate(celdas));
            System.out.println("Max                " + IEstadisticas.Max.calculate(celdas));
            System.out.println("Name: " + columnsNames.get(i) + "  DataType: " + celdas.get(0).getValue().getClass().getSimpleName());
        }

    }



    @Override
    public void Sort(String columnName) {

    }

    @Override
    public void Sort(int columnIndex) {

    }


}
