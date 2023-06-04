/**
 * The Date class represents a specific date with day, month, and year components.
 * It provides methods to manipulate and retrieve the individual components of the date.
 */
public class Date {
    private int day;
    private int month;
    private int year;

    /**
     * Constructs a Date object with the specified year, month, and day.
     * If the provided values are invalid, default values will be assigned.
     *
     * @param year  The year component of the date.
     * @param month The month component of the date.
     * @param day   The day component of the date.
     */
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

    /**
     * Returns the day component of the date.
     *
     * @return The day component of the date.
     */
    public int getDay() {
        return day;
    }
    /**
     * Returns the month component of the date.
     *
     * @return The month component of the date.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the year component of the date.
     *
     * @return The year component of the date.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the day component of the date.
     * If the provided value is invalid, the default value will be assigned.
     *
     * @param day The day component of the date.
     */
    public void setDay(int day) {
        if (checkDayValidity(day)) {
            this.day = day;
        }else{
            this.day = 1;
        }
    }

    /**
     * Sets the month component of the date.
     * If the provided value is invalid, the default value will be assigned.
     *
     * @param month The month component of the date.
     */
    public void setMonth(int month) {
        if (checkMonthValidity(month)) {
            this.month = month;
        }else{
            this.month = 1;
        }
    }

    /**
     * Sets the year component of the date.
     * If the provided value is invalid, the default value will be assigned.
     *
     * @param year The year component of the date.
     */
    public void setYear(int year) {
        if (checkYearValidity(year)) {
            this.year = year;
        }else{
            this.year = 0;
        }
    }

    /**
     * Checks if the provided day value is valid (between 1 and 31).
     *
     * @param day The day value to be checked.
     * @return True if the day value is valid, false otherwise.
     */
    public boolean checkDayValidity(int day){
        if (day > 00 && day < 32) {
            return true;
        }else return false;
    }

    /**
     * Checks if the provided month value is valid (between 1 and 12).
     *
     * @param month The month value to be checked.
     * @return True if the month value is valid, false otherwise.
     */
    public boolean checkMonthValidity(int month){
        if (month > 00 && month < 13){
            return true;
        }else return false;
    }

    /**
     * Checks if the provided year value is valid (between 0000 and 3999).
     *
     * @param year The year value to be checked.
     * @return True if the year value is valid, false otherwise.
     */
    public boolean checkYearValidity(int year){
        if (year > 0000 && year <= 3999){
            return true;
        }else return false;
    }

    /**
     * Generates the hash code for the Date object based on its components.
     *
     * @return The hash code value for the Date object.
     */
    @Override
    public int hashCode() {
        return 9999*year + 12*month + day;
    }

    /**
     * Checks if this Date object is equal to another object that isn't an instanceof DateTime.
     *
     * @param other The object to compare for equality.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if ( (!(other instanceof Date)) || other instanceof DateTime ){
            return false;
        }
        Date dateToCheck = (Date) other;
        return (this.day == dateToCheck.day && this.month == dateToCheck.month && this.year== dateToCheck.year);
    }

    /**
     * Returns a string representation of the Date object.
     * The string is formatted as "DD/MM/YYYY".
     *
     * @return A string representation of the Date object.
     */
    @Override
    public String toString() {
        return String.format("%02d",getDay()) + "/" + String.format("%02d",getMonth()) + "/" + String.format("%04d",getYear());
    }

}
