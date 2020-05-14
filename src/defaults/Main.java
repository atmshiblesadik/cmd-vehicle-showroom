package defaults;

import showrooms.Showroom;

import java.util.Scanner;

public class Main {
    private Scanner cin;
    private Showroom showroom;

    public Main() {
        this.cin = new Scanner(System.in);
        this.showroom = new Showroom();
    }

    private void addingVehicle() {
        System.out.println("Type 1 for normal vehicle, " +
                "2 for sports vehicle, " +
                "3 for heavy vehicle " +
                "and 0 for exit");
        System.out.print("Enter your type: ");
        String inputType;
        inputType = this.cin.nextLine();
        if (inputType.equals("0")) {
            return;
        } else if (inputType.equals("1")) {
            int modelNumber = this.inputModelNumber();
            if (showroom.existNormalVehicle(modelNumber)) {
                System.out.println("*This model number already exist");
                modelNumber = this.inputModelNumber();
            }
            showroom.addNormalVehicle(modelNumber, this.inputEngineType(), this.inputEnginePower(), this.inputTireSize());
        } else if (inputType.equals("2")) {
            int modelNumber = this.inputModelNumber();
            if (showroom.existSportsVehicle(modelNumber)) {
                System.out.println("*This model number already exist");
                modelNumber = this.inputModelNumber();
            }
            showroom.addSportsVehicle(modelNumber, this.inputEnginePower(), this.inputTireSize(), this.inputTurbo());
        } else if (inputType.equals("3")) {
            int modelNumber = this.inputModelNumber();
            if (showroom.existHeavyVehicle(modelNumber)) {
                System.out.println("*This model number already exist");

                modelNumber = this.inputModelNumber();
            }
            showroom.addHeavyVehicle(modelNumber, this.inputEnginePower(), this.inputTireSize(), this.inputWeight());
        } else {
            System.out.println("Invalid input");
            this.addingVehicle();
        }
    }

    private void removeVehicle() {
        System.out.println("Type 1 for normal vehicle, " +
                "2 for sports vehicle, " +
                "3 for heavy vehicle " +
                "and 0 for exit");
        System.out.print("Enter your type: ");
        String inputType;
        inputType = this.cin.nextLine();
        if (inputType.equals("0")) {
            return;
        } else if (inputType.equals("1")) {
            showroom.removeNormalVehicle(this.inputModelNumber());
        } else if (inputType.equals("2")) {
            showroom.removeSportsVehicle(this.inputModelNumber());
        } else if (inputType.equals("3")) {
            showroom.removeHeavyVehicle(this.inputModelNumber());
        } else {
            System.out.println("Invalid input");
            this.removeVehicle();
        }
    }

    private int inputModelNumber() {
        System.out.print("Enter model number: ");
        try {
            return Integer.parseInt(cin.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input only integer accepted");
            return this.inputModelNumber();
        }
    }

    private int inputEngineType() {
        System.out.println("Engine type 1 for Oil, " +
                "2 for Gas " +
                "and 3 for Diesel");
        System.out.print("Enter engine type: ");
        return Integer.parseInt(this.cin.nextLine());
    }

    private int inputEnginePower() {
        System.out.print("Enter engine power in HP: ");
        try {
            return Integer.parseInt(cin.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input only integer accepted");
            return this.inputEnginePower();
        }
    }

    private double inputTireSize() {
        System.out.print("Enter tire size in Inch: ");
        try {
            return Double.parseDouble(this.cin.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input only real number accepted");
            return this.inputTireSize();
        }
    }

    private int inputTurbo() {
        System.out.print("Enter turbo speed in HP: ");
        try {
            return Integer.parseInt(cin.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input only integer accepted");
            return this.inputTurbo();
        }
    }

    private double inputWeight() {
        System.out.print("Enter weight in KG: ");
        try {
            return Double.parseDouble(this.cin.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input only real number accepted");
            return this.inputWeight();
        }
    }

    public static void main(String[] args) {
        Main program = new Main();
        String inputType;
        while (true) {
            System.out.println("Type 1 for add vehicle, " +
                    "2 for remove vehicle, " +
                    "3 for show status, " +
                    "4 for show status with full details " +
                    "and 0 for exit program");
            System.out.print("Enter your type: ");
            inputType = program.cin.nextLine();
            switch (inputType) {
                case "0":
                    System.out.println("End of program, " +
                            "Have a nice day");
                    System.exit(0);
                case "1":
                    program.addingVehicle();
                    break;
                case "2":
                    program.removeVehicle();
                    break;
                case "3":
                    program.showroom.currentStatus();
                    break;
                case "4":
                    program.showroom.currentStatusWithFullDetails();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("---------------------------------------------");
        }
    }
}
