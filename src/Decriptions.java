//Класс списка расшифровок
import java.util.Map;
import java.util.HashMap;

public class Decriptions {
    private Map<Integer, Decript> descriptions = new HashMap<Integer, Decript>();

    public Decriptions() {
        //Не знаю как правильно, пожтому заполняю константами
        descriptions.put(100, new Decript("легковой авто", 46.10, 12.5));
        descriptions.put(200, new Decript("грузовой авто - объем перевезенного груза см. куб.", 48.90, 12.0));
        descriptions.put(300, new Decript("пассажирский транспорт - число перевезенных пассажиров", 47.50, 11.5));
        descriptions.put(400, new Decript("тяжелая техника(краны) - вес поднятых грузов тонн", 48.90, 20.0));
    }

    public Decript getDescript(Integer key){
        return descriptions.get(key);
    }

    public String getName(Integer key){
        Decript d = descriptions.get(key);
        if (d == null)
            return "";
        else
            return d.getName();
    }
    public double getConsumptionFuel(Integer key){
        Decript d = descriptions.get(key);
        if (d == null)
            return 0;
        else
            return d.getConsumptionFuel();
    }

    public double getPriceFuel(Integer key){
        Decript d = descriptions.get(key);
        if (d == null)
            return 0;
        else
            return d.getPriceFuel();
    }
}
