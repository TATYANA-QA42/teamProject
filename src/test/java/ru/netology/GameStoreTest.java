package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldReturnFalseAddGames() { //должен возвращать false  при добавлении игры
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("World of Tanks", "Стратегия", store);
        assertFalse(store.containsGame(game2));
    }


    @Test
    public void shouldGetMostTimePlayer() { //должен получить наибольшее время игрока
        GameStore store = new GameStore();
        store.addPlayTime("Tim", 10);
        store.addPlayTime("Dron", 7);
        store.addPlayTime("Milk", 2);
        store.addPlayTime("Dron", 5);

        String actual = store.getMostPlayer();
        String expected = "Dron";
        assertEquals(expected, actual);
    }

    @Test
    public void PshouldGetMostlayerEqualsZero() { //должен получить большинство игроков равное нулю
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Tim", 1);

        String actual = store.getMostPlayer();
        String expected = "Tim";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerReturnNull() { //должен получить большинство игроков вернуть  Null
        GameStore store = new GameStore();
        store.addPlayTime("Tim", 0);
        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() { //должен возвращать Null при отрицательных значениях игрока

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Dron", -2);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisteredAddPlayTime() { //зарегистрированному должно добавляться время игры

        GameStore store = new GameStore();

        store.addPlayTime("Tim", 0);
        store.addPlayTime("Milk", 1);
        store.addPlayTime("Tim", 2);

        String actual = store.getMostPlayer();
        String expected = "Tim";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerEquallyOne() { //должен получить большинствоигроков ровно один

        GameStore store = new GameStore();

        store.addPlayTime("Milk", 1);
        store.addPlayTime("Dron", 1);
        store.addPlayTime("Tim", 1);

        String actual = store.getMostPlayer();
        String expected = "Dron";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() { // сумма сыгранного времени

        GameStore store = new GameStore();

        store.addPlayTime("Tim", 5);
        store.addPlayTime("Milk", 2);
        store.addPlayTime("Dron", 6);

        int actual = store.getSumPlayedTime();
        int expected = 13;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroGetSumPlayedTime() { // должен вернуть ноль  сумму сыгранного времени

        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

//    @Test
//    public void shouldGetSumZeroPlayedTime() { //должно получиться минусовое игровое время
//
//        GameStore store = new GameStore();
//
//        store.addPlayTime("Tim", 0);
//        store.addPlayTime("Milk", 0);
//        store.addPlayTime("Dron", 0);
//
//        int actual = store.getSumPlayedTime();
//        int expected = 0;
//        assertEquals(expected, actual);
//
//    }

    @Test
    public void shouldGetSumOnePlayedTime() { //сыгранное время

        GameStore store = new GameStore();

        store.addPlayTime("Tim", 0);
        store.addPlayTime("Milk", 0);
        store.addPlayTime("Dron", -1);

        int actual = store.getSumPlayedTime();
        int expected = -1;
        assertEquals(expected, actual);

    }
}

