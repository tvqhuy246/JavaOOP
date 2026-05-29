package models;

public class WorkoutSchedule {

    private String scheduleId;
    private String memberName; // Lưu ý: Có thể cân nhắc đổi thành memberId nếu muốn chuẩn DB hơn
    private String trainerName;
    private String workout;
    private String date;
    private int progress; // Tiến độ: 0 - 100%

    public WorkoutSchedule(String scheduleId, String memberName,
                           String trainerName,
                           String workout,
                           String date) {
        this.scheduleId = scheduleId;
        this.memberName = memberName;
        this.trainerName = trainerName;
        this.workout = workout;
        this.date = date;
        this.progress = 0; // Mặc định là 0% khi mới tạo
    }

    public String getScheduleId() { return scheduleId; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getTrainerName() { return trainerName; }
    public void setTrainerName(String trainerName) { this.trainerName = trainerName; }

    public String getWorkout() { return workout; }
    public void setWorkout(String workout) { this.workout = workout; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }

    @Override
    public String toString() {
        return scheduleId + "," + memberName + "," +
                trainerName + "," +
                workout + "," +
                date + "," + progress + "%";
    }
}