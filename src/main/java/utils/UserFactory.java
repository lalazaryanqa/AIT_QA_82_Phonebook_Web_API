package utils;

import dto.User;
import net.datafaker.Faker;

public class UserFactory {
    static Faker faker = new Faker();

//    public static void main(String[] args) {
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        String fullName = faker.name().fullName();
//        String email = faker.internet().emailAddress();
//        System.out.println(firstName);
//        System.out.println(lastName);
//        System.out.println(fullName);
//        System.out.println(email);
//    }

    public static User positiveUser(){
        User user = User.builder()
                .username(faker.internet().emailAddress())
                .password("Qwerty143!")
                .build();
        return user;

//        User user1 =  new User();
//        User user2 = User.builder()
//                .username()
//                .password()
//                .build();
    }
}