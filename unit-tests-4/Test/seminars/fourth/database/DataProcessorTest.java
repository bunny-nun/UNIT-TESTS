package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    @Test
    public void DataBaseQueryTest() {
        Database mockedDataBase = mock(Database.class);
        List<String> list = new ArrayList<>();
        list.add("1");
        when(mockedDataBase.query(anyString())).thenReturn(list);

        DataProcessor dataProcessor = new DataProcessor(mockedDataBase);
        List<String> result = dataProcessor.processData("SQL");
        verify(mockedDataBase).query("SQL");
        assertEquals(result.get(0), "1");
    }

}