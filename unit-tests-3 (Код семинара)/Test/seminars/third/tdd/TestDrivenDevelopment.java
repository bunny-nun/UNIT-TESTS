package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDrivenDevelopment {
    MoodAnalyser moodAnalyser;

    @BeforeEach
    public void setUp() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    public void MoodHappyTest() {
        assertEquals(moodAnalyser.analyseMood("I'm feeling happy!"), "Happy");
    }

    @Test
    public void MoodSadTest() {
        assertEquals(moodAnalyser.analyseMood("I am sad!"), "Sad");
    }

    @Test
    public void MoodNormalTest() {
        assertEquals(moodAnalyser.analyseMood("I'm feeling normal!"), "Normal");
    }

    @Test
    public void MoodOtherTest() {
        assertEquals(moodAnalyser.analyseMood("I'm feeling fantastic!"), "Other");
    }
}