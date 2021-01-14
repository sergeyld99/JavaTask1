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


    //Парсинг параметров
    private void parseParam(String value) throws CarException{
        String buffer = "";//Буффер для строк
        if(value ==null  || value.isEmpty())
            throw new CarException("Параметр не должен быть пустой");
        if (!value.substring(0,1).equals("C"))
            throw new CarException("Параметр должен начинаться с C");
        //Вычислим код транспортного средства
        int pos_first = value.indexOf("_");
        int pos_second = value.indexOf("-");
        if (pos_first>0)
            try {
                buffer = value.substring(1, pos_first);
                code = Integer.parseInt(buffer);
            }
        catch(NumberFormatException ne){
            throw new CarException("Код транспортного средства " + buffer + " должен быть числовым");
        }
        else
            throw new CarException("Неверный формат параметра. Нет кода транспортного средства");

        //Вычислим гос-номер
        if (pos_second>pos_first)
            govNumber = value.substring(pos_first + 1, pos_second);
        else
            throw new CarException("Неверный формат параметра. Нет госномера");

        //Пробег и гос.параиетр
        int pos_last = value.indexOf("-",pos_second + 1);
        if (pos_last>pos_second) {
            buffer = value.substring(pos_second + 1, pos_last);
            addParameter = value.substring(pos_last + 1);
        }
        else{
            buffer = value.substring(pos_second + 1);
            addParameter = "";
        }
        try {
            mileage = Integer.parseInt(buffer);
        }
        catch(NumberFormatException ne){
            throw new CarException("Пробег " + buffer + " должен быть числовым");
        }
    }

    //Конструктор. Входной параметр формата: C(CODE_CAR)_гос номер-Пробег-(доп. параметр)
    public Car(String value) throws CarException{
        parseParam(value);
    }
}
