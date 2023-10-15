package seminars.five;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    //5.1.

    @Test
    public void GenerateRandomNumbersLengthTest() {
        List<Integer> randomNumbers = new RandomNumberModule().generateRandomNumbers(10, 1, 15);
        assertEquals(randomNumbers.size(), 10);
    }

    @Test
    public void GenerateRandomNumbersMinRangeTest() {
        List<Integer> randomNumbers = new RandomNumberModule().generateRandomNumbers(10, 1, 15);
        assertTrue(Collections.min(randomNumbers) >= 1);
    }

    @Test
    public void GenerateRandomNumbersMaxRangeTest() {
        List<Integer> randomNumbers = new RandomNumberModule().generateRandomNumbers(10, 1, 15);
        assertTrue(Collections.max(randomNumbers) <= 15);
    }

    @ParameterizedTest
    @CsvSource({"-1, 15, 1"})
    public void GenerateRandomNumbersInvalidParametersTest(int length, int minRange, int maxRange) {
        assertThrows(IllegalArgumentException.class, ()-> new RandomNumberModule().generateRandomNumbers(length, 1, 15));
        assertThrows(IllegalArgumentException.class, ()-> new RandomNumberModule().generateRandomNumbers(10, minRange, maxRange));

    }

    @Test
    public void MaxNumberTest() {
        List<Integer> randomNumbers = new RandomNumberModule().generateRandomNumbers(10, 1, 15);
        assertEquals(Collections.max(randomNumbers), new MaxNumberModule().findMaxNumber(randomNumbers));
    }

    @Test
    public void MaxNumberEmptyListTest() {
        assertThrows(IllegalArgumentException.class, ()-> new MaxNumberModule().findMaxNumber(new ArrayList<Integer>()));
    }

    //5.2.

    @Test
    public void UserServiceTest() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        assertEquals(userService.getUserName(5), "User 5");
    }

    //5.3.

    @Test
    public void PlaceOrderTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);
        assertTrue(orderService.placeOrder("005", 500.50));
    }
}