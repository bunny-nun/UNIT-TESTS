package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    public void NotificationCorrectTest() {

        MessageService mockedMessageService = mock(MessageService.class);
        doAnswer(invocation -> {
            System.out.println("Отправка сообщения \"test message\" получателю \"recipient\"");
            return null;
        }).when(mockedMessageService).sendMessage(anyString(), anyString());

        NotificationService notificationService = new NotificationService(mockedMessageService);

        notificationService.sendNotification("test message", "recipient");
        verify(mockedMessageService).sendMessage("test message", "recipient");
    }
}