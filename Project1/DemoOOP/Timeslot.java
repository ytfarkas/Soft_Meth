class Timeslot{
    //private classes
    private String timeslot;

    public Timeslot(String timeslot){
        this.timeslot = timeslot;
    }

    public getTimeslot(){
        return timeslot;
    }

    public void setTimeslot(String timeslot){
        if (timeslot == "morning" !! timeslot == "afternoon" !! timeslot == "evening"){
            this.timeslot = timeslot;
        }
    }
}
