public class EventCalendar {
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array
    private int size; // size of the array

    public EventCalendar(int size){
        this.size = size;
        this.events = new Event[size];
        this.numEvents = 0;

    }

    private int find(Event event) {//search an event in the list
    for (int i = 0; i < numEvents; i++){
        if (events[i] == event){
            return i;
            break;
        }
    }
    } 
    private void grow() { //increase the capacity by 4
        this.size = size + 4;
        Event[] growEvents = new Event[size];

        for (int i = 0; i < numEvents; i++){
            growEvents[i] = events[i];

        }
        this.events = growEvents;

    } 

    public boolean add(Event event) { 
        if (numEvents == size){
            grow();
        }
        events[numEvents] = event;
        numEvents++;
    }


    public boolean remove(Event event) {
        int rm = find(event);
        Event[] removeEvent = new Event[size]; //does she want us to decrease array size when removed?
        for (int i = 0; i < numEvents; i++){
            if (i != rm){
                removeEvent[i] = events[i];
            }
        }
        this.events = removeEvent;
        this.numEvents--;
     }
     
    public boolean contains(Event event) { }
    public void print() { } //print the array as is
    public void printByDate() { } //ordered by date and timeslot
    public void printByCampus() { } //ordered by campus and building/room
    public void printByDepartment(){ } //ordered by department
    }
