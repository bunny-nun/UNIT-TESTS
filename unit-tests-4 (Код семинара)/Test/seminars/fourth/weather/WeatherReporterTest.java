package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {

    @Test
    public void WhetherReportCorrectTest() {
        WeatherService mockedWhetherService = mock(WeatherService.class);
        when(mockedWhetherService.getCurrentTemperature()).thenReturn(15);
        WeatherReporter weatherReporter = new WeatherReporter(mockedWhetherService);
        assertEquals(weatherReporter.generateReport(), "Текущая температура: 15 градусов.");
    }
}