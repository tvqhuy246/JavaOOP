package models;

public class Admin extends User {

    public Admin(int id, String username,
                 String password, String name) {

        super(id, username, password, name, "Admin");
    }

    @Override
    public void displayMenu() {

        System.out.println("\n===== ADMIN MENU =====");

        System.out.println("1. Add Member");
        System.out.println("2. Delete Member");
        System.out.println("3. Generate Reports");
        System.out.println("4. View Dashboard");
    }
}