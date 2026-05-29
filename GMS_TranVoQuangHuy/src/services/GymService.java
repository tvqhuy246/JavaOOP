package services;

import models.Attendance;
import models.Member;
import models.SubscriptionPlan;
import models.WorkoutSchedule;

import java.util.ArrayList;

public class GymService {

    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<WorkoutSchedule> schedules = new ArrayList<>();
    private ArrayList<SubscriptionPlan> subscriptions = new ArrayList<>();
    private ArrayList<Attendance> attendances = new ArrayList<>();

    public void loadData() {
        members = FileService.loadMembers("data/members.csv");
        schedules = FileService.loadSchedules("data/schedules.csv");
        subscriptions = FileService.loadSubscriptions("data/subscriptions.csv");
        attendances = FileService.loadAttendance("data/attendance.csv");
        System.out.println("Data loaded from CSV files.");
    }

    public void saveData() {
        // Ensure data directory exists
        new java.io.File("data").mkdirs();
        FileService.saveMembers("data/members.csv", members);
        FileService.saveSchedules("data/schedules.csv", schedules);
        FileService.saveSubscriptions("data/subscriptions.csv", subscriptions);
        FileService.saveAttendance("data/attendance.csv", attendances);
        System.out.println("Data saved to CSV files.");
    }

    public void addMember(Member member) {

        members.add(member);

        System.out.println(
                "Member added successfully.");
    }

    public void deleteMember(int id) {

        members.removeIf(
                member -> member.getId() == id);

        System.out.println(
                "Member deleted.");
    }

    public void displayMembers() {

        for(Member member : members) {

            System.out.println(member);
        }
    }

    public ArrayList<Member> getMembers() {

        return members;
    }
    
    public void addSchedule(WorkoutSchedule schedule) {
        schedules.add(schedule);
    }
    
    public ArrayList<WorkoutSchedule> getSchedules() {
        return schedules;
    }
    
    public void addAttendance(Attendance attendance) {
        attendances.add(attendance);
    }
    
    public ArrayList<Attendance> getAttendances() {
        return attendances;
    }

    public void searchMember(String name) {

        for(Member member : members) {

            if(member.getName()
                    .equalsIgnoreCase(name)) {

                System.out.println(member);
            }
        }
    }

}