import java.util.Scanner;
import java.util.ArrayList;

public class ReservationSystem {
    public Reservation[] reservations;
    public ArrayList<Reservation> waitlist;
    public static void main(String[] args) {
        ReservationSystem jarvis = new ReservationSystem();
    }

    public ReservationSystem(){

        reservations = new Reservation[10];
        waitlist = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("welcome to our restaurant! what is your name?");
        String name = scan.nextLine();
        boolean g = true;
        System.out.println("hello, " + name + "! How can I help you?");
        while(g==true) {
            System.out.println("Type 1 to add a reservation, 2 to view reservations, 3 to sort the reservations in order of priority, or 4 to view the waitlist");
            String menuChoice = scan.nextLine();
            if (menuChoice.equals("1")) {
                System.out.println("Please type the number of people in your party");
                String numPeople = scan.nextLine();
                int intNumPeople = Integer.valueOf(numPeople);
                System.out.println("Please type the time you'd like to make a reservation for");
                double time = scan.nextDouble();
                addReservation(intNumPeople,time);
                scan.nextLine();
            } else if (menuChoice.equals("2")) {
                System.out.println("reservations are in order of priority, top to bottom");
                displayReservations();
            } else if (menuChoice.equals("3")) {
                bubbleSort();
            } else if (menuChoice.equals("4")){
                displayWaitlist();
            }else {
                System.out.println("Sorry, " + menuChoice + " is not a choice");
            }
            //ask if they want to continue, if not then set boolean g to false
            System.out.println("would you like to continue? type 'yes or 'no'");
            String continueOrNot = scan.nextLine();
            if (continueOrNot.equals("no")){
                g=false;
            } else if (continueOrNot.equals("yes")){
                g=true;
            }else{
                System.out.println("sorry, that is not an option.");
            }
        }
    }

    int index=0;
    public void addReservation(int numPeople, double time){
        long timeMade = System.currentTimeMillis();
        long priority = System.currentTimeMillis();

        boolean reservationAdded = false;
        Reservation newReservation = new Reservation(numPeople, time, priority, timeMade);
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i] == null) {
                reservations[i] = newReservation;
                int index = i+1;
                int intPriority = index;
                reservationAdded = true;
                System.out.println("Your reservation for " + numPeople + " at " + time + " was successfully added! Your party's priority: " + intPriority);
                break;
                }
            }

        if (reservationAdded==false) {
            waitlist.add(new Reservation(numPeople, time, priority, timeMade));
            System.out.println("Sorry, there are no available reservation slots at the moment; you were added to our waitlist");
        }
    }


    public void displayReservations(){
        for(int i = 0; i < reservations.length; i++) {
            if (reservations[i] != null) {
                reservations[i].print();
            } else{
                System.out.println("no reservation yet");
            }
        }
    }

    public void displayWaitlist(){
        for (Reservation reservation : waitlist) {
            reservation.print();
        }
    }

    public void bubbleSort() {
        System.out.println("here are the reservations in order of lowest priority to highest priority");
        int n = reservations.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (reservations[j] != null && reservations[j + 1] != null) {
                    if (reservations[j].getPriority() < reservations[j + 1].getPriority()) {
                        //swap reservations[j] (higher number) and reservations[j + 1] (lower number)
                        Reservation temp = reservations[j];
                        reservations[j] = reservations[j + 1];
                        reservations[j + 1] = temp;
                    }
                }else if (reservations[j] == null && reservations[j + 1] != null) {
                    //move null reservation to the end
                    Reservation temp = reservations[j];
                    reservations[j] = reservations[j + 1];
                    reservations[j + 1] = temp;
                }
            }
        }
        //print new order
        for (int k=0;k<n;k++){
            if (reservations[k] != null){
                reservations[k].print();
            }else{
                System.out.println("null");
            }
        }
    }

//    public void selectionSort(){
//        int[] waffles = new int[10];
//        for(int i=0;i<waffles.length;i++){
//            waffles[i]=(int)(Math.random()*100);
//            System.out.print(waffles[i] + ", ");
//        }
//        System.out.println();
//        //start of selection sort
//        int n = waffles.length;
//        for (int k = 0; k < n-1; k++){
//            //find the min
//            int minIndex = k;
//            for (int v = k + 1; v < n; v++){
//                if (waffles[v]<waffles[minIndex]){
//                    minIndex=v;
//                }
//            }
//            //swap indexes
//            int temp = waffles[minIndex];
//            waffles[minIndex] = waffles[k];
//            waffles[k] = temp;
//        }
//        for(int i=0;i<waffles.length;i++){
//            System.out.print(waffles[i] + ", ");
//        }
//
//    }

}
