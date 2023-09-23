public enum Timeslot{
    MORNING("10:30am"),
    AFTERNOON("2:00pm"),
    EVENING("6:30pm");

    private final String time;

    Timeslot(String time){
        this.time=time;
    }

    public String getTime(){
        return time;
    }

    public String getEndTime(int duration){
        String[] s= time.split(":"); //rename this variable

        //I want to remove the AM/PM from the string, but first i need to save it for later use (the final string needs to include the am/pm)
        String amOrpm=s[1].substring(2, s[1].length());

        s[1] = s[1].substring(0, s[1].length() - 2); //this will remove the "am" or "pm" from the string so now we 
        //are working with two strings that can be easily converted to integers

        Integer h= Integer.valueOf(s[0]); //converting string object to Integer Object (cannot convert string directly to int)
        int hours=h.intValue(); //extracting the int value from the Integer Object

        //do same thing with minutes

        Integer m=Integer.valueOf(s[1]);
        int minutes=m.intValue();

        //now we can use the duration time to calculate when the endTime of the Timeslot is

        int beforeHour=60-minutes; //get how many minutes it is til the next hour

        if (duration<beforeHour){ //in this case, we can just add the time to minutes and return bc hours will not change
            minutes+=duration;
            if (minutes<10){
                return hours+":0"+minutes+amOrpm;
                // in the case that minutes is lets say the hoours is 10 and minutes is 5, the 
                //time would get printed as 10:5pm, need to add zero before so it becomes 10:05pm
            }
            return hours+":"+minutes+amOrpm;
        }
       
        else{ //now this is the more complicated case where both hours and minutes will have to be updated accordingly
            

            //first, its easier to calculate how many hours need to be added then do the minutes after

            int hourToAdd=duration/60; //this will be integer division because they are both ints,
                                        //so this will give the exact hours ex: 130/60=2

            int minutesToAdd=duration-(60*hourToAdd); //this will give the minutes 
            /**
             * ex: 130 is 2 hours and 10 minutes
             * 130/60=2 like above for hourToAdd
             * 130-(60*2)=10
             * 
             * this also works if the its an exact amount of hours
             * 
             */

             int oldHours=hours; //save hours before updating it for later use below


             hours+=hourToAdd;
             minutes+=minutesToAdd; //new hr and min values
             if (minutes>=60){
                
                hours++;
                minutes-=60;
                
                 /*
                  * in the case that minutes goes above 60, another hour will be added
                  ex:hours=5 minutes=75 (time would be 6:15)
                  hours++ = 6
                  75-60=15

                  */
             }

             //its possible hours could be over 12, so we need to account for that
             //also since we know the hours went up in this case, that means if the clock hit 12 then the AM/PM value changes
        

             if(hours>=12){
                if (hours>12){
                hours-=12; //you only want to do this if hours is greater than, not equal to bc then itd be zero
                }
                /**
                 * now switch am/pm value only if it went from a lower number than 12, 
                 * ex: in this if statement the case of it going from 12-1 is possible, and you dont want to 
                 * change am/pm value then
                 * 
                 */
                
                if(oldHours<12){
                    if(amOrpm.equals("pm")){
                      amOrpm="am";
                 }
                    else{
                      amOrpm="pm";
                    }
            }
        }

        if (minutes<10){
            return hours+":0"+minutes+amOrpm;
        }

        return hours+":"+minutes+amOrpm;

    }
}
}
