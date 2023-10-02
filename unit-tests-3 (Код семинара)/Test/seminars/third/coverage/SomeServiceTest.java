package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    SomeService service;

    @BeforeEach
    void setUp() {
        service = new SomeService();
    }


    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals(service.fizzBuzz(12), "Fizz");
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        assertEquals(service.fizzBuzz(10), "Buzz");
    }

    @Test
    void multipleThreeAndFiveReturnsFizzBuzz() {
        assertEquals(service.fizzBuzz(15), "FizzBuzz");
    }

    @Test
    void otherNumberReturnsStringNumber() {
        assertEquals(service.fizzBuzz(8), "8");
    }

    @Test
    void onlyFirst6Test() {
        int[] array = {6, 1, 2, 6, 7};
        assertTrue(service.firstLast6(array));
    }

    @Test
    void onlyLast6Test() {
        int[] array = {0, 1, 2, 6, 6};
        assertTrue(service.firstLast6(array));
    }

    @Test
    void FirstAndLastNot6Test() {
        int[] array = {0, 1, 2, 6, 0};
        assertFalse(service.firstLast6(array));
    }


    /**
     * @apiNote Обычная скидка
     * @param discount
     * @param result
     */
    @ParameterizedTest
    @CsvSource({"50, 1000", "100, 0", "0, 2000"})
    void CorrectDiscountCalculatingTest(int discount, int result) {
        assertThat(service.calculatingDiscount(2000.0, discount))
                .isEqualTo(result);
    }

    /**
     * @apiNote Процент скидки больше 100% или меньше 0%
     * @param discount
     */

    @ParameterizedTest
    @ValueSource(ints = {-10, 110})
    void InsufficientDiscountAmountTest(int discount) {
        assertThatThrownBy(() ->
                service.calculatingDiscount(2000.0, discount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void LuckySumATest() {
        assertEquals(service.luckySum(13, 2, 3), 5);
    }

    @Test
    void LuckySumBTest() {
        assertEquals(service.luckySum(3, 13, 3), 6);
    }

    @Test
    void LuckySumCTest() {
        assertEquals(service.luckySum(3, 4, 13), 7);
    }

    @Test
    void LuckySumTest() {
        assertEquals(service.luckySum(3, 4, 10), 17);
    }

    @Test
    void LuckySumDoubleTest() {
        assertEquals(service.luckySum(13, 13, 4), 17);
    }



}
