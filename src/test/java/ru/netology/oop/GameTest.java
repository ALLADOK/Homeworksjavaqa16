package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void whenShouldSecondPlayerWin() {
        Player jura = new Player(16, "Юра", 105);
        Player dima = new Player(5, "Дима", 100);
        Game game = new Game();

        game.register(jura);
        game.register(dima);
        int actual = game.round("Дима", "Юра");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenShouldFirstPlayerWin() {
        Player dima = new Player(5, "Дима", 105);
        Player jura = new Player(16, "Юра", 100);
        Game game = new Game();

        game.register(jura);
        game.register(dima);
        int actual = game.round("Дима", "Юра");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenStrengthsEqual() {
        Player dima = new Player(5, "Дима", 100);
        Player jura = new Player(16, "Юра", 100);
        Game game = new Game();

        game.register(jura);
        game.register(dima);
        int actual = game.round("Дима", "Юра");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotExist() {
        Player dima = new Player(5, "Дима", 100);
        Game game = new Game();

        game.register(dima);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Иван", "Дима")
        );
    }

    @Test
    public void whenSecondPlayerNotExist() {
        Player dima = new Player(5, "Дима", 100);
        Game game = new Game();

        game.register(dima);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Дима", "Иван")
        );
    }

}