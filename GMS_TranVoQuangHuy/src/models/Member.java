package models;

public class Member extends User {

    private String subscriptionStatus;
    private String startDate; // Ngày bắt đầu gói tập
    private String endDate;   // Ngày kết thúc gói tập
    private java.util.List<String> attendanceDates; // Danh sách các ngày đi tập
    private int attendanceCount;
    private int progress;
    private double amountPaid;

    public Member(int id, String username, String password,
                  String name, String subscriptionStatus,
                  String startDate, String endDate,
                  double amountPaid) {

        super(id, username, password, name, "Member");

        this.subscriptionStatus = subscriptionStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountPaid = amountPaid;
        this.attendanceCount = 0;
        this.attendanceDates = new java.util.ArrayList<>();
        this.progress = 70;
    }

    public void markAttendance(String date) {
        attendanceCount++;
        attendanceDates.add(date);
    }

    public void updateProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public java.util.List<String> getAttendanceDates() {
        return attendanceDates;
    }

    public void renewSubscription() {
        subscriptionStatus = "Active";
    }

    public String getReward() {

        if(progress >= 90) {
            return "Gold Reward";
        }

        if(progress >= 70) {
            return "Silver Reward";
        }

        return "No Reward";
    }

    @Override
    public void displayMenu() {

        System.out.println("\n===== MEMBER MENU =====");
        System.out.println("1. View Progress");
        System.out.println("2. Renew Subscription");
        System.out.println("3. View Rewards");
    }

    @Override
    public String toString() {

        return id + "," + name + "," +
                subscriptionStatus + "," +
                attendanceCount + "," +
                progress + "," +
                amountPaid;
    }
}