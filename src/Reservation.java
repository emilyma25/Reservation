import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Reservation {
    //this will help me make reservation objects

    public int numPeople;
    public double time;
    public long priority;
    //helpful for finding current time
    //System.currentTimeMillis();
    public long timeMade;


//    public Reservation(){
//        numPeople = 8;
//        time = 7.00;
//    }

    public Reservation(int pNumPeople, double pTime, long pPriority, long pTimeMade){
        numPeople = pNumPeople;
        time = pTime;
        priority = pPriority;
        timeMade = pTimeMade;
    }

    //for bubble sort method
    public long getPriority(){
        return priority;
    }

    public void print(){
        Date estDate = new Date(timeMade);

        //get rid of date and only keep time
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        //format time in est
        //timeFormat.setTimeZone(TimeZone.getTimeZone("EST"));

        System.out.println("At " + timeFormat.format(estDate) + ", a reservation was made for a party of " + numPeople + " at " + time + ".");
    }

}
