public class Date implements Comparable<Date> { //add comparable method
    private int year;
    private int month;
    private int day;
    public boolean isValid() //check if the date is a valid calendar date


    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Date){
            Date date = (Date) obj;

            return date.year==this.year && date.month==this.month && date.day==this.day;

        }
    }


    @Override
    public int compareTo(Date date){
        if(this.year>date.year) return 1;       //compare years first
        else if(date.year>this.year) return -1;
        else{//if they are equal
            if(this.month>date.month) return 1; //compare months
            else if(date.month>this.month) return -1;
            else{ //if months are equal
                if(this.day>date.day) return 1; //compare days
                else if(date.day>this.day) return -1;
                else return 0; //if days are equal
            }
        }
        /*
         * NEED TO CHECK IS THIS IS OK TO DO/ THIS IS HOW WE ARE SUPPOSED TO DO THIS
         */
    }
    }
