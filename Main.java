import java.util.ArrayList;
import java.util.List;

// Интерфейс VendingMachine
interface VendingMachine {
    HotBeverage getProduct(String name, int volume, int temperature);
}

// Класс HotBeverage
class HotBeverage {
    private String name;
    private int volume;
    private int temperature;

    public HotBeverage(String name, int volume, int temperature) {
        this.name = name;
        this.volume = volume;
        this.temperature = temperature;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "HotBeverage{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", temperature=" + temperature +
                '}';
    }
}

// Класс HotBeverageVendingMachine
class HotBeverageVendingMachine implements VendingMachine {
    private List<HotBeverage> beverages;

    public HotBeverageVendingMachine() {
        this.beverages = new ArrayList<>();
    }

    public void addBeverage(HotBeverage beverage) {
        beverages.add(beverage);
    }

    @Override
    public HotBeverage getProduct(String name, int volume, int temperature) {
        for (HotBeverage beverage : beverages) {
            if (beverage.getName().equals(name) && beverage.getVolume() == volume && beverage.getTemperature() == temperature) {
                return beverage;
            }
        }
        return null;
    }
}

// Класс Main
public class Main {
    public static void main(String[] args) {
        HotBeverage coffee = new HotBeverage("Coffee", 200, 80);
        HotBeverage tea = new HotBeverage("Tea", 150, 75);

        HotBeverageVendingMachine vendingMachine = new HotBeverageVendingMachine();
        vendingMachine.addBeverage(coffee);
        vendingMachine.addBeverage(tea);

        HotBeverage product = vendingMachine.getProduct("Coffee", 200, 80);
        if (product != null) {
            System.out.println("Retrieved: " + product);
        } else {
            System.out.println("Beverage not found");
        }
    }
}
