import java.util.Scanner;

public class EventOrganizer{

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Event Organizer running....");
        String input = scanner.nextLine();

        while (true){
            if (input.equals("Q")){
            System.out.println ("Event Organizer terminated");
                break;
            }
            switch(input){
                case "A":
                Date date = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                Timeslot timeslot = new Timeslot(scanner.nextLine());
                Location location = new Location(scanner.nextLine());
                Department department = new Department( scanner.nextLine());
                Contact contact = new Contact(scanner.nextLine(), scanner.nextLine());

                case "P":
                EventCalendar.print();
                case "PE":
                case "PC":
                case "PD":
                
            }

            
        }

    }

}
