public class Date implements Comparable<Date> { // add comparable method
    private int year;
    private int month;
    private int day;

    public boolean isValid(int month, int day, int year) { // check if the date is a valid calendar date
        if (year > 1900) {
            switch (month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if (day >= 1 && day <= 31) {
                        return true;
                    }
                    break;
                case 4: case 6: case 9: case 11:
                    if (day >= 1 && day <= 30) {
                        return true;
                    }
                    break;
                case 2:
                    if (year / 4 == 0) {
                        if (year / 100 == 0) {
                            if (year / 400 == 0) {
                                if (day <= 28 && day >= 1) {
                                    return true;
                                }
                                break;
                            } else if (day <= 29 && day >= 1){
                                return true;
                            }
                            break;
                        } else if (day <= 29 && day >= 1){
                            return true;
                        }
                        break;
                    } else if (day <= 28 && day >= 1){
                        return true;
                    }
                    break;
                default:
                    return false;
            }
        }
        return false;
    }
    //test

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date) {
            Date date = (Date) obj;

            return date.year == this.year && date.month == this.month && date.day == this.day;

        }
        return false;
    }

    @Override
    public int compareTo(Date date) {
        if (this.year > date.year)
            return 1; // compare years first
        else if (date.year > this.year)
            return -1;
        else {// if they are equal
            if (this.month > date.month)
                return 1; // compare months
            else if (date.month > this.month)
                return -1;
            else { // if months are equal
                if (this.day > date.day)
                    return 1; // compare days
                else if (date.day > this.day)
                    return -1;
                else
                    return 0; // if days are equal
            }
        }
        /*
         * NEED TO CHECK IS THIS IS OK TO DO/ THIS IS HOW WE ARE SUPPOSED TO DO THIS
         */
    }
}
