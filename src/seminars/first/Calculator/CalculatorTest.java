package seminars.first.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

public class CalculatorTest {
    public static void main(String[] args) {

        assertEquals(Calculator.calculatingDiscount(10.0, 20), 8.0, 0.001);
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(10, -10)
        ).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-10, 20)
        ).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, 120)
        ).isInstanceOf(ArithmeticException.class);

        // Проверка базового функционала с целыми числами:
//        if (8 != Calculator.calculation(2, 6, '+')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (0 != Calculator.calculation(2, 2, '-')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (14 != Calculator.calculation(2, 7, '*')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (2 != Calculator.calculation(100, 50, '/')) {
//            throw new AssertionError("Ошибка в методе");
//        }

//         Случаи с неправильными аргументами
//         аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
//         try {
//             seminars.first.Calculator.Calculator.calculation(8, 4, '_');
//         } catch (IllegalStateException e) {
//             if (!e.getMessage().equals("Unexpected value operator: _")) {
//                 throw new AssertionError("Ошибка в методе");
//             }
//         }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
//        assert 8 == Calculator.calculation(2, 6, '+');
//        assert 0 == Calculator.calculation(2, 2, '-');
//        assert 14 == Calculator.calculation(2, 7, '*');
//        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

//        System.out.println(Calculator.calculation(2_147_483_647, 0, '+')); // integer overflow
//
//
//        System.out.println(Calculator.squareRootExtraction(169));

//         Примерные решения домашних заданий из 1 лекции:
//
//         HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
//         необходимые проверки для него используя граничные случаи

        assertThat(Calculator.squareRootExtraction(0)).isEqualTo(0);
        assertThat(Calculator.squareRootExtraction(1)).isEqualTo(1);
        assertThatThrownBy(() ->
                Calculator.squareRootExtraction(-169)
        ).isInstanceOf(IllegalArgumentException.class);

//         HW1.2: Как будет выглядеть проверка для случая деления на ноль? (с использованием AssertJ)
        assertThatThrownBy(() ->
                seminars.first.Calculator.Calculator.calculation(5, 0, '/')
        ).isInstanceOf(ArithmeticException.class);

//         HW1.3: Сравните одну и ту же проверку с использованием условий, ассертов, AssertJ
//         в каком случае стандартное сообщение об ошибке будет более информативным?
        if (seminars.first.Calculator.Calculator.calculation(2, 6, '+') != 8) {
            throw new AssertionError("Ошибка в методе");
        }
        assert seminars.first.Calculator.Calculator.calculation(2, 6, '+') == 8;
        assertThat(seminars.first.Calculator.Calculator.calculation(2, 6, '+')).isEqualTo(8);
    }
}