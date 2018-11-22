// package declaration

package capgemini.academy.bootcamp;

public class Vehicle {
    private String[] vehicleNames = {"Speedster", "Fastboii", "Charge", "Z200", "RYNO"};
    private String vehicleName = "UNKNOWN";
    private String vehicleOwner = "Juul";
    private String[] vehicleBrands = {"Volvo", "Volkswagen", "FastCar", "Renault", "Snail"};
    private String vehicleBrand = "UNKOWN";
    private boolean lightsOn = false;
    private float lightIntensity = 0;
    private float maxLightIntensity = 100;
    private boolean doorOpen = false;
    private int doorAngle = 0;
    private float fuel = 0;
    private float maxFuel = 60;

    //Inheritance
    private int numberOfWheels = 4;
    private String vehicleType = "unkown type";

    String newLine = System.getProperty("line.separator");


    //Car constructor
    public Vehicle() {
        System.out.println("A new vehicle is created!" + newLine + newLine);
        StandardVehicleSettings();
        PrintVehicle();
    }

    public Vehicle(String name, String brand, String owner) {
        System.out.println("Hello new vehicle!");
        StandardVehicleSettings();
        vehicleName = name;
        vehicleBrand = brand;
        vehicleOwner = owner;
        PrintVehicle();
    }

    public Vehicle(int wheels,String type) {
        System.out.println("Hello new vehicle!");
        StandardVehicleSettings();
        numberOfWheels = wheels;
        vehicleType = type;
        PrintVehicle();
    }

    private void StandardVehicleSettings() {
        //int randomNum = ThreadLocalRandom.current().nextInt(0, carNames.length - 1);
        vehicleName = vehicleNames[RandomRangeInt(0, vehicleNames.length - 1)];
        vehicleOwner = "Juul";
        vehicleBrand = vehicleBrands[RandomRangeInt(0, vehicleNames.length - 1)];
        lightsOn = false;
        maxLightIntensity = 100;
        lightIntensity = RandomRangeFloat(0, maxLightIntensity);

        doorOpen = false;
        doorAngle = 0;
        maxFuel = 60;
        //randomFloatNum = //ThreadLocalRandom.current().nextFloat(0.0f, maxFuel);
        fuel = RandomRangeFloat(0, maxFuel);

        numberOfWheels = 4;

    }

    public void PrintVehicle() {
        //Name
        System.out.println("This car is called: " + vehicleName);
        //Search!
        if (SearchString(vehicleNames, vehicleName)) {
            System.out.println("The name of the car is known to the system!");
        } else {
            System.out.println("This car name is unique, and unknown to the system!");
        }

        System.out.println("Other possible names in reverse order: ");
        for (int i = vehicleNames.length - 1; i >= 0; i--) {
            System.out.println("At array position: " + Integer.toString(i));
            System.out.println(vehicleNames[i]);
        }
        System.out.println(vehicleOwner + " owns this car." + newLine);

        //Brand
        System.out.println("Total brands: " + Integer.toString(vehicleBrands.length));
        System.out.println("This brand: " + vehicleBrand);
        System.out.println("Which brands there are: ");

        switch (vehicleBrand) {
            case "Volvo":
                System.out.println("The vehicle brand is volvo which is not made up");
                break;
            case "Volkswagen":
                System.out.println("This vehicle brand is Volkswagen and came to be after some war");
                break;
            case "FastCar":
                System.out.println("The brand is FastCar which is ridiculous and made up");
                break;
            case "Renault":
                System.out.println("The vehicle brand is renault which is a real one");
                break;
            case "Snail":
                System.out.println("This vehicle brand is Snail and it suggests this vehicle is slow");
                break;
            default:
                System.out.println("I don't know this vehicle brand");
                break;
        }


        for (String brand : vehicleBrands) {
            System.out.println(brand);
        }

        System.out.println(newLine);

        //Lights
        if (lightsOn == true) {
            System.out.println("The light will be ON!");
        } else {
            System.out.println("The light will be OFF!");
        }
        System.out.println("Door angle: " + Float.toString(lightIntensity) + newLine);
        //Door
        if (doorOpen == true) {
            System.out.println("The door is OPEN!");
        } else {
            System.out.println("The door is CLOSED!");
        }
        System.out.println("Door angle: " + Float.toString(doorAngle) + newLine);

        //Fuel
        if (fuel > maxFuel) {
            System.out.println("THE TANK IS OVERFLOWING!");
        } else if (fuel <= 0) {
            System.out.println("The tank is empty ): .");
        }
        System.out.println("Fuel in the tank: " + Float.toString(fuel));
        System.out.println("Maximum amount of fuel: " + Float.toString(maxFuel) + newLine);

        //Print inheritance changes
        System.out.println("----INHERITANCE!----");
        System.out.println("Amount of wheels: "+Integer.toString(numberOfWheels));
        System.out.println("Vehicle type: "+vehicleType);

        System.out.println(newLine + newLine);
    }

    private static float RandomRangeFloat(float min, float max) {
        return capgemini.academy.bootcamp.RandomFunctions.RandomRangeFloat(min,max);
    }
    private static int RandomRangeInt(int min, int max) {
        return capgemini.academy.bootcamp.RandomFunctions.RandomRangeInt(min,max);
    }

    public boolean SearchString(String[] stringArray, String searchString) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(searchString))
                return true;
        }
        return false;
    }
}
