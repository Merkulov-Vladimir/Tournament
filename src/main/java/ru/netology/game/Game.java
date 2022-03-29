package ru.netology.game;

import ru.netology.game.domain.NotRegisteredException;
import ru.netology.game.domain.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    public void register(Player player) {
        this.players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        var first = players.get(playerName1);
        var second = players.get(playerName2);
        if (first == null || second == null) {
            throw new NotRegisteredException("One or both players are not registered");
        }
        var result = first.getStrength() - second.getStrength();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
    }


}
