/*
 * Created by Anne Dudina, 23534/3
 */
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.Period;

public class Main
{
    public static int getMonthNumber(int day, String month, int year)
    {
        int Number;
        switch(month)
        {
            case "January":
            case "january":
                Number = 1;
                if(day > 31)
                {
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "February":
            case "february":
                Number = 2;
                if ((day == 29) && !((year % 4 == 0) && year % 100 != 0))
                {
                    System.out.println("entered year is not leap");
                    throw new IllegalArgumentException();
                }
                if(day > 29)
                {
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }

                break;
            case "March":
            case "march":
                Number = 3;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "April":
            case "april":
                Number = 4;
                if(day > 30){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "May":
            case "may":
                Number = 5;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "June":
            case "june":
                Number = 6;
                if(day > 30){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "July":
            case "july":
                Number = 7;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "August":
            case "august":
                Number = 8;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "September":
            case "september":
                Number = 9;
                if(day > 30){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "October":
            case "october":
                Number = 10;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "November":
            case "november":
                Number = 11;
                if(day > 30){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            case "December":
            case "december":
                Number = 12;
                if(day > 31){
                    System.out.println("there's no so many days in this month");
                    throw new IllegalArgumentException();
                }
                break;
            default:
                System.out.println("Usage: <day>/int <month>/string <year>/int");
                throw new IllegalArgumentException();

        }
        return Number;
    }

    public static void main(String[] args)
    {
        try
        {
            try
            {
                System.out.print("Enter your day of birth : ");
                Scanner in = new Scanner(System.in);
                int dayB = Integer.parseInt(in.nextLine());

                System.out.print("Enter your month(word) of birth : ");
                Scanner in1 = new Scanner(System.in);
                String monthB = in1.nextLine();

                System.out.print("Enter your year of birth : ");
                Scanner in2 = new Scanner(System.in);
                int yearB = Integer.parseInt(in.nextLine());

                int monthNumber = getMonthNumber(dayB,monthB,yearB);
                LocalDate date = LocalDate.of(yearB, monthNumber, dayB);
                LocalDate today = LocalDate.now();
                if ((Period.between(date, today).getDays() < 0)
                        || (Period.between(date, today).getMonths() < 0)
                        || (Period.between(date, today).getYears() < 0))
                {
                    System.out.println("Wrong date!");
                    throw new IllegalArgumentException();
                }
                int years = Period.between(date, today).getYears();
                int months = Period.between(date, today).getMonths();
                int days = Period.between(date, today).getDays();
                System.out.println("Your age today " + today +" is " + years + " years " + months + " months " + days + " days ");

            }
            catch (DateTimeException e)
            {
                System.out.println("Input error!");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Input error!");
        }
    }
}
