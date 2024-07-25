package parkingmanagementsystem;

public class parkingNodes {

    String parkingAdd;
    parkingNodes next;
    car parkedCar;

    public parkingNodes(String parkingAdd) {
        this.parkingAdd = parkingAdd;
        parkedCar = null;
    }

    @Override
    public String toString() {
        if (this.parkedCar!=null) {  
        return this.parkingAdd + " " + this.parkedCar.toString1();
    }
        return this.parkingAdd;
    }

}
