package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    public void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, -2})
    public void EvenNumberTest(int num) {
        assertTrue(mainHW.evenOddNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    public void OddNumber(int num) {
        assertFalse(mainHW.evenOddNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 25, 100, 150})
    public void numberInIntervalWrongTest(int num) {
        assertFalse(mainHW.numberInInterval(num));
    }

    @Test
    public void numberInIntervalCorrect() {
        assertTrue(mainHW.numberInInterval(75));
    }
}
