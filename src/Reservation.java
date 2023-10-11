public class Reservation {
    //this will help me make reservation objects

    public int numPeople;
    public double time;
    public int priority;
    //helpful for finding current time
    //System.currentTimeMillis();
    public long timeMade;

//    public Reservation(){
//        numPeople = 8;
//        time = 7.00;
//    }

    public Reservation(int pNumPeople, double pTime, int pPriority, long pTimeMade){
        numPeople = pNumPeople;
        time = pTime;
        priority = pPriority;
        timeMade = pTimeMade;
    }

    public void print(){
        System.out.println("At " + timeMade + ", a reservation was made for " + numPeople + " people at " + time + ". It has a priority of " + priority);
    }

}
