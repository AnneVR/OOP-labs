package lab5.Labs.Lab3.src;

public class ProducerThread extends Thread
{
    private int argument;
    private Warehouse warehouse;

    ProducerThread(int arg, Warehouse whouse)
    {
        argument = arg;
        warehouse = whouse;
    }

    public void run()
    {
        synchronized (warehouse)
        {
            for (int j = 0; j < argument; j++)
            {
                warehouse.addProduct();
                System.out.println((j+1) + " iteration");
                System.out.println(Thread.currentThread().getName() + ": Producer: Warehouse = " + warehouse.getProduct());

                try
                {
                    warehouse.wait();
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                warehouse.notify();
            }

        }

    }
}
