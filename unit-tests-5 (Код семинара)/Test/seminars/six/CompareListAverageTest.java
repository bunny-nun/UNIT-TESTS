package seminars.six;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CompareListAverageTest {
    ListAverage listAverage;


    @BeforeEach
    void setUp() {
        listAverage = new ListAverage();
    }

    @ParameterizedTest
    @EmptySource
    void EmptyListAverageTest(List<Integer> emptyList) {
        // проверка, что запуск метода вычисления среднего значения пустого списка выбрасывает
        // ошибку IllegalArgumentException
        assertThrows(IllegalArgumentException.class, ()-> listAverage.countListAverage(emptyList));
    }

    @Test
    void ListAverageZeroesTest() {
        //проверка, что запуск метода вычисления среднего значения списка с нулевыми значениями возвращает 0
        List<Integer> list = Arrays.asList(0, 0, 0);

        double result = listAverage.countListAverage(list);

        assertEquals(0, result);
    }

    @Test
    void ListAverageEqualNumbersTest() {
        //проверка, что запуск метода вычислениями среднего значения списка с одинаковыми значениями возвращает это значение
        List<Integer> list = Arrays.asList(5, 5, 5);

        double result = listAverage.countListAverage(list);

        assertEquals(5, result);
    }

    @Test
    void ListAverageOneNumberTest() {
        //проверка метода вычислениями среднего значения списка с одним элементом
        int number = 5;
        List<Integer> list = List.of(number);

        double result = listAverage.countListAverage(list);

        assertEquals(number, result);
    }

    @Test
    void ListAveragePositiveNumbersTest() {
        //проверка метода вычислениями среднего значения списка с положительными элементами
        List<Integer> list = Arrays.asList(1, 7, 4, 6);

        double result = listAverage.countListAverage(list);

        assertEquals(4.5, result);
    }

    @Test
    void ListAverageNegativeNumbersTest() {
        //проверка метода вычислениями среднего значения списка с отрицательными элементами
        List<Integer> list = Arrays.asList(-3, -10, -17);

        double result = listAverage.countListAverage(list);

        assertEquals(-10, result);
    }

    @Test
    void ListAverageDifferentNumbersTest() {
        //проверка метода вычисления среднего значения списка с разными элементами
        List<Integer> list = Arrays.asList(-3, 6, 3);

        double result = listAverage.countListAverage(list);

        assertEquals(2, result);
    }

    @Test
    void compareAverageFirstListGreaterTest() {
        //проверка сравнения среднего значения списков, где значение первого списка больше
        List<Integer> list1 = Arrays.asList(3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        ComparatorListAverage comparatorListAverage = new ComparatorListAverage(listAverage);

        String result = comparatorListAverage.compareListAverage(list1, list2);

        assertEquals("Первый список имеет большее среднее значение", result);
    }

    @Test
    void compareAverageSecondListGreaterTest() {
        //проверка сравнения среднего значения списков, где значение второго списка больше
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4, 5);
        ComparatorListAverage comparatorListAverage = new ComparatorListAverage(listAverage);

        String result = comparatorListAverage.compareListAverage(list1, list2);

        assertEquals("Второй список имеет большее среднее значение", result);
    }

    @Test
    void compareAverageAveragesEqualTest() {
        //проверка сравнения среднего значения списков с одинаковым средним значением
        List<Integer> list1 = Arrays.asList(9, 3, 0);
        List<Integer> list2 = Arrays.asList(3, 4, 5);
        ComparatorListAverage comparatorListAverage = new ComparatorListAverage(listAverage);

        String result = comparatorListAverage.compareListAverage(list1, list2);

        assertEquals("Средние значения равны", result);
    }
}
