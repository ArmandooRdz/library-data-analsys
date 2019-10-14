
package com.armandordz.lectura;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {

    private final String PATH;
    private ArrayList<String> cells = new ArrayList<String>();
    private ArrayList<String> columns = new ArrayList<String>();
    private ArrayList<String> rows = new ArrayList<String>();

    public Archivo(String path) throws Exception{
        this.PATH = path;
        leerArchivoCSV();
    }

    private void leerArchivoCSV() throws IOException{
        CSVReader csvReader = new CSVReader(new FileReader(PATH));
        Object[] auxRecorrer = null;
        String[] filasDelArchivoAUX = new String[numeroDeFilas()];

        //----Funciones para agregar filas, columnas y campos
        agregarColumnas(csvReader,auxRecorrer,filasDelArchivoAUX);
        filasDelArchivoAUX = agregarFilas(filasDelArchivoAUX);
        pasarFilasDeStringAArray(filasDelArchivoAUX); // se modifica el atributo filasDelArchivo (arrayList)

    }

    public void printRows(){
        for (int i = 0; i< rows.size(); i++)
            System.out.println(rows.get(i));
    }

    public void printColumns(){
        for (int i = 0; i< columns.size(); i++)
            System.out.println(columns.get(i));
    }

    public void printAllCells(){
        for (int i = 0; i< cells.size(); i++)
            System.out.println(cells.get(i));
    }

    private boolean saberSiElSiguienteCampoYaNoEsUnaColumna(int posicion){
        return posicion == 0;
    }

    private String[] igualarStringAVacio(String[] filas) throws IOException{
        for (int i=0;i<numeroDeFilas();i++)
            filas[i] = "";

        return filas;
    }

    private String[] agregarFilas(String[] filasAux) throws IOException{
        int aumento = 0;
        filasAux = igualarStringAVacio(filasAux);

        for (int i=0;i<numeroDeFilas()-1;i++){

            for (int r = aumento; r< columns.size() + aumento ; r++)
                filasAux[i] = filasAux[i] + cells.get(r)+ ",";

            aumento = aumento + columns.size();
        }
        return filasAux;
    }

    private void agregarColumnas(CSVReader csvReader, Object[] auxRecorrer, String[] filasDelArchivoAUX) throws IOException{

        int j = 0,k = 0,i = 0;
        boolean bolAux = true;
        while ((auxRecorrer = csvReader.readNext()) != null) {
            bolAux = saberSiElSiguienteCampoYaNoEsUnaColumna(i);
            for (Object cell : auxRecorrer) {
                if (bolAux){
                    columns.add(i, (String) cell);
                    i++;
                }else{
                    cells.add(j, (String) cell);
                    j++;
                }
            }
            k++;
        }
    }

    private void pasarFilasDeStringAArray(String[] filasAux){
        for (int i = 0; i < filasAux.length;i++)
            rows.add(i, filasAux[i]);
    }

    //retorna el numero de filas que hay en el archivo.
    private int numeroDeFilas() throws IOException{
        CSVReader csvReader = new CSVReader(new FileReader(PATH));
        Object[] auxRecorrer;
        int numFilas = 0;

        while((auxRecorrer = csvReader.readNext()) != null)
            numFilas++;

        return numFilas;
    }

    public ArrayList<String> getRows() {
        return rows;
    }

    public String getPATH() {
        return PATH;
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public ArrayList<String> getCells(){return cells;}






}

