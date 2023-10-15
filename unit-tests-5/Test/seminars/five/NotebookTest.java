package seminars.five;

import org.junit.jupiter.api.Test;

public class NotebookTest {

    @Test
    public void addContactTest() {
        //юнит-тест
        //проверка успешного добавления нового контакта
    }

    @Test
    public void InvalidNumberAddTest() {
        //юнит-тест
        //проверка, что введение недопустимых символов в поле номера при добавлении нового контакта выбрасывает ошибку
    }

    @Test
    public void CorrectNameContactTest() {
        //юнит-тест
        //проверка корректного получения имени контакта
    }

    @Test
    public void CorrectNumberContactTest() {
        //юнит-тест
        //проверка корректного получения номера контакта
    }

    @Test
    public void DuplicateAddContactTest() {
        //юнит-тест
        //проверка успешного сохранения номера контакта с дублирующимся именем
    }

    @Test
    public void EditNameTest() {
        //юнит-тест
        //проверка успешного редактирования имени контакта
    }

    @Test
    public void EditNumberTest() {
        //юнит-тест
        //проверка успешного редактирования номера контакта
    }

    @Test
    public void InvalidNumberEditTest() {
        //юнит-тест
        //проверка, что введение недопустимых символов в поле номера при редактировании контакта выбрасывает ошибку
    }

    @Test
    public void DeleteContactTest() {
        //юнит-тест
        //проверка успешного удаления контакта
    }
     @Test
    public void CreateAddressBookTest(){
        //юнит-тест
         //проверка успешного создания экземпляра адресной книги
     }

    @Test
    public void addContactToAddressBookTest() {
        //юнит-тест
        //проверка успешного добавления нового контакта в адресную книгу
    }

    @Test
    public void EditContactInAddressBookTest() {
        //юнит-тест
        //проверка, что контакт успешно редактируется в адресной книге
    }
    @Test
    public void DeleteContactFromAddressBookTest() {
        //юнит-тест
        //проверка, что контакт успешно удаляется из адресной книги
    }
    @Test
    public void addContactToUITest() {
        //интеграционный тест
        //проверка успешного добавления нового контакта в адресную книгу через пользовательский интерфейс
    }

    @Test
    public void EditContactInUITest() {
        //интеграционный тест
        //проверка, что контакт успешно редактируется в адресной книге через пользовательский интерфейс
    }
    @Test
    public void testDeleteContactFromUITest() {
        //интеграционный тест
        //проверка, что контакт успешно удаляется из адресной книги через пользовательский интерфейс
    }

    @Test
    public void SearchNameTest() {
        //интеграционный тест
        //проверка успешного поиска контакта в адресной книге по имени через пользовательский интерфейс
    }

    @Test
    public void SearchNumberTest() {
        //интеграционный тест
        //проверка успешного поиска контакта в адресной книге по номеру через пользовательский интерфейс
    }

    @Test
    public void FullCycleTest() {
        //сквозной тест
        //проверка полного цикла работы с контактом через пользовательский интерфейс: создание контакта,
        // его редактирование и последующее удаление
    }
}
