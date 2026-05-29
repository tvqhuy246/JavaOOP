import models.*;
import services.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GymService gymService = new GymService();
        gymService.loadData();
        
        // Add default members if the list is empty (for first run)
        if (gymService.getMembers().isEmpty()) {
            Member huy = new Member(101, "HUYQUANG", "123", "HUY", "Active", "2026-05-01", "2026-06-01", 100);
            huy.updateProgress(95); 
            gymService.addMember(huy);
    
            Member luyen = new Member(102, "LuyenHuynh", "123", "Luyen", "Expired", "2026-03-01", "2026-04-01", 80);
            luyen.updateProgress(75);
            gymService.addMember(luyen);
        }

        System.out.println("===== LOGIN =====");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = AuthenticationService.login(username, password, gymService.getMembers());

        if (user == null) {
            System.out.println("Invalid username or password!");
            gymService.saveData(); // Save before exit
            return;
        }

        user.displayMenu();

        if(user instanceof Admin) {
            System.out.println("\nADMIN DASHBOARD");
            gymService.displayMembers();
            System.out.println("Revenue: $" + ReportService.calculateRevenue(gymService.getMembers()));
            System.out.println("Active Members: " + ReportService.countActiveMembers(gymService.getMembers()));
            
            System.out.print("\nDo you want to export the system report to CSV? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                ReportService.exportReportToCSV("data/reports.csv", gymService.getMembers());
            }
        }

        if(user instanceof Trainer) {
            System.out.println("\nTRAINER DASHBOARD");
            System.out.print("Enter member's username to update: ");
            String targetUser = scanner.nextLine();
            boolean found = false;

            for (Member m : gymService.getMembers()) {
                if (m.getUsername().equals(targetUser)) {
                    m.markAttendance("2026-05-25");
                    gymService.addAttendance(new Attendance(m.getId(), "2026-05-25", true));
                    m.updateProgress(100);
                    System.out.println("-> Attendance marked & Progress updated to 100% for " + m.getName());
                    
                    System.out.print("Assign new exercises for this member (e.g., Squats, Push-ups): ");
                    String exercises = scanner.nextLine();
                    WorkoutSchedule schedule = new WorkoutSchedule("WS1001", m.getUsername(), user.getName(), exercises, "2026-05-25");
                    gymService.addSchedule(schedule);
                    System.out.println("-> Schedule created: " + schedule.toString());

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Member not found in system.");
            }
        }

        if(user instanceof Member) {
            System.out.println("\nMEMBER DASHBOARD");
            Member member = (Member) user;
            System.out.println("Name: " + member.getName());
            System.out.println("Current Progress: " + member.getProgress() + "%");
            System.out.println("Reward: " + member.getReward());
        }

        gymService.saveData();
    }
}