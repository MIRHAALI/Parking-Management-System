package parkingmanagementsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ParkingManagementSystem {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        LinkedListParking parkingPlaza = new LinkedListParking();

        // fetch data from file
        File f = new File("parkedcars.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        Object[] lines = br.lines().toArray();

        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].toString().split(",");

            if (line.length != 1) {
                parkingPlaza.addCarToEmptyParking(parkingPlaza.addNode(line[0]), new car(line[1], line[2], line[3], Integer.parseInt(line[4])));
            } else {
                parkingPlaza.addNode(line[0]);
            }
        }
        /* PrintWriter pw = new PrintWriter(new FileOutputStream(f, false));
        for (int i = 0; i < parkingPlaza.MAX_SPACES; i++) {
            String address = "A";
            address = address + i;
            parkingPlaza.addNode(address);
            pw.append(address + "," + "\n");
        }*/

 /*for (int i = 0; i < parkingPlaza.MAX_SPACES; i++) {
            String address = "A";
            address = address + i;
            parkingNodes current = parkingPlaza.head;
            if (current.parkingAdd == null) {
                parkingPlaza.addNode(address);
                current = current.next;
            }
        }*/
        //System.out.println("" + parkingPlaza.available_Slots());
        new Login(parkingPlaza).setVisible(true);
    }
}
