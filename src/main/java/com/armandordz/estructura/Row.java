package com.armandordz.estructura;

import java.util.ArrayList;

public interface Row {

    void setArrayCells(ArrayList<Cell> f); // Reemplaza el array de celdas

    void changeContentCell(int indexCell);

    Cell getCell(int indexCell);

    int getCellsNumber();

}
