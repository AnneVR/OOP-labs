package lab5.Labs.Lab4.src;

class Worker extends Thread
{
    private String name;
    private Baskets mutex;

    Worker(String n, Baskets b)
    {
        name = n;
        mutex = b;
    }

    public void run()
    {
        System.out.println("Worker"+name+" is ready.");

        while(mutex.basketNumber > 0)
        {
            synchronized (mutex)
            {

                if (!mutex.done)
                {
                    if (mutex.turn == Integer.parseInt(name))
                    {

                        mutex.notify();

                        try
                        {
                            mutex.wait();
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }

                        mutex.basketNumber -= 1;
                        mutex.done = true;
                        mutex.turn();
                        System.out.println("Worker" + name + " picked " + (mutex.basketNumber + 1) + "th basket " /*+ mutex.done*/);
                        mutex.notify();

                }
                else
                {
                    try
                    {
                        mutex.notify();
                        mutex.wait();

                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                }
            }
        }

    }
}