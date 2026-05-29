package models;

public class Trainer extends User {

    public Trainer(int id, String username,
                   String password, String name) {

        super(id, username, password, name, "Trainer");
    }

    public void assignWorkout(Member member,
                              String workout) {

        System.out.println(
                "Workout assigned to "
                        + member.getName());

        System.out.println("Workout: " + workout);
    }

    @Override
    public void displayMenu() {

        System.out.println("\n===== TRAINER MENU =====");
        System.out.println("1. Assign Workout");
        System.out.println("2. Track Attendance");
        System.out.println("3. Update Progress");
    }
}