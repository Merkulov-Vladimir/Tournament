package ru.netology.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.game.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player first = new Player(1, "first", 1);
    private Player second = new Player(2, "Second", 2);
    private Player third = new Player(3, "third", 3);
    private Player forth = new Player(4, "forth", 3);
    private Player firth = new Player(5, "firth", 44);
    private Player sixth = new Player(6, "six", 2);

    @BeforeEach
    void setUp() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(forth);
    }

    @Test
    void shouldWinSecondPlayer() {
        int actual = game.round(first.getName(), second.getName());
        assertEquals(2, actual);
    }

    @Test
    void shouldWinFirstPlayer() {
        int actual = game.round(third.getName(), second.getName());
        assertEquals(1, actual);
    }

    @Test
    void shouldDraw() {
        int actual = game.round(third.getName(), forth.getName());
        assertEquals(0, actual);
    }

    @Test
    void shouldThrowExceptionSecondNull() {
        assertThrows(NotRegisteredException.class, () -> game.round(third.getName(), firth.getName()));
    }

    @Test
    void shouldThrowExceptionAllNull() {
        assertThrows(NotRegisteredException.class, () -> game.round(third.getName(), sixth.getName()));
    }

    @Test
    void shouldThrowExceptionFirstNull() {
        assertThrows(NotRegisteredException.class, () -> game.round(sixth.getName(), third.getName()));
    }
}