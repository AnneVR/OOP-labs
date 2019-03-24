package lab5.Labs.Lab3.src;

public class ConsumerThread extends Thread
{
    private int argument;
    private Warehouse warehouse;

    ConsumerThread(int arg, Warehouse whouse)
    {
        warehouse = whouse;
        argument = arg;
    }

    public void run()
    {
        synchronized (warehouse)
        {
            for (int i = 0; i < argument; i++)
            {
                System.out.println(Thread.currentThread().getName() + ": Consumer: Warehouse = " + warehouse.getProduct());
                warehouse.notify();
                try
                {
                    warehouse.wait();
                } catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }
        }
    }
}
