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


    public boolean contains(Event event) { 
        boolean eventInArray=false;
        for(int i=0; i < this.events.length; i++){
           if(event.equals(events[i])){
            eventInArray=true;
           }
        }
        return eventInArray;
    }
    public void print() { 
        for(int i=0; i < this.events.length; i++){
            System.out.println(events[i].toString());
        }
    } //print the array as is
    public void printByDate() { 
        for(int i=0; i<events.length; i++){ //sorting the events array by date using selection sort
            Event earliestEvent=events[i];
            int placeToSwitch=i;
            for(int p=i+1; p<events.length; p++){
                if (events[p].compareTo(earliestEvent)<0){
                    earliestEvent=events[p];
                    placeToSwitch=p;
                }
            }
            Event temp=events[placeToSwitch];
            events[placeToSwitch]=events[i];
            events[i]=temp;
        } // events is now sorted
        for(int i=0; i<events.length; i++){
            System.out.println(events[i].toString());
        }
    } 

    public void printByCampus() { 
        Event[] sortedEvents=new Event[events.length-1]; //making a new array to store the events sorted by campus in alphabetical order
        for(int i=0; i<3;i++){
            for(int j=0; j<events.length;j++){ 
                if(i==0){
                    if(events[j].getLocation().getCampus().equals("Busch")){
                        for(int z=0;z<sortedEvents.length;z++){ 
                            if(sortedEvents[z]==null) {
                            sortedEvents[z]=events[j]; 
                            }
                        }
                    }
                } else if(i==1){
                    if(events[j].getLocation().getCampus().equals("College Avenue")){
                        for(int z=0;z<sortedEvents.length;z++){ 
                            if(sortedEvents[z]==null) {
                            sortedEvents[z]=events[j]; 
                            }
                        }
                    }
                }else if(i==2){
                    if(events[j].getLocation().getCampus().equals("Livingston")){
                        for(int z=0;z<sortedEvents.length;z++){ 
                            if(sortedEvents[z]==null) {
                            sortedEvents[z]=events[j]; 
                            }
                        }
                    }
                }
            }
        } // sortedEvents is now sorted by campus alphabetically
        for(int i=0; i < sortedEvents.length; i++){
            System.out.println(sortedEvents[i].toString());
        }
    } //ordered by campus and building/room

    public void printByDepartment(){
        Event[] sortedEvents=new Event[events.length-1]; //making a new array to store the events sorted by campus in alphabetical order
        for(int i=0; i<5;i++){
            for(int j=0; j<events.length;j++){
                if(i==0){
                    if(events[j].getContact().getDepartment().getDepartmentName().equals("Business Analytics and Information Technology")){
                        for(int z=0;z<sortedEvents.length;z++){if(sortedEvents[z]==null) {sortedEvents[z]=events[j];}
                        }
                    }
                }else if(i==1){
                    if(events[j].getContact().getDepartment().getDepartmentName().equals("Computer Science")){
                        for(int z=0;z<sortedEvents.length;z++){ if(sortedEvents[z]==null) {sortedEvents[z]=events[j];}
                        }
                    }
                }else if(i==2){
                    if(events[j].getContact().getDepartment().getDepartmentName().equals("Electrical Engineering")){
                        for(int z=0;z<sortedEvents.length;z++){if(sortedEvents[z]==null) {sortedEvents[z]=events[j];}
                        }
                    }
                }
                else if(i==3){
                    if(events[j].getContact().getDepartment().getDepartmentName().equals("Information Technology and Informatics")){
                        for(int z=0;z<sortedEvents.length;z++){if(sortedEvents[z]==null) {sortedEvents[z]=events[j];}
                        }
                    }
                }
                else if(i==4){
                    if(events[j].getContact().getDepartment().getDepartmentName().equals("Mathematics")){
                        for(int z=0;z<sortedEvents.length;z++){if(sortedEvents[z]==null) {sortedEvents[z]=events[j];}
                        }
                    }
                }
            }
        }
        for(int i=0; i < sortedEvents.length; i++){
            System.out.println(sortedEvents[i].toString());
        }
     } //ordered by department



    }
