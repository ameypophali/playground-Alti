import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("playground.*,com.altemetric.*")
public class Application {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(Application.class, args);
	}
}

