package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    GameStore store = new GameStore();
    Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game2 = store.publishGame("Тетрис", "Аркады");
    Game game3 = store.publishGame("World of Warcraft", "Стратегия");
    Game game4 = store.publishGame("Dota2", "ММОРПГ");
    Game game5 = store.publishGame("World of Tanks", "ММОРПГ");

    @Test
    public void shouldSumGenreIfOneGame() {

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void playException() {
        Player player = new Player("Petya");
        assertThrows(RuntimeException.class, () -> {
            player.play(game, 2);
        });

    }

    @Test
    public void name() {
        Player player = new Player("Petya");
        String expected = "Petya";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {
        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game2, 5);
        int expected = 8;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void play() {
        Player player = new Player("Anna");
        player.installGame(game3);
        player.play(game3, 2);
        player.play(game3, 5);
        int expected = 7;
        int actual = player.sumGenre(game3.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void repitInstallationGame() {

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game);
        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreZero() {
        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game2, 5);
        int expected = 0;
        int actual = player.sumGenre(game3.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void mostPlayerGenrePlayed() {
        Player player = new Player("Anna");
        player.installGame(game4);
        player.installGame(game5);
        player.installGame(game3);
        player.play(game4, 7);
        player.play(game5, 3);
        player.play(game3, 10);
        Game expected = game4;
        Game actual = player.mostPlayerByGenre("ММОРПГ");
        assertEquals(expected, actual);
    }

    @Test
    public void mostPlayerGenrePlayedNull() {
        Player player = new Player("Anna");
        player.installGame(game4);
        player.installGame(game5);
        player.installGame(game3);
        player.play(game4, 7);
        player.play(game5, 3);
        player.play(game3, 10);
        Game expected = null;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);

    }

    @Test
    public void shouldCheckPlayToSumHoursSameGenreGames() {
        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game2, 5);
        int expected = 8;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }
}