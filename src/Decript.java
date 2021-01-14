//Класс расшифровки
public class Decript {
    //Наименование расшифровки
    String name;
    //Стоимость литра топлива
    double priceFuel;
    //Расход топлива
    double consumptionFuel;

    public String getName() {
        return name;
    }
    public double getPriceFuel() {
        return priceFuel;
    }
    public double getConsumptionFuel() {
        return consumptionFuel;
    }

    public Decript(String name, double priceFuel, double consumptionFuel) {
        this.name = name;
        this.priceFuel = priceFuel;
        this.consumptionFuel = consumptionFuel;
    }
}
