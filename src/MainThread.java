//Основной поток
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class MainThread {
    private Decriptions descripts = new Decriptions();
    private List<Car> listCars = new ArrayList<Car>();
    public MainThread(String arrCars[]){
        //Хотел foreach использовать, но не понял как
        for (int i = 0;i < arrCars.length; i++) {
            try{
                listCars.add(new Car(new CarParams(arrCars[i])));
            }
            catch (CarException e){
                System.out.println("CarException = " + e.getMessage());
            }

        }
        System.out.println("Всего добавлено " + listCars.size() + " элементов");
    }

    //Вывод списка автомобилей
    public void outList(){
        double totalFuelAmount = 0;
        for(int i=0; i< listCars.size();i++){
            System.out.println(String.format("%d Код-%d, Тип- %s, Гос-номер-%s, Пробег-%d, Доп.параметр-%s"
                    , i+1
                    , listCars.get(i).getCode()
                    , descripts.getName(listCars.get(i).getCode())
                    , listCars.get(i).getGovNumber()
                    , listCars.get(i).getMileage()
                    , listCars.get(i).getAddParameter()
                    )
            );
            totalFuelAmount += descripts.getPriceFuel(listCars.get(i).getCode()) * descripts.getConsumptionFuel(listCars.get(i).getCode()) * listCars.get(i).getMileage()/100. ;
        }
        System.out.println(String.format("Общая стоимость расходов на ГСМ: %f", totalFuelAmount));
    }
    //Вывод отсортированного списка автомобилей (git)
    public void outSortList(){
        //Общая стоимость расхода ГСМ
        double totalFuelAmount = 0;
        //Стоимость расход ГСМ по типу автомобиля
        double typeTotalFuelAmount = 0;
        //Код типа автомобилей с максимальной стоимостью расходом ГСМ
        int codeMaxTotalFuelAmount = 0;
        double maxTotalFuelAmount = 0;
        //Код типа автомобилей с минимальной стоимостью расходом ГСМ
        int codeMinTotalFuelAmount = 0;
        double minTotalFuelAmount = 0;
        //Сортировка по коду
        int code_etalon = 0;
        for(int i=0; i< listCars.size();i++){
            if (i==0 || code_etalon!=listCars.get(i).getCode()) {
                //Вывод общего расхода по типу
                if (i > 0){
                    System.out.println(String.format("Общая стоимость расходов на ГСМ по типу: %f", typeTotalFuelAmount));
                    if (typeTotalFuelAmount > maxTotalFuelAmount) {
                        maxTotalFuelAmount = typeTotalFuelAmount;
                        codeMaxTotalFuelAmount = code_etalon;
                    }
                    if (typeTotalFuelAmount < minTotalFuelAmount || codeMinTotalFuelAmount==0) {
                        minTotalFuelAmount = typeTotalFuelAmount;
                        codeMinTotalFuelAmount = code_etalon;
                    }
                }
                System.out.println(String.format("Код-%d, Тип- %s"
                        , listCars.get(i).getCode()
                        , descripts.getName(listCars.get(i).getCode())
                        )
                );
                code_etalon = listCars.get(i).getCode();
                typeTotalFuelAmount = 0;
            }

            System.out.println(String.format("%d Гос-номер-%s, Пробег-%d, Доп.параметр-%s"
                    , i+1
                    , listCars.get(i).getGovNumber()
                    , listCars.get(i).getMileage()
                    , listCars.get(i).getAddParameter()
                    )
            );
            typeTotalFuelAmount += descripts.getPriceFuel(listCars.get(i).getCode()) * descripts.getConsumptionFuel(listCars.get(i).getCode()) * listCars.get(i).getMileage()/100. ;
            totalFuelAmount += descripts.getPriceFuel(listCars.get(i).getCode()) * descripts.getConsumptionFuel(listCars.get(i).getCode()) * listCars.get(i).getMileage()/100. ;
        }
        //Вывод общего расхода по типу
        if (code_etalon>0){
            System.out.println(String.format("Общая стоимость расходов на ГСМ по типу: %f", typeTotalFuelAmount));
            if (typeTotalFuelAmount > maxTotalFuelAmount) {
                maxTotalFuelAmount = typeTotalFuelAmount;
                codeMaxTotalFuelAmount = code_etalon;
            }
            if (typeTotalFuelAmount < minTotalFuelAmount || codeMinTotalFuelAmount==0) {
                minTotalFuelAmount = typeTotalFuelAmount;
                codeMinTotalFuelAmount = code_etalon;
            }

        }
        if (codeMaxTotalFuelAmount>0)
            System.out.println(String.format("Минимальная стоимость расходов на ГСМ у типа %d.%s - %f", codeMaxTotalFuelAmount, descripts.getName(codeMaxTotalFuelAmount), minTotalFuelAmount));
        if (codeMinTotalFuelAmount>0)
            System.out.println(String.format("Максимальная стоимость расходов на ГСМ у типа %d.%s - %f", codeMinTotalFuelAmount, descripts.getName(codeMinTotalFuelAmount), maxTotalFuelAmount));
        System.out.println(String.format("Общая стоимость расходов на ГСМ: %f", totalFuelAmount));
    }

    //Сортировка списка по пробегу в разрезе типа авто
    public void sortByMileage(){
        Collections.sort(listCars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                //Сначала по типу авто разсортируем
                if (o1.getCode() < o2.getCode())
                    return -1;
                if (o1.getCode() > o2.getCode())
                    return 1;
                //потом по пробегу
                if (o1.getMileage() < o2.getMileage())
                    return -1;
                else
                    return 1;
            }
        }
        );
    }

    //Сортировка списка по доп.параметру
    public void sortByAddParameter(){

        Collections.sort(listCars, new Comparator<Car>() {
                    @Override
                    public int compare(Car o1, Car o2) {
                        //Сначала по типу авто разсортируем
                        if (o1.getCode() < o2.getCode())
                            return -1;
                        if (o1.getCode() > o2.getCode())
                            return 1;
                        return (o1.getAddParameter().compareTo(o2.getAddParameter()));
                    }
                }
        );
    }

}
