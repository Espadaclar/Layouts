
/**
 * Write a description of class Matematica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Matematica
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Matematica
     */
    public Matematica()
    {        // initialise instance variables
        x = 0;
    }


    public int suma(int num1, int num2)
    {
        int total = num1;
        for(int i = num2; i > 0; i -- ){
            total += 1;
        }
        return total;
    }
    
    public int multiplica(int num1, int num2)
    {
        int total = 0;
        for(int i = num2; i > 0; i -- ){
            total += num1;
        }
        return total;
    }
}
