package adam.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

// JSR310 JPA jest w stanie przekonwertować czas podany w bazie na nowoczesną klasę LocalTime
@EntityScan(
        basePackageClasses = {ReservationApplication.class, Jsr310Converters.class}
)
@SpringBootApplication
public class ReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }

}
