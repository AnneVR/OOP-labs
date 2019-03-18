/*
 * Created by Anne Dudina, 23534/3
 */

import java.util.Scanner;


public class Main
{

    public static void main(String[] args)
    {
        try
        {
            System.out.print("How many workers will work today? ");
            Scanner w = new Scanner(System.in);
            int numberOfWorkers = Integer.parseInt(w.nextLine());
            System.out.print("How many baskets of apples do you need? ");
            Scanner b = new Scanner(System.in);
            int basketNumber = Integer.parseInt(b.nextLine());

            Worker workers[] = new Worker[numberOfWorkers];
            Baskets mutex = new Baskets(basketNumber, workers.length);
            Boss boss= new Boss("Big Boss", mutex);
            for (int i = 0; i < numberOfWorkers; i++)
            {
                workers[i] = new Worker(Integer.toString(i) , mutex );
            }



        }
        catch(NumberFormatException e)
        {
            System.out.println("Input error!");
        }
    }
}
