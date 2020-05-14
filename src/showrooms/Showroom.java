package showrooms;

import vehicles.*;

import java.util.ArrayList;

public class Showroom {
    private int currentVisitors;
    private final int sportsVehicleVisitors;
    private ArrayList<Vehicle> listOfNormalVehicle;
    private ArrayList<SportsVehicle> listOfSportsVehicle;
    private ArrayList<HeavyVehicle> listOfHeavyVehicle;

    public Showroom() {
        this.listOfNormalVehicle = new ArrayList<Vehicle>();
        this.listOfSportsVehicle = new ArrayList<SportsVehicle>();
        this.listOfHeavyVehicle = new ArrayList<HeavyVehicle>();
        this.currentVisitors = 0;
        this.sportsVehicleVisitors = 20;
    }

    // Showroom
    public void currentStatus() {
        System.out.println("Current expected visitors: " + this.currentVisitors);
        System.out.println("Normal vehicle: " + this.listOfNormalVehicle.size());
        if (this.listOfNormalVehicle.size() > 0) {
            System.out.print("    Model number: ");
            for (Vehicle vehicle: this.listOfNormalVehicle) {
                System.out.print(" " + vehicle.getModelNumber());
            }
            System.out.println();
        }
        System.out.println("Sports vehicle: " + this.listOfSportsVehicle.size());
        if (this.listOfSportsVehicle.size() > 0) {
            System.out.print("    Model number: ");
            for (Vehicle vehicle: this.listOfSportsVehicle) {
                System.out.print(" " + vehicle.getModelNumber());
            }
            System.out.println();
        }
        System.out.println("Heavy vehicle: " + this.listOfHeavyVehicle.size());
        if (this.listOfHeavyVehicle.size() > 0) {
            System.out.print("    Model number: ");
            for (Vehicle vehicle: this.listOfHeavyVehicle) {
                System.out.print(" " + vehicle.getModelNumber());
            }
            System.out.println();
        }
    }

    public void currentStatusWithFullDetails() {
        System.out.println("Current expected visitors: " + this.currentVisitors);
        System.out.println("Normal vehicle: " + this.listOfNormalVehicle.size());
        if (this.listOfNormalVehicle.size() > 0) {
            for (Vehicle vehicle: this.listOfNormalVehicle) {
                vehicle.showFullDetails();
            }
        }
        System.out.println("Sports vehicle: " + this.listOfSportsVehicle.size());
        if (this.listOfSportsVehicle.size() > 0) {
            for (Vehicle vehicle: this.listOfSportsVehicle) {
                vehicle.showFullDetails();
            }
        }
        System.out.println("Heavy vehicle: " + this.listOfHeavyVehicle.size());
        if (this.listOfHeavyVehicle.size() > 0) {
            for (Vehicle vehicle: this.listOfHeavyVehicle) {
                vehicle.showFullDetails();
            }
        }
    }

    private int getCurrentVisitors() {
        return this.currentVisitors;
    }

    private void increaseVisitors(int visitors) {
        this.currentVisitors += visitors;
    }

    private void decreaseVisitors(int visitor) {
        this.currentVisitors -= visitor;
    }

    // Normal Vehicle
    public void addNormalVehicle(int modelNumber, int engineType, int enginePower, double tireSize) {
        Vehicle normalVehicle = new Vehicle(modelNumber, engineType, enginePower, tireSize);
        this.listOfNormalVehicle.add(normalVehicle);
        System.out.println("Vehicle added in showroom ");
        normalVehicle.showFullDetails();
        if (this.currentVisitors == 0) {
            this.increaseVisitors(30);
        }
    }

    public boolean existNormalVehicle(int modelNumber) {
        for (Vehicle vehicle: this.listOfNormalVehicle) {
            if (modelNumber == vehicle.getModelNumber()) {
                return true;
            }
        }
        return false;
    }

    public void removeNormalVehicle(int modelNumber) {
        Vehicle objVehicle = null;
        for (Vehicle vehicle: this.listOfNormalVehicle) {
            if (modelNumber == vehicle.getModelNumber()) {
                objVehicle = vehicle;
                break;
            }
        }
        if (objVehicle == null) {
            System.out.println("**Model number not found");
        } else {
            this.listOfNormalVehicle.remove(objVehicle);
            if (this.listOfHeavyVehicle.size() == 0
                    && this.listOfSportsVehicle.size() == 0
                    && this.listOfNormalVehicle.size() == 0
            ) {
                this.decreaseVisitors(30);
            }
            System.out.println("Vehicle deleted");
        }
    }

    // Sports Vehicle
    public void addSportsVehicle(int modelNumber, int enginePower, double tireSize, int turbo) {
        SportsVehicle sportsVehicle = new SportsVehicle(modelNumber, enginePower, tireSize, turbo);
        this.listOfSportsVehicle.add(sportsVehicle);
        if (this.currentVisitors == 0) {
            this.increaseVisitors(30);
        }
        this.increaseVisitors(this.sportsVehicleVisitors);
        System.out.println("Vehicle added in showroom");
    }

    public boolean existSportsVehicle(int modelNumber) {
        for (SportsVehicle vehicle: this.listOfSportsVehicle) {
            if (modelNumber == vehicle.getModelNumber()) {
                return true;
            }
        }
        return false;
    }

    public void removeSportsVehicle(int modelNumber) {
        SportsVehicle objVehicle = null;
        for (SportsVehicle vehicle: this.listOfSportsVehicle) {
            if (modelNumber == vehicle.getModelNumber()) {
                objVehicle = vehicle;
                break;
            }
        }
        if (objVehicle == null) {
            System.out.println("**Model number not found");
        } else {
            this.listOfSportsVehicle.remove(objVehicle);
            this.decreaseVisitors(this.sportsVehicleVisitors);
            if (this.listOfHeavyVehicle.size() == 0
                    && this.listOfSportsVehicle.size() == 0
                    && this.listOfNormalVehicle.size() == 0
            ) {
                this.decreaseVisitors(30);
            }
            System.out.println("Vehicle deleted");
        }
    }

    // Heavy Vehicle
    public void addHeavyVehicle(int modelNumber, int enginePower, double tireSize, double weight) {
        HeavyVehicle heavyVehicle = new HeavyVehicle(modelNumber, enginePower, tireSize, weight);
        this.listOfHeavyVehicle.add(heavyVehicle);
        if (this.currentVisitors == 0) {
            this.increaseVisitors(30);
        }
        System.out.println("Vehicle added in showroom");
    }

    public boolean existHeavyVehicle(int modelNumber) {
        for (HeavyVehicle vehicle: this.listOfHeavyVehicle) {
            if (modelNumber == vehicle.getModelNumber()) {
                return true;
            }
        }
        return false;
    }

    public void removeHeavyVehicle(int modelNumber) {
        Vehicle objVehicle = null;
        for (HeavyVehicle vehicle: this.listOfHeavyVehicle) {
            if (modelNumber == vehicle.getModelNumber()) {
                objVehicle = vehicle;
                break;
            }
        }
        if (objVehicle == null) {
            System.out.println("**Model number not found");
        } else {
            this.listOfHeavyVehicle.remove(objVehicle);
            if (this.listOfHeavyVehicle.size() == 0
                    && this.listOfSportsVehicle.size() == 0
                    && this.listOfNormalVehicle.size() == 0
            ) {
                this.decreaseVisitors(30);
            }
            System.out.println("Vehicle deleted");
        }
    }
}
