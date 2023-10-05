package seminars.fourth.hotel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    HotelService mockedHotelService;
    BookingService bookingService;


    @BeforeEach
    public void setUp() {
        mockedHotelService = mock(HotelService.class);
        bookingService = new BookingService(mockedHotelService);
    }

    @Test
    public void BookingRoomAvailableTest() {
        when(mockedHotelService.isRoomAvailable(anyInt())).thenReturn(true);
        boolean result = bookingService.bookRoom(120);
        verify(mockedHotelService).isRoomAvailable(120);
        assertTrue(result);
    }

    @Test
    public void BookingRoomNotAvailableTest() {
        when(mockedHotelService.isRoomAvailable(anyInt())).thenReturn(false);
        boolean result = bookingService.bookRoom(121);
        verify(mockedHotelService).isRoomAvailable(121);
        assertFalse(result);
    }

}