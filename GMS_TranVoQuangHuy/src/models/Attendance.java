package models;

public class Attendance {

    private int memberId;
    private String date;
    private boolean present;

    public Attendance(int memberId,
                      String date,
                      boolean present) {

        this.memberId = memberId;
        this.date = date;
        this.present = present;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getDate() {
        return date;
    }

    public boolean isPresent() {
        return present;
    }

    @Override
    public String toString() {

        return memberId + "," +
                date + "," +
                present;
    }
}