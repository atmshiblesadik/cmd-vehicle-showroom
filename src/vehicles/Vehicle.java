package vehicles;

public class Vehicle {
    private int modelNumber;
    private int engineType;
    private String[] engineName = new String[]{"Oil", "Gas", "Diesel"};
    private int enginePower;
    private double tireSize;

    public Vehicle(int modelNumber, int engineType, int enginePower, double tireSize) {
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
    }

    public void showFullDetails() {
        System.out.println("Model Number: " + this.getModelNumber() +
                ", Engine Type: " + this.getEngineType() +
                ", Engine Power: " + this.getEnginePower() + " HP" +
                ", Tire Size: " + this.getTireSize() + "Inch"
        );
    }

    public int getModelNumber() {
        return this.modelNumber;
    }

    public String getEngineType() {
        return this.engineName[this.engineType - 1];
    }

    public int getEnginePower() {
        return this.enginePower;
    }

    public double getTireSize() {
        return this.tireSize;
    }
}