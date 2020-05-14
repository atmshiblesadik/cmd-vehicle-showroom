package vehicles;

public class SportsVehicle extends Vehicle {
    private int turbo;

    public SportsVehicle(int modelNumber, int enginePower, double tireSize, int turbo) {
        super(modelNumber, 1, enginePower, tireSize);
        this.turbo = turbo;
    }

    public int getTurbo() {
        return turbo;
    }

    @Override
    public void showFullDetails() {
        System.out.println("Model Number: " + this.getModelNumber() +
                ", Engine Type: " + this.getEngineType() +
                ", Engine Power: " + this.getEnginePower() + " HP" +
                ", Turbo Speed: " + this.getTurbo() + " HP" +
                ", Tire Size: " + this.getTireSize() + "Inch"
        );
    }
}
