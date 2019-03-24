package lab5.Labs.Lab3.src;

import java.util.Random;

public class Warehouse
{
    public int number;

    public int addProduct()
    {
        Random random = new Random();
        number = random.nextInt(100);
        return number;
    }

    public int getProduct()
    {
        return number;
    }
}