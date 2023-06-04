/**
 * The DateTime class extends the Date class and represents a date and time with hour and minute components.
 * It provides methods to manipulate and retrieve the individual components of the date and time,
 * as well as perform equality checks and obtain a string representation of the date and time.
 */
public class DateTime extends Date{
    private int hour;
    private int minute;

    /**
     * Constructs a DateTime object with the specified year, month, day, hour, and minute.
     * If the provided values are invalid, default values will be assigned.
     *
     * @param year   The year component of the date and time.
     * @param month  The month component of the date and time.
     * @param day    The day component of the date and time.
     * @param hour   The hour component of the date and time.
     * @param minute The minute component of the date and time.
     */
    DateTime(int year, int month, int day, int hour, int minute){
        super(year, month, day);
        if (checkHourValidity(hour)){
            this.hour = hour;
        }else {
            this.hour = 00;
        }
        if (checkMinuteValidity(minute)){
            this.minute = minute;
        }else{
            this.minute = 00;
        }
    }

    /**
     * Sets the minute component of the date and time.
     * If the provided value is invalid, the default value will be assigned.
     *
     * @param minute The minute component of the date and time.
     */
    public void setMinute(int minute) {
        if (checkMinuteValidity(minute)) {
            this.minute = minute;
        } else {
            this.minute = 00;
        }
    }

    /**
     * Sets the hour component of the date and time.
     * If the provided value is invalid, the default value will be assigned.
     *
     * @param hour The hour component of the date and time.
     */
    public void setHour(int hour){
        if(checkHourValidity(hour)){
            this.hour = hour;
        }else{
            this.hour = 00;
        }
    }

    /**
     * Returns the hour component of the date and time.
     *
     * @return The hour component of the date and time.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Returns the minute component of the date and time.
     *
     * @return The minute component of the date and time.
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Checks if the provided minute value is valid (between 00 and 59).
     *
     * @param minute The minute value to be checked.
     * @return True if the minute value is valid, false otherwise.
     */
    public boolean checkMinuteValidity(int minute){
        if (minute>=00 && minute <= 59){
            return true;
        }else return false;
    }

    /**
     * Checks if the provided hour value is valid (between 00 and 23).
     *
     * @param hour The hour value to be checked.
     * @return True if the hour value is valid, false otherwise.
     */
    public boolean checkHourValidity(int hour){
        if (hour >= 00 && hour <= 23){
            return true;
        }else return false;
    }

    /**
     * Generates the hash code for the DateTime object based on its components.
     *
     * @return The hash code value for the DateTime object.
     */
    @Override
    public int hashCode() {
        return 9999 *  super.getYear() + 12* super.getMonth() + super.getDay() + 60* hour + minute;
    }

    /**
     * Checks if this DateTime object is equal to another object, and we are doing a casting to other
     * in order to be sure that we can access to the function.
     *
     * @param other The object to compare for equality.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if ( (! (other instanceof DateTime)) ) {
            return false;
        }
        DateTime dateTimeToCheck = (DateTime) other;
        boolean timeFlag =  (this.hour == dateTimeToCheck.hour && this.minute == dateTimeToCheck.minute);
        boolean dateFlag = super.getDay() == dateTimeToCheck.getDay() && super.getMonth()== dateTimeToCheck.getMonth() && super.getYear() == dateTimeToCheck.getYear();
        return  timeFlag && dateFlag;
    }

    /**
     * Returns a string representation of the DateTime object.
     * The string is formatted as "DD/MM/YYYY hh:mm".
     *
     * @return A string representation of the DateTime object.
     */

    @Override
    public String toString() {
        return String.format("%02d",super.getDay()) + "/" + String.format("%02d",super.getMonth()) + "/" + String.format("%04d",super.getYear())
                + ' ' + String.format("%02d",getHour()) + ":" + String.format("%02d",getMinute());
    }
}
