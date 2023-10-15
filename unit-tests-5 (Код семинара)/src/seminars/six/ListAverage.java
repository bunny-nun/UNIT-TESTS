package seminars.six;

import java.util.List;

public class ListAverage {
    public double countListAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) throw new IllegalArgumentException("The list can not be empty");
        else return (double) numbers.stream().mapToInt(Integer::intValue).sum() / numbers.size();
    }
}
