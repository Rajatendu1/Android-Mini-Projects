package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;

    public static final int OUT = -1;

    public static final int CLOSED = 0;

    private int mSwing;
    //initialized the instance variables

    public Gate(){

        mSwing = CLOSED;

    }
    //default constructor for the Gate class

    public boolean setSwing(int direction) {

        if(direction == IN || direction == OUT || direction == CLOSED) {

            mSwing = direction;

            return true;

        }

        return false;

    }

    //setting swing direction

    public boolean open(int direction) {

        if (direction == IN || direction == OUT) {

            this.setSwing(direction);

            return true;

        }

        return false;

    }
    //calling setSwing when Gate is open

    public void close() {

        mSwing = 0;

    }

    //mSwing when Gate is closed

    public int getSwingDirection() {

        return mSwing;

    }

    //getting the value of mSwing at any instant

    public int thru(int count) {

        if(mSwing == IN)

            return count;

        else if(mSwing == OUT)

            return - count;

        else

            return 0;

    }
    //calculating the number of snails came or went away or if there was any movement

    public String toString() {

        if(mSwing ==0)

            return "This gate is closed";

        else if(mSwing == IN)

            return "This gate is open and swings to enter the pen only";

        else if (mSwing == OUT)

            return "This gate is open and swings to exit the pen only";

        else

            return "This gate has an invalid swing direction";

    }
    //output for the user to determine whether the gate is opened or not or has an invalid direction
}
