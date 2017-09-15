package krankshafts;

/*
 * Copyright (C) 2017 markknapp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author markknapp
 */
import java.util.concurrent.ThreadLocalRandom;

public enum Direction {

    // use magic numbers to set the ordinal (used for rotation),
    // and the dx and dy of each direction.
    NORTH(0, 0, 1, 0),
    EAST(1, 1, 0, 90),
    SOUTH(2, 0, -1, 180),
    WEST(3, -1, 0, 270);

    private static final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    static public Direction randomDirection() {
        return Direction.values()[rnd.nextInt(4)];
    }

    private final int r90index, r180index, r270index;
    private final boolean horizontal, vertical;
    private final int dx, dy;
    private final double degree;

    private Direction(int ordinal, int dx, int dy, int degree) {
        this.dx = dx;
        this.dy = dy;
        this.degree = degree;
        this.horizontal = dx != 0;
        this.vertical = !horizontal;
        this.r90index  = (ordinal + 1) % 4; 
        this.r180index = (ordinal + 2) % 4; 
        this.r270index = (ordinal + 3) % 4; 
    }

    /**
     * Finds what the enum would be turned 90 deg clockwise
     * @return A Direction that is 90 deg clockwise.
     */  
    public Direction rotate90() {
        return values()[r90index];
    }

    /**
     * Finds what the enum would be turned 180 deg clockwise
     * @return A Direction that is 180 deg clockwise.
     */
    public Direction rotate180() {
        return values()[r180index];
    }

    /**
     * Finds what the enum would be turned 270 deg clockwise (90 CCW)
     * @return A Direction that is 270 deg clockwise. (90 CCW)
     */
    public Direction rotate270() {
        return values()[r270index];
    }

    /**
     * Get if the Direction is horizontal
     * @return True if EAST or WEST. False if NORTH or SOUTH
     */
    public Boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Get if the Direction is vertical
     * @return False if EAST or WEST. True if NORTH or SOUTH
     */
    public Boolean isVertical() {
        return vertical;
    }

    /**
     * Return the degree of the current facing.
     * @return degrees, where 0 is north, 90 is east, etc.
     */
    public double getDegree() {
        return degree;
    }
    
    
}