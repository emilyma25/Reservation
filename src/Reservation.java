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
        System.out.println("At " + timeMade + ", a reservation was made for " + numPeople + " people at " + time + ". It has a priority of " + priority);
    }

}
