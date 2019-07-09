package adam.reservation.controllers;

import adam.reservation.models.ReservationModel;
import adam.reservation.models.form.ReservationForm;
import adam.reservation.repositories.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;


@Controller
public class ReservationController {

    ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository){
        this.reservationRepository=reservationRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reservationForm", new ReservationForm());
        return "reservation";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form, BindingResult result, Model model) {

        if(result.hasErrors()){
            return "reservation";
        }else if (reservationRepository.existsByDateEquals(form.getFormatedDate())){
            model.addAttribute("error", "Ten dzien jest juz zajety");
            return "reservation";
        }
        reservationRepository.save(new ReservationModel(form));
        return "reservation";
    }

    @GetMapping("/showtable")
    public String showReservation(Model model){
        model.addAttribute("reservations", reservationRepository.findByDateBetween(LocalDate.now(),
                LocalDate.now().plusWeeks(1)));
        return "reservationtable";
    }

    @GetMapping("/showtableall")
    public String showReservation2(Model model){
        model.addAttribute("reservations2", reservationRepository.findAll());
        return "reservationtable2";
    }
}
