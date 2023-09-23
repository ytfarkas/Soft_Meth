public class Event implements Comparable<Event> {
    private Date date; //the event date
    private Timeslot startTime; //the starting time
    private Location location;
    private Contact contact; //include the department name and email
    private int duration; //in minutes



    @Override
    public boolean equals(Object obj){
        if(obj instanceof Event){
            Event event=(Event) obj;
            return event.date.equals(this.date) && event.startTime.equals(this.startTime) && event.location.equals(this.location); 
    
        }
        return false;
    }

    @Override
    public String toString(){
        return "[Event Date: " + date.getMonth() + "/" + "/" + date.getDay() + "/" + date.getYear() + "] [Start:" + 
            startTime.getTime()+"] [End: " + startTime.getEndTime(duration) + "  @" + location.name() + " ("
            + location.getBuildingName() +"," + location.getCampus()+") [Contact: " + 
            contact.getDepartment().getDepartmentName() + ", " + contact.getEmail();

        // [Event Date: 10/21/2023] [Start: 2:00pm] [End: 3:00pm] @HLL114 (Hill Center, Busch) [Contact: Computer Science, cs@rutgers.edu]
    }




    Event(Date date, Timeslot startTime, Location location, Contact contact, int duration){
        this.date=date;
        this.startTime=startTime;
        this.location=location;
        this.contact=contact;
        this.duration=duration;
    }
    }