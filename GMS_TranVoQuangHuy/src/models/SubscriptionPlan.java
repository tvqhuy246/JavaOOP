package models;

public class SubscriptionPlan {

    private String planId;
    private String planName;
    private double price;
    private int durationInMonths;

    public SubscriptionPlan(String planId, String planName, double price, int durationInMonths) {
        this.planId = planId;
        this.planName = planName;
        this.price = price;
        this.durationInMonths = durationInMonths;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    @Override
    public String toString() {
        return "Plan [" + planId + "]: " + planName + " - $" + price + " (" + durationInMonths + " months)";
    }
}
