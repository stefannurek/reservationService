package adam.reservation.controllers;

import adam.reservation.models.ReservationModel;
import adam.reservation.models.form.ReservationForm;
import adam.reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reservationForm", new ReservationForm());
        return "reservation";
    }


    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") ReservationForm form) {
        reservationRepository.save(new ReservationModel(form));
        return "reservation";
    }

}
