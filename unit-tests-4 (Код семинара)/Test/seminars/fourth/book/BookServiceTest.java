package seminars.fourth.book;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * 1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
 *
 * Тестовые заглушки используют для упрощения тестирования: они передаются
 * тестируемой системе вместо реальных зависимостей, настройка и сопровождение
 * которых могут быть сопряжены с определёнными сложностями.
 *
 * 2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?
 *
 * Mock
 *
 * 3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение
 * или исключение в ответ на вызов метода?
 *
 * Stub
 *
 * 4) Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или базой данных?
 *
 * Fake
 *
 */

class BookServiceTest {

    @Test
    public void findBookByIdTest() {

        // Arrange

        BookRepository mockBookRepository = mock(BookRepository.class);
        when(mockBookRepository.findById(anyString())).thenReturn(new Book("1", "Book1", "Author1"));
        BookService bookService = new BookService(mockBookRepository);

        // Act

        // Assert

        assertEquals(bookService.findBookById("123").getAuthor(), "Author1");
    }

    @Test
    public void findAllBooksTest() {

        // Arrange

        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);

        // Act

        // Assert

        assertEquals(bookService.findAllBooks().size(), 0);
    }
}
