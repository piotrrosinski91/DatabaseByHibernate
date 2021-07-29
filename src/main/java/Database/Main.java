package Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... arg){
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);

        User someUser = getUser();

        userRepository.save(someUser);

        List<User> users2 = userRepository.findAll();
        users2.forEach(System.out::println);

        List<User> findByUsername = userRepository.findByUsername("Kacper");
        findByUsername.forEach(System.out::println);

        List<User> findByUsernameContaining = userRepository.findByUsernameContaining("ek");
        findByUsernameContaining.forEach(System.out::println);

        List<User> findByAgeGreaterThan = userRepository.findByAgeGreaterThan(30);
        findByAgeGreaterThan.forEach(System.out::println);

        List<User> findByCity = userRepository.findByCity("Tychy");
        findByCity.forEach(System.out::println);
    }

    private User getUser(){
        return new User("Piotr Rosinski", 30, "Warszawa");
    }
}
