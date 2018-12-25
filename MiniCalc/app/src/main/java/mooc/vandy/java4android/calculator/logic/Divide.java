package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide {

    private int mArgumentOne = 0;

    private int mArgumentTwo = 0;//Initializing instance variables



    public Divide(int argumentOne, int argumentTwo) {

        mArgumentOne = argumentOne;

        mArgumentTwo = argumentTwo;   //storing the arguments into their respective variables

    }



    public String toString() {
        if(mArgumentTwo!=0)//checking whether division is feasible or not

        return String.valueOf(mArgumentOne / mArgumentTwo) + " R:" + String.valueOf(mArgumentOne % mArgumentTwo);//returning quotient and remainder
        else
            return "Warning:Division by Zero";//returning a warning string if 2nd argument is 0

    }
    // TODO -- start your code here
}
