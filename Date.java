import java.time.LocalDate;

public class Date {
    private int month = 0;
    private int day = 0;
    private int year = 0;
    private int dateValueNum = 0;
    private static LocalDate currentTime = LocalDate.now();
    private static Date currentDate = new Date(currentTime.getMonthValue(), currentTime.getDayOfMonth(), currentTime.getYear());

    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
        updateDateValueNum();
    }

    public void updateDateValueNum(){
        dateValueNum += (day);
        dateValueNum += (month*10);
        dateValueNum += (year*100);
    }

    public int getDateValueNum() {
        return dateValueNum;
    }

    public static void updateCurrentTime() {
        currentTime = LocalDate.now();
        System.out.println(currentTime.getDayOfMonth());
        currentDate = new Date(currentTime.getMonthValue(), currentTime.getDayOfMonth(), currentTime.getYear());
    }

    public static Date getCurrentDate() {
        return currentDate;
    }

    public void setMonth(int month) {
        if (month > 12 || month < 1) {
            System.out.println("Month invalid Error");
            this.month = 1;
        } else {
            this.month = month;
        }
    }

    public void setDay(int day) {
        this.day = day;
        if (day < 1) {
            System.out.println("Invalid Day");
            this.day = 1;
        } else {
            if (month == 0) { // Month Not set
                System.out.println("Month must be set first");
            } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) { // Month has 31 days
                if (day > 31) {
                    System.out.println("Invalid Day");
                    this.day = 1;
                }
            } else if (month == 2) { // Month has 28 days and is affected by leap year
                if (day > 29) {
                    System.out.println("Invalid Day");
                    this.day = 1;
                }
            } else { // Month has 30 days
                if (day > 31) {
                    System.out.println("Invalid Day");
                    this.day = 1;
                }
            }
        }
    }

    public void setYear(int year) {
        this.year = year;
        if (!(year % 4 == 0 && year % 100 != 0)) { // not leap year
            if (day == 29) {
                setDay(28);
            }
        }
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public String dateToString() {
        String dateString = (getMonth() + "-" + getDay() + "-" + getYear());
        return dateString;
    }
}
