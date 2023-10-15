package seminars.six;

import java.util.List;

public class ComparatorListAverage {
    private final ListAverage listAverage;
    public ComparatorListAverage(ListAverage listAverage) {
        this.listAverage = listAverage;
    }

    public String compareListAverage(List<Integer> listA, List<Integer> listB) {
        double listAAverage = listAverage.countListAverage(listA);
        double listBAverage = listAverage.countListAverage(listB);
        if (listAAverage > listBAverage) {
            return "Первый список имеет большее среднее значение";
        } else if (listAAverage < listBAverage) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
