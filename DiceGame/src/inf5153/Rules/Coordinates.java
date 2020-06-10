package inf5153.Rules;

import inf5153.Directions.CardinalDirection;
import inf5153.Directions.Direction;
import inf5153.Rules.Tiles.Tile;

import java.util.List;

/**
 * Created by wflag on 2020-06-08.
 */
public class Coordinates {
    private int x;
    private int y;

    public int getX() { return x; }
    public int getY() { return y; }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates applyMove(Direction direction, int distance) {
        List<CardinalDirection> directions = direction.getDirections();

        if(directions.size() == 1)
            return applyCardinalMove(directions.get(0), distance);
        else
            return this.applyCardinalMove(directions.get(0), distance / 2)
                    .applyCardinalMove(directions.get(1), distance / 2);
    }

    public Coordinates applyCardinalMove(CardinalDirection direction, int distance) {
        int x = this.x;
        int y = this.y;

        switch(direction) {
            case North:
                y += distance;
                break;
            case South:
                y -= distance;
                break;
            case East:
                x += distance;
                break;
            case West:
                x -= distance;
                break;
        }

        return new Coordinates(x, y);
    }

    public boolean isValid() {
        return x >= 0 && x < 50
                && y >= 0 && y < 50;
    }

    public Tile getTile(Tile[][] grid) {
        return grid[y][x];
    }

    public int distanceTo(Coordinates c) {
        return Math.abs(this.x - c.x) + Math.abs(this.y - c.y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(!(o instanceof Coordinates))
            return false;

        Coordinates c = (Coordinates)o;

        return c.x == this.x && c.y == this.y;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = (hashCode * 33) ^ x;
        hashCode = (hashCode * 33) ^ y;
        return hashCode;
    }
}