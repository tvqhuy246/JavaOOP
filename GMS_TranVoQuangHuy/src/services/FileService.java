package services;

import models.Attendance;
import models.Member;
import models.SubscriptionPlan;
import models.WorkoutSchedule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    // --- MEMBERS ---
    public static void saveMembers(String fileName, List<Member> members) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Member m : members) {
                // Format: id,username,password,name,subscriptionStatus,startDate,endDate,amountPaid,attendanceCount,progress
                writer.println(m.getId() + "," + m.getUsername() + "," + m.getPassword() + "," + m.getName() + "," +
                        m.getSubscriptionStatus() + "," + m.getStartDate() + "," + m.getEndDate() + "," +
                        m.getAmountPaid() + "," + m.getAttendanceCount() + "," + m.getProgress());
            }
        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
        }
    }

    public static ArrayList<Member> loadMembers(String fileName) {
        ArrayList<Member> members = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return members;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8) {
                    Member m = new Member(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3],
                            parts[4], parts[5], parts[6], Double.parseDouble(parts[7]));
                    if (parts.length >= 10) {
                        // Use reflection or just public methods to set progress and attendance if we can
                        // Since there's no setAttendanceCount, we'll have to add it to Member, or just updateProgress
                        m.updateProgress(Integer.parseInt(parts[9]));
                        // We will add setAttendanceCount to Member.java next
                        m.setAttendanceCount(Integer.parseInt(parts[8]));
                    }
                    members.add(m);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading members: " + e.getMessage());
        }
        return members;
    }

    // --- SCHEDULES ---
    public static void saveSchedules(String fileName, List<WorkoutSchedule> schedules) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (WorkoutSchedule s : schedules) {
                // scheduleId,memberName,trainerName,workout,date,progress
                writer.println(s.getScheduleId() + "," + s.getMemberName() + "," + s.getTrainerName() + "," +
                        s.getWorkout() + "," + s.getDate() + "," + s.getProgress());
            }
        } catch (IOException e) {
            System.out.println("Error saving schedules: " + e.getMessage());
        }
    }

    public static ArrayList<WorkoutSchedule> loadSchedules(String fileName) {
        ArrayList<WorkoutSchedule> schedules = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return schedules;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    WorkoutSchedule s = new WorkoutSchedule(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    if (parts.length >= 6) {
                        s.setProgress(Integer.parseInt(parts[5].replace("%", "").trim()));
                    }
                    schedules.add(s);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading schedules: " + e.getMessage());
        }
        return schedules;
    }

    // --- SUBSCRIPTIONS ---
    public static void saveSubscriptions(String fileName, List<SubscriptionPlan> plans) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (SubscriptionPlan p : plans) {
                writer.println(p.getPlanId() + "," + p.getPlanName() + "," + p.getPrice() + "," + p.getDurationInMonths());
            }
        } catch (IOException e) {
            System.out.println("Error saving subscriptions: " + e.getMessage());
        }
    }

    public static ArrayList<SubscriptionPlan> loadSubscriptions(String fileName) {
        ArrayList<SubscriptionPlan> plans = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return plans;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    SubscriptionPlan p = new SubscriptionPlan(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
                    plans.add(p);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading subscriptions: " + e.getMessage());
        }
        return plans;
    }

    // --- ATTENDANCE ---
    public static void saveAttendance(String fileName, List<Attendance> attendances) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Attendance a : attendances) {
                writer.println(a.getMemberId() + "," + a.getDate() + "," + a.isPresent());
            }
        } catch (IOException e) {
            System.out.println("Error saving attendance: " + e.getMessage());
        }
    }

    public static ArrayList<Attendance> loadAttendance(String fileName) {
        ArrayList<Attendance> attendances = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return attendances;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    Attendance a = new Attendance(Integer.parseInt(parts[0]), parts[1], Boolean.parseBoolean(parts[2]));
                    attendances.add(a);
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading attendance: " + e.getMessage());
        }
        return attendances;
    }
}