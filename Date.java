public class Date {
    private int day;
    private int month;
    private int year;

    Date(int year, int month, int day){
        if ( checkDayValidity(day) ) {
            this.day = day;
        }else {
            this.day = 01;
        }
        if (checkMonthValidity(month)) {
            this.month = month;
        }else{
            this.month= 01;
        }
        if (checkYearValidity(year)){
            this.year = year;
        }else{
            this.year = 0000;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        if (checkDayValidity(day)) {
            this.day = day;
        }else{
            this.day = 1;
        }
    }

    public void setMonth(int month) {
        if (checkMonthValidity(month)) {
            this.month = month;
        }else{
            this.month = 1;
        }
    }

    public void setYear(int year) {
        if (checkYearValidity(year)) {
            this.year = year;
        }else{
            this.year = 0;
        }
    }

    public boolean checkDayValidity(int day){
        if (day > 00 && day < 32) {
            return true;
        }else return false;
    }
    public boolean checkMonthValidity(int month){
        if (month > 00 && month < 13){
            return true;
        }else return false;
    }
    public boolean checkYearValidity(int year){
        if (year > 0000 && year <= 3999){
            return true;
        }else return false;
    }

    @Override
    public int hashCode() {
        return 9999*year + 12*month + day;
    }

    @Override
    public boolean equals(Object other) {
        if ( (!(other instanceof Date)) || other instanceof DateTime ){
            return false;
        }
        Date dateToCheck = (Date) other;
        return (this.day == dateToCheck.day && this.month == dateToCheck.month && this.year== dateToCheck.year);
    }

    @Override
    public String toString() {
        return String.format("%02d",getDay()) + "/" + String.format("%02d",getMonth()) + "/" + String.format("%04d",getYear());
    }

}
