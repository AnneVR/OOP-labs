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
            System.out.print("Please, enter the number of iterations: ");
            Scanner in = new Scanner(System.in);
            int argument = Integer.parseInt(in.nextLine());

            Warehouse warehouse = new Warehouse();

            Thread producer = new ProducerThread(argument, warehouse);
            producer.start();

            Thread consumer = new ConsumerThread(argument, warehouse);
            consumer.start();
        }
        catch(NumberFormatException e)
        {
            System.out.println("Input error!");
        }
    }
}