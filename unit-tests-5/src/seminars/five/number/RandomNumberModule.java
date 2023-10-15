package seminars.five.number;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberModule {

    public ArrayList<Integer> generateRandomNumbers(int length, int minRange, int maxRange) {
        if (length < 0 || minRange > maxRange) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        ArrayList<Integer> randomNumbers = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

    public static void main(String[] args) {
        int length = 10;
        int minRange = 1;
        int maxRange = 100;

        RandomNumberModule generator = new RandomNumberModule();
        ArrayList<Integer> randomNumbers = generator.generateRandomNumbers(length, minRange, maxRange);

        System.out.println("Generated random numbers: " + randomNumbers);
    }
}
