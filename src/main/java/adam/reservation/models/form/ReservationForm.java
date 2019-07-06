package adam.reservation.models.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class ReservationForm {


    @Getter
    @Setter
    @Size(min = 3, max = 20 , message = "{Size.ReservationForm.name}")
    @NotBlank(message = "{NotBlank.ReservationForm.name}")
    private String name;
    @Getter
    @Setter
    @Size(min = 3, max = 20, message = "{Size.ReservationForm.lastname}")
    @NotBlank(message = "{NotBlank.ReservationForm.lastname}")
    private String lastname;
    @Getter
    @Setter
    @NotBlank(message = "{NotBlank.ReservationForm.date}")
    @Pattern(regexp = "2[0-9]{3}-[0-9][0-9]-[0-9][0-9]", message = "{Pattern.ReservationForm.date}")
    private String date;
    @Getter
    @Setter
    @Size(min = 5, max = 50, message = "{Size.ReservationForm.adres}")
    @NotBlank(message = "{NotBlank.ReservationForm.adres}")
    private String adres;

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getFormatedDate() {
            return LocalDate.parse(date, format);
    }
}
