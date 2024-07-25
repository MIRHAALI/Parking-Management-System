package parkingmanagementsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LinkedListParking {

    public parkingNodes head = null;
    public parkingNodes tail = null;
    public final int MAX_SPACES = 50;
    public int SPACES_AVAILABLE=0;
    public int carCount = 0;

    public void filing(LinkedListParking parkingPlaza) throws FileNotFoundException {
        File f = new File("parkedcars.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        //String curLine = br.readLine();
        parkingNodes current = head;
        Object[] lines = br.lines().toArray();

        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].toString().split(",");
            if (line.length != 1) {
                parkingPlaza.addCarToEmptyParking(parkingPlaza.addNode(line[0]), new car(line[1], line[2], line[3], Integer.parseInt(line[4])));
            } else {
                parkingPlaza.addNode(line[0]);
            }
        }
    }

    public parkingNodes addNode(String parkingAddress) {
        parkingNodes newNode = new parkingNodes(parkingAddress);
        if (head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
        return newNode;
    }

    public car searchCar(String numPlate) {
        parkingNodes temp = head;
        boolean carFound = false;
        while (temp != null && carFound == false) {
            if (temp.parkedCar != null) {
                if (temp.parkedCar.numPlate.equals(numPlate)) {
                    carFound = true;
                    return temp.parkedCar;
                }
            }
            temp = temp.next;
        }
        return null;
    }
      public parkingNodes searchparking(String numPlate) {
        parkingNodes temp = head;
        boolean carFound = false;
        while (temp != null && carFound == false) {
            if (temp.parkedCar != null) {
                if (temp.parkedCar.numPlate.equals(numPlate)) {
                    carFound = true;
                    return temp;
                }
            }
            temp = temp.next;
        }
        return null;
    }

    public void addCar(car Car) {
        parkingNodes temp = head;
        boolean parkingFound = false;
        while (temp != null && parkingFound == false) {
            if (temp.parkedCar == null) {
                temp.parkedCar = Car;
                parkingFound = true;
                //System.out.println("Parking found at: " + temp.parkingAdd);
            }
            temp = temp.next;
        }
        if (parkingFound == false) {
            // System.out.println("No parking available");
        }
    }

    // this for the gui
    public parkingNodes findParking() {
        parkingNodes temp = head;
        boolean parkingFound = false;
        while (temp != null && parkingFound == false) {
            if (temp.parkedCar == null) {
                parkingFound = true;
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //this is for gui
    public void addCarToEmptyParking(parkingNodes parkingAdd, car Car) {
        carCount++;
        
        parkingAdd.parkedCar = Car;
    }

    public int available_Slots() {
        return MAX_SPACES - carCount;
    }

    public void display() {
        //Node current will point to head
        parkingNodes current = head;

        while (current != null) {

            if (current.parkedCar != null) {
                System.out.println("Car " + current.parkedCar.toString() + " is at " + current.parkingAdd);
            }
            current = current.next;
        }

        System.out.println();
    }

    public void removeCar(String numberPlate) {
        parkingNodes current = head;
        boolean carFound = false;
        while (current != null && carFound == false) {
            if (current.parkedCar != null) {
                if (current.parkedCar.numPlate.equals(numberPlate)) {
                    //System.out.println("Car " + current.parkedCar.toString() + " has left the " + current.parkingAdd);
                    current.parkedCar = null;
                    carFound = true;
                }
            }
            current = current.next;
        }

    }

    public static void main(String[] args) {
        LinkedListParking lp = new LinkedListParking();
        lp.addNode("a0");
        lp.addNode("a1");
        lp.addNode("a2");
        System.out.println(lp.available_Slots());
        lp.addCar(new car("bbu-977", "black", "suv", 1240));
        lp.addCar(new car("bbu-877", "red", "suv", 1240));
        lp.addCar(new car("bbu-887", "blue", "suv", 1240));
        lp.addCar(new car("bbu-888", "white", "suv", 1240));
        lp.display();
        lp.removeCar("bbu-977");
        lp.display();
        //System.out.println(lp.searchCar("bbu-888"));
        System.out.println(lp.available_Slots());
    }

}
