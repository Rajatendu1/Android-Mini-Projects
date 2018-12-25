package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.logic.Add;
import mooc.vandy.java4android.calculator.logic.Divide;
import mooc.vandy.java4android.calculator.logic.Multiply;
import mooc.vandy.java4android.calculator.logic.Subtract;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic 
       implements LogicInterface {

    private static final int ADDITION = 1;

    private static final int SUBTRACTION = 2;

    private static final int MULTIPLICATION = 3;

    private static final int DIVISION = 4;//    Initializing the instance variables
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out){
        mOut = out;
    }

    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     */
    public void process(int argumentOne,
                        int argumentTwo,
                        int operation){

        if(operation == ADDITION) {

            Add a = new Add(argumentOne, argumentTwo);     //checking whether operation is addition and creating an object for Add

            mOut.print(a.toString());

        }

        else if(operation == SUBTRACTION) {

            Subtract s = new Subtract(argumentOne, argumentTwo);  //checking whether operation is substraction and creating an object for Subtract

            mOut.print(s.toString());

        }

        else if (operation == MULTIPLICATION) {

            Multiply m = new Multiply(argumentOne, argumentTwo);  //checking whether operation is multiplication and creating an object for Multiply

            mOut.print(m.toString());

        }

        else {

            Divide d = new Divide(argumentOne, argumentTwo);     //the last operation must be divide if none of the previous operations match and creating an object for Divide

            mOut.print(d.toString());

        }
        // TODO -- start your code here
    }
}
