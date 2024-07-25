/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingmanagementsystem;

public class car {

    String numPlate;
    String color;
    String type;
    int entryTime;

    public car(String numPlate, String color, String type, int entryTime) {
        this.numPlate = numPlate;
        this.color = color;
        this.type = type;
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return this.numPlate;
    }
    //for gui
    public String toString1() {
        return this.numPlate+" "+this.color+" "+this.type+" "+this.entryTime;
    }
}
