package tests.day05;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker_ {
    /*
        Test Data: username, password, URL, test environment, address etc...
        Where do you get your test data?
        BA- Business Analyst
        Test Lead
        Manual Tester
        Developer
        From database
        From API(documentation)
        Mock data(fake data) --> Java Faker
        (Java Faker creates data randomly)
     */

    @Test
    public void javaFakerTest(){

        // 1.step: Create Faker object
        Faker faker = new Faker();

        // 2.step: Create fake data
        // generating firstName
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        // generating lastName
        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        // generating username
        String username = faker.name().username();
        System.out.println("username = " + username);

        // generating title
        String title = faker.name().title();
        System.out.println("title = " + title);

        // generating fulladdress
        String fullAddress = faker.address().fullAddress();
        System.out.println("fullAddress = " + fullAddress);

        // generating phonenumber
        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println("phoneNumber = " + phoneNumber);

        // generating cellphone
        String cellPhone = faker.phoneNumber().cellPhone();
        System.out.println("cellPhone = " + cellPhone);

        // numberbetween
        int numberBetween = faker.number().numberBetween(1,5);
        System.out.println("numberBetween = " + numberBetween);

        System.out.println(faker.funnyName().name());
    }
}
