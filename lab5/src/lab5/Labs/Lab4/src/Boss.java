package lab5.Labs.Lab4.src;

class Boss extends Thread
{
    private String name;
    private Baskets mutex;

    Boss(String n, Baskets b)
    {
        name = n;
        mutex = b;
    }

    public void run()
    {
        try
        {
            System.out.println(name + " is here. Let's go!");
            while (mutex.basketNumber >= 0)
            {

                synchronized (mutex)
                {

                    if (mutex.done)
                    {
                        mutex.done = false;
                        mutex.doneBaskets += 1;

                        System.out.println("Big Boss documented done baskets: " + mutex.doneBaskets);

                        if (mutex.basketNumber == 0 )
                        {
                            System.out.println("All " + mutex.doneBaskets + " baskets are collected ");
                            break;
                        }
                    }

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
        catch(Exception e){}
        }
    }

