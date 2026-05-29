package services;

import models.Member;

import java.util.ArrayList;

public class ReportService {

    public static double calculateRevenue(
            ArrayList<Member> members) {

        double total = 0;

        for(Member member : members) {

            total += member.getAmountPaid();
        }

        return total;
    }

    public static int countActiveMembers(
            ArrayList<Member> members) {

        int count = 0;

        for(Member member : members) {

            if(member.getSubscriptionStatus()
                    .equals("Active")) {

                count++;
            }
        }

        return count;
    }

    public static Member topPerformer(
            ArrayList<Member> members) {

        Member top = members.get(0);

        for(Member member : members) {

            if(member.getProgress()
                    > top.getProgress()) {

                top = member;
            }
        }

        return top;
    }

    public static void exportReportToCSV(String fileName, ArrayList<Member> members) {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(fileName))) {
            writer.println("SYSTEM REPORT");
            writer.println("Total Revenue,$" + calculateRevenue(members));
            writer.println("Active Members," + countActiveMembers(members));
            
            Member top = topPerformer(members);
            if (top != null) {
                writer.println("Top Performer," + top.getName() + " (" + top.getProgress() + "%)");
            }
            
            writer.println("\n--- MEMBER DETAILS ---");
            writer.println("ID,Name,Status,Progress,AmountPaid,Reward");
            for (Member m : members) {
                writer.println(m.getId() + "," + m.getName() + "," + m.getSubscriptionStatus() + "," +
                        m.getProgress() + "%," + m.getAmountPaid() + "," + m.getReward());
            }
            
            System.out.println("Report successfully exported to " + fileName);
        } catch (Exception e) {
            System.out.println("Error exporting report: " + e.getMessage());
        }
    }
}