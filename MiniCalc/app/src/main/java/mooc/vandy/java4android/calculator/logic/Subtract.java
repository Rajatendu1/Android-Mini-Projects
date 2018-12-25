package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract {

    private int mArgumentOne = 0;

    private int mArgumentTwo = 0;//Initializing instance variables



    public Subtract(int argumentOne, int argumentTwo) {

        mArgumentOne = argumentOne;

        mArgumentTwo = argumentTwo;//storing the arguments into their respective variables

    }



    public String toString() {

        return String.valueOf(mArgumentOne - mArgumentTwo);//returning subtracted value

    }
    // TODO -- start your code here
}
