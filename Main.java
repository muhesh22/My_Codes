import java.util.*;
public class Main{
    public static void bookTicket(passenger p){
        TicketBooker booker  = new TicketBooker();
        if (TicketBooker.AvailableWaitingList == 0){
            System.out.println("No Tickets Available");
            return;
        }

        if((p.BerthPreference.equals("L") && TicketBooker.AvailableLowerBerths > 0) || 
           (p.BerthPreference.equals("M") && TicketBooker.AvailableMiddleBerths > 0) ||
           (p.BerthPreference.equals("U") && TicketBooker.AvailableUpperBerths > 0)
        ){
            System.out.println("Preffered Birth Available");
            if(p.BerthPreference.equals("L")){
                System.out.println("Lower Berth Given");
                booker.bookTicket(p,(TicketBooker.lowerberthPositions.get(0)),"L");
                TicketBooker.lowerberthPositions.remove(0);
                TicketBooker.AvailableLowerBerths--;
            }
            else if(p.BerthPreference.equals("U")){
                System.out.println("Upper Berth Given");
                booker.bookTicket(p, (TicketBooker.upperberthPositions.get(0)), "U");
                TicketBooker.upperberthPositions.remove(0);
                TicketBooker.AvailableUpperBerths--;
            }
            else if(p.BerthPreference.equals("M")){
                System.out.println("Middle Berth Given");
                booker.bookTicket(p, (TicketBooker.middleberthPositions.get(0)), "M");
                TicketBooker.middleberthPositions.remove(0);
                TicketBooker.AvailableMiddleBerths--;
            }

        }

        else if(TicketBooker.AvailableLowerBerths > 0){
            System.out.println("Lower Berth Given");
            booker.bookTicket(p,(TicketBooker.lowerberthPositions.get(0)),"L");
            TicketBooker.lowerberthPositions.remove(0);
            TicketBooker.AvailableLowerBerths--;
        }

        else if(TicketBooker.AvailableMiddleBerths > 0){
            System.out.println("Middle Berth Given");
            booker.bookTicket(p, (TicketBooker.middleberthPositions.get(0)), "M");
            TicketBooker.middleberthPositions.remove(0);
            TicketBooker.AvailableMiddleBerths--;

        }
        else if(TicketBooker.AvailableUpperBerths > 0)
        {
            System.out.println("Upper Berth Given");
            booker.bookTicket(p,(TicketBooker.upperberthPositions.get(0)),"U");
            TicketBooker.upperberthPositions.remove(0);
            TicketBooker.AvailableUpperBerths--;
            
        }

        else if(TicketBooker.AvailableRacTickets > 0)
        {
            System.out.println("RAC available");
            booker.addToRAC(p,(TicketBooker.racPositions.get(0)),"RAC" );
        }

        else if(TicketBooker.AvailableWaitingList > 0)
        {
            System.out.println("Added to Waiting List");
            booker.addTowaitingList(p,(TicketBooker.WaitingListPositions.get(0)),"WL");
            
        }

    }
    
    public static void cancelTicket(int id){
        TicketBooker booker = new TicketBooker();
        if(!booker.passengers.containsKey(id)){
            System.out.println("Passenger Details Unknown");
        }
        else
            booker.cancelTicket(id);
    }

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("1. Book Ticket \n2. Cancel Ticket \n3. Available Tickets \n4. Booked Tickets \n5. Exit");
            int choice = s.nextInt();
            switch(choice){

                case 1:
                {
                    System.out.println("Enter Passanger name,age and berth preference (L,M or U)");
                    String name = s.next();
                    int age = s.nextInt();
                    String BerthPreference = s.next();
                    passenger p = new passenger(name, age, BerthPreference);
                    bookTicket(p); 
                }
                break;

                case 2:
                {
                    System.out.println("Enter PNR to cancel");
                    int id = s.nextInt();
                    cancelTicket(id);
                }
                break;

                case 3:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printAvailable();
                }
                break;
                //occupied tickets print
                case 4:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printPassengers();
                }
                break;
                //exit
                case 5:
                {
                    loop = false;
                }
                break;
                default:
                break;
            }
        }
        
    }
}