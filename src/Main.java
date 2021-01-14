import java.sql.Array;

public class Main {
    //Входной массив
    private static String ArrCars[] = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
    private static MainThread mth;
    public static void main(String[] args){
        mth = new MainThread(ArrCars);
        System.out.println("Несортированный список: ");
        mth.outList();

        System.out.println("Сортированный список по пробегу: ");
        mth.sortByMileage();
        mth.outSortList();

        System.out.println("Сортированный список по доп. параметру: ");
        mth.sortByAddParameter();
        mth.outSortList();

    }

}
