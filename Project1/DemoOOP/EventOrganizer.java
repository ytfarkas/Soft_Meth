import java.util.Scanner;

public class EventOrganizer{

    private EventCalendar calendar;

    EventOrganizer(EventCalendar calendar){
        this.calendar=calendar;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Event Organizer running....");
        while (true){
            String input = scanner.next();
            if (input.equals("Q")){
                System.out.println ("Event Organizer terminated");
                break; }
            switch(input){
                case "A": case "R":
                    Date date = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    Timeslot timeslot=createTimeslot(scanner.next());
                    if(timeslot==null){ scanner.nextLine(); //going to next input line
                                        break;       }
                    Location location = createLocation(scanner.next());
                    if(location==null){ scanner.nextLine();
                                        break;       }
                        switch(input){
                            case "A":
                            Department department = createDepartment(scanner.next());
                            if(department==null){ scanner.nextLine();
                                                break;     }
                            Contact contact = new Contact(department, scanner.next());
                            calendar.add(new Event(date,timeslot,location, contact, scanner.nextInt()));
                            case "R":
                            calendar.remove(new Event(date,timeslot,location));
                        }
                case "P":
                    calendar.print();
                case "PE":
                        calendar.printByDate();

                case "PC":
                        calendar.printByCampus();
                case "PD":
                        calendar.printByDepartment();
            }   
        }
    }

    public Timeslot createTimeslot(String time){
        if(time.toLowerCase().equals("afternoon")) return Timeslot.AFTERNOON;
        else if(time.toLowerCase().equals("morning")) return Timeslot.MORNING;
        else if(time.toLowerCase().equals("evening"))return Timeslot.EVENING;
        System.out.println("Invalid time slot!");
        return null;
                    
    }

    public Location createLocation(String location){
        if(location.toLowerCase().equals("hll114")) return Location.HLL114;
        else if(location.toLowerCase().equals("arc103")) return Location.ARC103;
        else if(location.toLowerCase().equals("be_aud")) return Location.BE_AUD;
        else if(location.toLowerCase().equals("til232")) return Location.TIL232;
        else if(location.toLowerCase().equals("ab2225")) return Location.AB2225;
        else if(location.toLowerCase().equals("mu302")) return Location.MU302;
        System.out.println("Invalid Location");
        return null;

    }

    public Department createDepartment(String department){
        if(department.toLowerCase().equals("computer science")) return Department.CS;
        else if(department.toLowerCase().equals("electrical engineering")) return Department.EE;
        else if(department.toLowerCase().equals("information technology and informatics")) return Department.ITI;
        else if(department.toLowerCase().equals("mathematics")) return Department.MATH;
        else if(department.toLowerCase().equals("business analytics and information technology")) return Department.BAIT;
        System.out.println("Invalid Department!");
        return null;

    }
    
}

