package seminars.second.hw;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class VehicleTest {
    static Car car;
    static Motorcycle motorcycle;

    @BeforeAll
    public static void setUp() {
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Ducati", "1098", 2007);
    }

    @AfterEach
    public void stopVehicles() {
        car.park();
        motorcycle.park();
    }

    // проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
    @Test
    public void testCarIsInstanceOfVehicle() {
        // arrange

        // act

        //assert
        assertTrue(car instanceof Vehicle);
    }

    // проверка того, объект Car создается с 4-мя колесами
    @Test
    public void testCarNumWheelsIsCorrect() {
        // arrange

        // act

        //assert
        assertEquals(car.getNumWheels(), 4);
    }

    // проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    public void testMotorcycleNumWheelsIsCorrect() {
        // arrange

        // act

        //assert
        assertEquals(motorcycle.getNumWheels(), 2);
    }

    //проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    public void testCarTestDriveSpeedIsCorrect() {
        // arrange

        // act
        car.testDrive();

        //assert
        assertEquals(car.getSpeed(), 60);
    }

    //проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    public void testMotorcycleTestDriveSpeedIsCorrect() {
        // arrange

        // act
        motorcycle.testDrive();

        //assert
        assertEquals(motorcycle.getSpeed(), 75);
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    public void testCarParkedSpeedIsCorrect() {
        // arrange

        // act
        car.testDrive();
        car.park();

        //assert
        assertEquals(car.getSpeed(), 0);
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    public void testMotorcycleParkedSpeedIsCorrect() {
        // arrange

        // act
        motorcycle.testDrive();
        motorcycle.park();

        //assert
        assertEquals(motorcycle.getSpeed(), 0);
    }




}