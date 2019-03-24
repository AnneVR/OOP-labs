package lab5.Labs.Lab3.src;/*
 * Created by Anne Dudina, 23534/3
 */

import java.util.Scanner;

public class ThirdLab
{
    public static void main(String value)
    {
        try
        {
            /*System.out.print("Please, enter the number of iterations: ");
            Scanner in = new Scanner(System.in);*/
            int argument = Integer.parseInt(value);

            Warehouse warehouse = new Warehouse();

            Thread producer = new ProducerThread(argument, warehouse);
            producer.start();

            Thread consumer = new ConsumerThread(argument, warehouse);
            consumer.start();

            try
            {
                producer.join();
                consumer.join();
            }
            catch(InterruptedException e){System.out.println("Error!");}

        }
        catch(NumberFormatException e)
        {
            System.out.println("Input error!");
        }







    }
}