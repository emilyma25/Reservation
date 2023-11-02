import java.util.Scanner;
public class ReservationSystem {
    public Reservation[] reservations;
    public static void main(String[] args) {
        ReservationSystem jarvis = new ReservationSystem();
    }

    public ReservationSystem(){
//        Reservation gavin = new Reservation(6, 10.00, 3, 200);
//
//        Reservation dog = new Reservation(4, 7.30, 2, 100);
        //dog.print();
        reservations = new Reservation[10];
//        reservations[0] = gavin;
//        reservations[1] = dog;
//
//        //Reservation cat = new Reservation(2,8.00,1,90);
//        //reservations[2] = cat;
//
//        reservations[2] = new Reservation(2,8.00,1,90);
//
//        for(int i = 3; i < 9; i++){
//            reservations[i] = new Reservation(2,7.00,2, 6);
//        }
        addReservation(5, 5.00);
        addReservation(10, 10.00);
        Scanner scan = new Scanner(System.in);
        System.out.println("what is your name?");
        String name = scan.nextLine();
        boolean g = true;
        while(g==true) {
            System.out.println("hello, " + name + "! How can I help you?");
            System.out.println("Type 1 to add a reservation, 2 to view reservations, and 3 to sort the reservations for the top priority");
            String menuChoice = scan.nextLine();
            System.out.println(menuChoice);
            if (menuChoice.equals("1")) {
                System.out.println("Please type the number of people in your party");
                String numPeople = scan.nextLine();
                int intNumPeople = Integer.valueOf(numPeople);
                System.out.println(intNumPeople + " people");
                System.out.println("Please type the time you'd like to make a reservation for");
                String time = scan.nextLine();
                System.out.println(time + " time");
                //add reservation
            } else if (menuChoice.equals("2")) {
                displayReservations();
            } else if (menuChoice.equals("3")) {
                bubbleSort();
            } else {
                System.out.println("Sorry, " + menuChoice + " is not a choice");
            }
            //ask if they want to continue, if not then set boolean g to false
            System.out.println("would you like to continue? type 'yes or 'no'");
            String continueOrNot = scan.nextLine();
            if (continueOrNot.equals("yes")){
                //stuff
            } else if (continueOrNot.equals("no")){
                //stuff
            }else{
                //stuff
            }
        }
        addReservation(5, 5.00);
        addReservation(10, 10.00);

    }
    public void addReservation(int numPeople, double time){
        long timeMade = System.currentTimeMillis();
        long priority = System.currentTimeMillis();
        if (reservations.length==10){
            System.out.println("sorry, there is no more available space. please try again later");
        }else {
            Reservation newReservation = new Reservation(numPeople, time, priority, timeMade);
            for (int i = 0; i < reservations.length; i++) {
                if (reservations[i] == null) {
                    reservations[i] = newReservation;
                    break;
                }
            }
        }
    }

    public void priorityToInt(){

    }

    public void displayReservations(){
        for(int i = 0; i < reservations.length; i++) {
            if (reservations[i] != null) {
                reservations[i].print();
            } else{
                System.out.println("null");
            }
        }
    }

    public void bubbleSort() {
        int n = reservations.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (reservations[j] != null && reservations[j + 1] != null) {
                    if (reservations[j].getPriority() > reservations[j + 1].getPriority()) {
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
