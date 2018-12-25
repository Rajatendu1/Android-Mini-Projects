package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add {

    private int mArgumentOne = 0;

    private int mArgumentTwo = 0;//Initializing instance variables



    public Add(int argumentOne, int argumentTwo) {

        mArgumentOne = argumentOne;

        mArgumentTwo = argumentTwo;//storing the arguments into their respective variables

    }



    public String toString() {

        return String.valueOf(mArgumentOne + mArgumentTwo);//returning the sum of the arguments

    }
    // TODO -- start your code here
}
