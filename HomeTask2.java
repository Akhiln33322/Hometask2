import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Car {
	private int id;
	private String make;
	private String model;
	private int manufactureYear;
	private String color;
	private double price;
	private String registrationNumber;

    public Car(int id, String make, String model, int manufactureYear, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

public class HomeTask2 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "SUV", 1998, "Blue", 20000, "KA07W3140"));
        cars.add(new Car(2, "Benz", "HatchBack", 2020, "Red", 82000, "KA07W3141"));
        cars.add(new Car(3, "Ford", "SUV", 2016, "blue", 80000, "KA07W3142"));
        cars.add(new Car(4, "BMW", "Sedan", 1990, "white", 50000, "KA07W3143"));
        cars.add(new Car(5, "Benz", "SUV", 2005, "white", 60000, "KA07W3144"));
        cars.add(new Car(6, "Ford", "HatchBack", 2017, "red", 75000, "KA07W3145"));
        cars.add(new Car(7, "Toyota", "Sedan", 1992, "red", 15000, "KA07W3146"));
        cars.add(new Car(8, "TATA", "Sedan", 2010, "white", 20000, "KA07W3147"));
        cars.add(new Car(9, "Mahindra", "Sedan", 2000, "white", 20000, "KA07W3148"));
        cars.add(new Car(10, "Toyato", "SUV", 2010, "white", 30000, "KA07W3149"));
        cars.add(new Car(11, "BMW", "HatchBack", 2010, "silver", 60000, "KA07W3150"));
        cars.add(new Car(12, "Audi", "Sedan", 2015, "red", 55000, "KA07W3151"));
        cars.add(new Car(13, "TATA", "Sedan", 2017, "blue", 20000, "KA07W3152"));
        cars.add(new Car(14, "Benz", "HatchBack", 2020, "black", 80000, "KA07W3153"));
        cars.add(new Car(15, "TATA", "Sedan", 2015, "red" ,30000, "KA07W3154"));

        // considered brand, model, year, and price criteria for segregating
        String givenBrand = "BMW";
        String givenModel = "SUV";
        int nYears = 3;
        int givenYear = 2015;
        double specifiedPrice = 25000;

        // filtering the cars based on the given condition
        List<Car> carsOfGivenBrand = brand(cars, givenBrand);
        List<Car> carsOfGivenModelAndAge = modelAndAge(cars, givenModel, nYears);
        List<Car> carsOfGivenYearAndPrice = yearAndPrice(cars, givenYear, specifiedPrice);

        // lists is saved to the text files
        saveFile("C:\\Users\\dell\\Desktop\\Akhil\\Java\\brand_filtered_cars.txt", carsOfGivenBrand);
        saveFile("C:\\Users\\dell\\Desktop\\Akhil\\Java\\model_and_age_filtered_cars.txt", carsOfGivenModelAndAge);
        saveFile("C:\\Users\\dell\\Desktop\\Akhil\\Java\\year_and_price_filtered_cars.txt", carsOfGivenYearAndPrice);
    }

    public static List<Car> brand(List<Car> cars, String brand) {
        List<Car> brandFilter = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake() == brand) {
            	brandFilter.add(car);
            }
        }
        return brandFilter;
    }

    public static List<Car> modelAndAge(List<Car> cars, String givenModel, int nYears) {
        List<Car> modelAndAgeFilter = new ArrayList<>();
        int currentYear = 2023; 
        for (Car car : cars) {
            if (car.getModel() == givenModel && (currentYear - car.getManufactureYear()) > nYears) {
            	modelAndAgeFilter.add(car);
            }
        }
        return modelAndAgeFilter;
    }

    public static List<Car> yearAndPrice(List<Car> cars, int givenYear, double specifiedPrice) {
        List<Car> yearAndPriceFilter = new ArrayList<>();
        for (Car car : cars) {
            if (car.getManufactureYear() == givenYear && car.getPrice() > specifiedPrice) {
            	yearAndPriceFilter.add(car);
            }
        }
        return yearAndPriceFilter;
    }

    public static void saveFile(String filePath, List<Car> cars) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Car car : cars) {
                writer.println("Id: " + car.getId() + ", Make: " + car.getMake() + ", Model: " + car.getModel() + ", Year: " + car.getManufactureYear() + ", Color: " + car.getColor() + ", Price: " + car.getPrice() + ", Reg. Number: " + car.getRegistrationNumber());
            }
        } catch (Exception e) {
        	System.out.println("Error occured while saving to the file");;
        }
    }
}
