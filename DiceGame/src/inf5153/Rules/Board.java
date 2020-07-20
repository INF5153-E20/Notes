package inf5153.Rules;

import inf5153.Directions.Direction;
import inf5153.Rules.Actions.Action;
import inf5153.Rules.Tiles.*;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by wflag on 2020-06-08.
 */
public class Board implements BoardInterface {
    private Random rand = new Random();

    private Tile[][] grid;
    private List<Player> players = new ArrayList<>();

    @Override
    public void init(List<Player> players) {
        grid = new Tile[50][50];

        for(int y = 0; y < 50; y++) {
            for (int x = 0; x < 50; x++)
                grid[y][x] = new NormalTile();
        }

        grid[24][24] = new EndGameTile();

        for(int i = 0; i < 15; i++)
            placeSpecialTile(new BonusTile());
        for(int i = 0; i < 15; i++)
            placeSpecialTile(new MerchantTile());

        players.forEach(this::placePlayer);
    }

    private void placeSpecialTile(Tile tile) {
        while(true) {
            int x = rand.nextInt(50);
            int y = rand.nextInt(50);

            Tile targetTile = grid[y][x];
            if (!targetTile.isSpecial()) {
                grid[y][x] = tile;
                return;
            }
        }
    }

    private void placePlayer(Player p) {
        while(true) {
            int x = rand.nextInt(50);
            int y = rand.nextInt(50);
            Coordinates pos = new Coordinates(x, y);
            Coordinates center = new Coordinates(24, 24);

            Stream<Integer> playerDeltas = players.stream()
                    .map(Player::getPosition)
                    .map(c -> pos.distanceTo(c));

            if(pos.distanceTo(center) >= 5
                && playerDeltas.map(d -> d >= 10).reduce(Boolean::logicalAnd).orElse(true)) {
                p.setPosition(pos);
                players.add(p);
                return;
            }
        }
    }

    @Override
    public Stream<Action> move(Player token, Direction direction, int distance) {
        Coordinates newPos = token.getPosition().applyMove(direction, distance);
        if(newPos.isValid()) {
            token.setPosition(newPos);

            // Steal money from players on the same tile.
            players.stream()
                    .filter(p -> newPos.equals(p.getPosition()))
                    .forEach(target -> stealCoins(token, target));

            return newPos.getTile(grid).getActions();
        }
        else return null;
    }

    private void stealCoins(Player current, Player target) {
        int coins = target.getCoins() / 2;
        current.gainCoins(coins);
        target.gainCoins(-coins);
    }
}
