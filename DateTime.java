public class DateTime extends Date{
    private int hour;
    private int minute;

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
    public void setMinute(int minute) {
        if (checkMinuteValidity(minute)) {
            this.minute = minute;
        } else {
            this.minute = 00;
        }
    }

    public void setHour(int hour){
        if(checkHourValidity(hour)){
            this.hour = hour;
        }else{
            this.hour = 00;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean checkMinuteValidity(int minute){
        if (minute>=00 && minute <= 59){
            return true;
        }else return false;
    }

    public boolean checkHourValidity(int hour){
        if (hour >= 00 && hour <= 23){
            return true;
        }else return false;
    }

    @Override
    public int hashCode() {
        return 9999 *  super.getYear() + 12* super.getMonth() + super.getDay() + 60* hour + minute;
    }

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

    @Override
    public String toString() {
        return String.format("%02d",super.getDay()) + "/" + String.format("%02d",super.getMonth()) + "/" + String.format("%04d",super.getYear())
                + ' ' + String.format("%02d",getHour()) + ":" + String.format("%02d",getMinute());
    }
}
