package lab5.Labs.Lab4.src;/*
 * Created by Anne Dudina, 23534/3
 */

import java.util.Scanner;


public class FourthLab
{

    public static void main(String worker, String baskets)
    {
        try
        {
            /*System.out.print("How many workers will work today? ");
            Scanner w = new Scanner(System.in);*/
            int numberOfWorkers = Integer.parseInt(worker);
            /*System.out.print("How many baskets of apples do you need? ");
            Scanner b = new Scanner(System.in);*/
            int basketNumber = Integer.parseInt(baskets);

            Worker workers[] = new Worker[numberOfWorkers];
            Baskets mutex = new Baskets(basketNumber, workers.length);
            Boss boss= new Boss("Big Boss", mutex);

            for (int i = 0; i < numberOfWorkers; i++)
            {
                workers[i] = new Worker(Integer.toString(i) , mutex );
                workers[i].start();
            }
            boss.start();
            try{

                for (int i = 0; i < numberOfWorkers; i++){ workers[i].join(); }
                boss.join();
            }
            catch(InterruptedException e){}


        }
        catch(NumberFormatException e)
        {
            System.out.println("Input error!");
        }
    }
}
