package lab5.Labs.Lab4.src;

public class Baskets
{
    public int basketNumber ;
    public int doneBaskets = 0 ;
    public int workers;
    public int turn = 0;
    public int all;
    public boolean done = false;

    Baskets(int baskets, int workersl)
    {
        basketNumber = baskets;
        workers = workersl;
        all = baskets;
    }

    int turn()
        {
           turn++;
           while (turn >= (workers))  {turn = turn - workers;}
           return turn;
        }
}
