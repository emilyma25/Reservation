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
        addReservation(5, 5.00, 5, 500);
        displayReservations();
    }
    public void addReservation(int numPeople, double time, int priority, long timeMade){
        Reservation newReservation = new Reservation(numPeople, time, priority, timeMade);
        for(int i = 0; i < reservations.length; i++){
            if(reservations[i]==null){
                reservations[i]=newReservation;
                reservations[i].print();
                break;
            }
        }
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
}
