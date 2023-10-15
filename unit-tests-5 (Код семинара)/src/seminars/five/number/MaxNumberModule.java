package seminars.five.number;

import java.util.List;

public class MaxNumberModule {
    public int findMaxNumber(List<Integer> numbers) {
        if (numbers.isEmpty()) throw new IllegalArgumentException("Collection shouldn't be empty");
        int maxNumber = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > maxNumber) {
                maxNumber = numbers.get(i);
            }
        }
        return maxNumber;
    }
}
