package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply {

    private int mArgumentOne = 0;

    private int mArgumentTwo = 0;//Initializing instance variables



    public Multiply(int argumentOne, int argumentTwo) {

        mArgumentOne = argumentOne;

        mArgumentTwo = argumentTwo;//storing the arguments into their respective variables

    }



    public String toString() {

        return String.valueOf(mArgumentOne * mArgumentTwo);//returning product of the arguments

    }
    // TODO -- start your code here
}
