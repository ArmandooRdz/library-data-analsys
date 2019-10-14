package com.armandordz.estructura;

import java.util.ArrayList;

public class Fila implements Row{
    private ArrayList<Cell> celdas = new ArrayList<>();
    private int numeroColumnas = 0;


    public Fila() { };

    public Fila(ArrayList<Cell> newCells){
        if(newCells.size() <= 0){
            System.out.println("ERROR: No puede asignar ArrayList<Cell> vacío a una Fila.");
            return;
        }
        this.celdas = newCells;
        this.numeroColumnas = newCells.size();
    }



    //TODO: ¿Como saber el tipo de dato de cada columna? para validar que cada fila agregada
    // tenga los tipos de datos correctos.
    private void definirTiposDeDatosColumnas(){

    }


    public ArrayList<Cell> getCeldas() {
        return celdas;
    }



    public int getNumeroColumnas() {
        return numeroColumnas;
    }


    @Override
    public void setArrayCells(ArrayList<Cell> f) {
        numeroColumnas = f.size();
        this.celdas = f;
    }

    @Override
    public void changeContentCell(int indexCell) {

    }

    @Override
    public Cell getCell(int indexCell) {
        return celdas.get(indexCell);
    }

    @Override
    public int getCellsNumber() {
        return celdas.size();
    }


}
