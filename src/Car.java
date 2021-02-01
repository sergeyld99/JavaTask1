public class Car {
    //Код авто
    private int code;
    //Государственный номер
    private String govNumber;
    //Пробег
    private int mileage;
    //Дополнительный параметр
    private String addParameter;

    public int getCode() {
        return code;
    }
    public String getGovNumber() {
        return govNumber;
    }
    public int getMileage() {
        return mileage;
    }
    public String getAddParameter() {
        return addParameter;
    }



    //Конструктор. Входной параметр класс CarParams
    public Car(CarParams value) throws CarException{
        //Код авто
        code = value.getCode();
        //Государственный номер
        govNumber = value.getGovNumber();
        //Пробег
        mileage = value.getMileage();
        //Дополнительный параметр
        addParameter = value.getAddParameter();
    }
}
