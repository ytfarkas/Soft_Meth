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

               /*  
                THIS IS PREVIOUS CODE FROM BEFORE THAT IS REPLACED BELOW
               if (hours>24){
                    hours-=24;  //this is in the case that the duration inputted is like 23hours
                                //ex: 2:00+23 hours= 25 
                                //25-24=1 (23 hours after 2PM would be 1PM)
                }
                else if (hours>12){

                hours-=12; //you only want to do this if hours is greater than, not equal to bc then itd be zero
                }*/



                /**
                 * now switch am/pm value accordingly
                 * check explanation below for why you use %2==1 to change ampm value 
                 */
                
                
                    
                    if((hours/12)%2==1){     
                        if(amOrpm.equals("pm")){
                            amOrpm="am";
                       }
                          else{
                            amOrpm="pm";
                          }
                    }

                      /*
             * this part you really have to draw out to understand why it works for changing the am/pm value properly.
             * above in the code i commented out, i just tried to hardcode if the hours was either greater than 12 or greater then 24, 
             * but what if the user inputs 48 hours or even 100 hours??
             * 
             * in order to calculate when the change the am/pm value, you need to understand when the am/pm value gets changed and when it doesn't get changed
             * whenever the time increased is<12 hours, the am/pm value wont change
             * whenever the time increased is 12<x<24 (x for time increased), ampm value will change ex: 1:00pm + 13 hours= 2:00am
             * whenever the time increased is 24<x<36, the ampm value will not change ex: 1:00pm + 25 hours = 2:00pm
             * and this pattern continues
             * 
             * what can you do with this?
             * 
             * lets say for 12<x<24, all those numbers divided by 12 are 1 when using INTEGER DIVISION, ex: 12/13=1 12/23=1
             * and for 24<x<36, all those numbers divided by 12 are 2 using integer division, ex: 12/25=2 12/35=2
             * 
             * so in order to caputer this pattern as it goes into higher numbers, you need to use the %2 to check whether to change the ampm value
             * notice above how if you do (12/13)%2 it will equal 1, and the ampm value will change
             *  (12/25)%2=0, so the ampm value wont change
             *  this pattern will continue for higher numbers ex: 2:00pm + 47hours = 1:00pm --> 47/12=3 --> 3%2==1 so you change the ampm value
             *                                                    
             */

           // }

            
            hours=hours-((hours/12)*12); //this calculates what the time should be e
                                /*
                                 * ex: say its 2:00pm and you add 49 hours, that would be 3:00pm
                                 * hours=2, hoursToAdd=49, hours+hourstoadd=51
                                 * 51/12=4
                                 * 12*4=48
                                 * 
                                 * 51-((51/12)*12) = 51-48=3 
                                 */

            if (hours==0){
                hours=12;
                //the above equation produces 0 if the hours gets added up to an exact multiple of 12 like 24,48, or 60
                //this is an edge case where you can just convert from 0 to 12
            }

          
        }

        if (minutes<10){
            return hours+":0"+minutes+amOrpm;
        }

        return hours+":"+minutes+amOrpm;

    }
}
}
