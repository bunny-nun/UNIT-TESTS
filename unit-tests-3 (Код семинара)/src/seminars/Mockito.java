package seminars;

import java.awt.*;
import java.util.LinkedList;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

public class Mockito {

    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("nullValue");

        System.out.println(mockedList.get(0));

        when(mockedList.get(1)).thenThrow(new RuntimeException());

        verify(mockedList).get(0);

//        System.out.println(mockedList.get(1));

    }
}
