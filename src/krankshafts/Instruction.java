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

/**
 *
 * @author mark.knapp
 */
public enum Instruction {

    BACK1(-1, 0, "BACK\nONE"),
    BACK2(-2, 0, "BACK\nTWO"),
    FORWARD1(1, 0, "FORWARD\nONE"),
    FORWARD2(2, 0, "FORWARD\nTWO"),
    FORWARD3(3, 0, "FORWARD\nTHREE"),
    FORWARD4(4, 0, "FORWARD\nFOUR"),
    RIGHT(0, 1, "RIGHT\n90 DEGREES"),
    UTURN(0, 2, "TURN\nAROUND"),
    LEFT(0, -1, "LEFT\n90 DEGREES");
    
    private static final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    static public Instruction randomInstruction() {
        return Instruction.values()[rnd.nextInt(9)];
    }

    private final int move;
    private final int rotate;
    private final String text;

    private Instruction(int move, int rotate, String text) {
        this.move = move;
        this.rotate = rotate;
        this.text = text;
    }

    /**
     * @return the move
     */
    public int getMove() {
        return move;
    }

    /**
     * @return the rotate
     */
    public int getRotate() {
        return rotate;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

}