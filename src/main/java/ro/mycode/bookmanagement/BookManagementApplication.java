package ro.mycode.bookmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.bookmanagement.View.View;

@SpringBootApplication
public class BookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(View view) {
		return args -> {
			view.play();
		};
	}
}
