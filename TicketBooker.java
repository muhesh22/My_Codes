import java.util.*;
public class TicketBooker{

    static int AvailableLowerBerths = 1;
    static int AvailableUpperBerths = 1;
    static int AvailableMiddleBerths = 1;
    static int AvailableRacTickets = 1;
    static int AvailableWaitingList = 1;

    static Queue<Integer> waitingList = new LinkedList<>();
    static Queue<Integer> racList  =  new LinkedList<>();
    static List<Integer> bookedTicketList = new ArrayList<>();

    static List<Integer> lowerberthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperberthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> middleberthPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> WaitingListPositions = new ArrayList<>(Arrays.asList(1));

    static Map<Integer, passenger> passengers = new HashMap<>();

    public void bookTicket(passenger p, int berthInfo, String allotedBerth){

        p.SeatNumber = berthInfo;
        p.Alloted = allotedBerth;
        passengers.put(p.PNR,p);
        bookedTicketList.add(p.PNR);
        System.out.println("________________Booked Successfully");

    }

    public void addToRAC(passenger p, int racInfo, String allotedRAC){

        p.SeatNumber = racInfo;
        p.Alloted = allotedRAC;
        passengers.put(p.PNR,p);
        racList.add(p.PNR);
        AvailableRacTickets--;
        racPositions.remove(0);
        System.out.println("__________________Added to RAC Succesfully");
    }

    public void addTowaitingList(passenger p, int WaitingListInfo, String allotedWL){

        p.SeatNumber = WaitingListInfo;
        p.Alloted = allotedWL;
        passengers.put(p.PNR,p);
        waitingList.add(p.PNR);
        AvailableWaitingList--;
        WaitingListPositions.remove(0);
        System.out.println("______________________Added to WAiting List");

    }

    public void cancelTicket (int PNR){

        passenger p = passengers.get(PNR);
        passengers.remove(Integer.valueOf(PNR));
        bookedTicketList.remove(Integer.valueOf(PNR));
        int positionBooked = p.SeatNumber;
        System.out.println("__________________cancelled Successfully");

        if(p.Alloted.equals("L")){
            AvailableLowerBerths++;
            lowerberthPositions.add(positionBooked);
        }
        else if(p.Alloted.equals("M")){
            AvailableMiddleBerths++;
            middleberthPositions.add(positionBooked);
        }
        else if(p.Alloted.equals("U")){
            AvailableUpperBerths++;
            upperberthPositions.add(positionBooked);
        }

        if(racList.size()>0){

            passenger passengerfromRAC = passengers.get(racList.poll());
            int positionRac = passengerfromRAC.SeatNumber;
            racPositions.add(positionRac);
            racList.remove(Integer.valueOf(passengerfromRAC.PNR));
            AvailableRacTickets++;

            if(waitingList.size()>0){
                passenger passengerFromWaitingList = passengers.get(waitingList.poll());
                int positionWL = passengerFromWaitingList.SeatNumber;
                WaitingListPositions.add(positionWL);
                waitingList.remove(Integer.valueOf(passengerFromWaitingList.PNR));

                passengerFromWaitingList.SeatNumber = racPositions.get(0);
                passengerFromWaitingList.Alloted = "RAC";
                racPositions.remove(0);
                racList.add(passengerFromWaitingList.PNR);

                AvailableWaitingList++;
                AvailableRacTickets--;

            }

            Main.bookTicket(passengerfromRAC);
        }
    }

    public void printAvailable(){
        System.out.println("Available Lower Berths  "  + AvailableLowerBerths);
        System.out.println("Available Middle Berths "  + AvailableMiddleBerths);
        System.out.println("Available Upper Berths  "  + AvailableUpperBerths);
        System.out.println("Availabel RACs          " + AvailableRacTickets);
        System.out.println("Available Waiting List  " + AvailableWaitingList);
        System.out.println("____________________");

    }

    public void printPassengers(){
        if(passengers.size() == 0){
            System.out.println("No detail of passengers");
            return;
        }
        for(passenger p : passengers.values()){
            System.out.println("PNR     " + p.PNR);
            System.out.println("Name    " + p.name);
            System.out.println("Age     " + p.age);
            System.out.println("Status  " + p.SeatNumber + p.Alloted);
            System.out.println("_________________");
        }
    }
}