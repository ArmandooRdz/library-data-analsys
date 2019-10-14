
package com.armandordz.parseo;

import com.armandordz.estructura.*;
import com.armandordz.lectura.Archivo;
import java.io.IOException;
import java.util.ArrayList;


public class ParseoDeStrings {
    
    private int numeroDeColumnas;
    private int numeroDeCampos;
    private int numeroDeFilas;
    private ArrayList<Row> filas;
    private Archivo a1;
    private DataFrame dataFrame = new DataFrame();
    
    public ParseoDeStrings(Archivo a1) throws Exception{
        this.a1 = a1;
        obtenerDatosDelArchivo();
    }
    
    private void obtenerDatosDelArchivo() throws IOException{
        ArrayList<String> filas = a1.getRows();
        numeroDeColumnas = numeroDeColumnas(filas.get(0));    //Obtenemos el numero de columnas que existen en el archivo mandando como parametro cualquier fila (en este caso la primera)
        numeroDeFilas = numeroDeFilas(filas);
        parsear();
    }
    
    
    
    //Se realiza todo el parseo del archivo
    private void parsear() throws IOException{
 
        
        ArrayList<String> campos = a1.getCells();
        numeroDeCampos = campos.size();
        TiposDeDatos celdasDelArchivoAUX[] = new TiposDeDatos[numeroDeCampos];
        ArrayList<Object> camposDelArchivo = new ArrayList<Object>();
        Cell[] arregloCell = new Cell[numeroDeCampos];
        
        Row[] numFilas = new Fila[numeroDeFilas];
        filas = new ArrayList<>();

        
        for (int i=0;i<numeroDeCampos;i++){
            celdasDelArchivoAUX[i] = new TiposDeDatos(campos.get(i));
            camposDelArchivo.add(celdasDelArchivoAUX[i].getDato());
            if (celdasDelArchivoAUX[i].saberTipoDeDato() == "String"){
                arregloCell[i] = new StringClass(celdasDelArchivoAUX[i].getStrAux());
            }else if (celdasDelArchivoAUX[i].saberTipoDeDato() == "Integer"){
                arregloCell[i] = new IntClass(celdasDelArchivoAUX[i].getIntAux());
            }else if (celdasDelArchivoAUX[i].saberTipoDeDato() == "Float"){
                arregloCell[i] = new FloatClass(celdasDelArchivoAUX[i].getFloatAux());
            }else if (celdasDelArchivoAUX[i].saberTipoDeDato() == "Boolean"){
                arregloCell[i] = new BooleanClass(celdasDelArchivoAUX[i].getBoolAux());
            }
        }
        
        ArrayList<Cell> celdas = new ArrayList<>();        
        celdas = convertirCeldas(arregloCell);
        celdas = agregarCeldas(arregloCell);
        
        int auxCeldas = 0; 
        for (int i=0;i<numeroDeFilas;i++){
            ArrayList<Cell> celdasAUX = new ArrayList<Cell>(numeroDeColumnas);
            for (int j=auxCeldas;j<numeroDeColumnas + auxCeldas;j++){
                celdasAUX.add(celdas.get(j));
            }
            numFilas[i] = new Fila(celdasAUX);
            auxCeldas+=numeroDeColumnas;
        }
        
        for (int i=0;i<numeroDeFilas;i++){
            filas.add(numFilas[i]);
        }
        
        
       DataFrame tabla = new DataFrame();
       tabla.setRows(filas);
       
       this.dataFrame = tabla;
       
       
    }
    
    private ArrayList<Cell> agregarCeldas(Cell[] arregloCell){
        ArrayList<Cell> celdas = new ArrayList<>();  
        
          for (int i=0;i<numeroDeCampos;i++){
            celdas.add(arregloCell[i]);
        }
        return celdas;
    }
    
    private ArrayList<Cell> convertirCeldas(Cell[] arregloCell){
        
        ArrayList<Cell> celdas = new ArrayList<Cell>();
        
        for (int i=0;i<numeroDeCampos;i++){
            celdas.add(arregloCell[i]);
        }
        
        return celdas;
        
    }
      
    private int numeroDeColumnas(String primeraFila){
        int tam=0;
       
        for (int i=0;i<primeraFila.length();i++){
            if (primeraFila.charAt(i) == ',')
                tam++;
        }
        return tam;
    }
    
    private int numeroDeFilas(ArrayList<String> filas){
        int numFilas = 0;
        for (int i=0;i<filas.size()-1;i++)  //El -1 se pone para no poner la fila de la columna
            numFilas++;
        
        return numFilas;
    }

    public ArrayList<Row> getFilas() {
        return filas;
    }

    public DataFrame getDataFrame() {
        return dataFrame;
    }

    public void setDataFrame(DataFrame dataFrame) {
        this.dataFrame = dataFrame;
    }
}
