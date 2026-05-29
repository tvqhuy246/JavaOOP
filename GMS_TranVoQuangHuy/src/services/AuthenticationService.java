package services;

import models.*;

public class AuthenticationService {

    public static User login(String username,
                             String password,
                             java.util.ArrayList<Member> members) {

        if(username.equals("admin")
                && password.equals("123")) {

            return new Admin(
                    1,
                    "huyadmin",
                    "123",
                    "System Admin");
        }

        if(username.equals("trainer")
                && password.equals("123")) {

            return new Trainer(
                    2,
                    "trainer",
                    "123",
                    "Meo Meo");
        }

        // Duyệt qua danh sách học viên (members) có trong hệ thống
        for (Member member : members) {
            if (member.getUsername().equals(username) && member.getPassword().equals(password)) {
                return member; // Trả về đúng member đăng nhập thành công
            }
        }

        return null; // Đăng nhập thất bại
    }
}