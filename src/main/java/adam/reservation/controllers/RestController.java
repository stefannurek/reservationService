package adam.reservation.controllers;

import adam.reservation.models.ReservationModel;
import adam.reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class RestController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping(value = "/rest/reservation", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity reservation() {
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/reservation/{lastname}", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity reservation(@PathVariable("lastname") String lastname) {
        return new ResponseEntity(reservationRepository.findByLastnameIgnoreCase(lastname), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/reservation", method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity reservation(@RequestBody ReservationModel model) {
        reservationRepository.save(model);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/reservation/{id}", method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity reservation(@PathVariable("id") int id) {
        reservationRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/reservation/{id}/{date}", method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity reservationDateChange(@PathVariable("id") int id,
                                                @PathVariable("date") String date) {
        ReservationModel model = reservationRepository.findById(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        model.setDate(LocalDate.from(formatter.parse(date)));
        reservationRepository.save(model);
        return new ResponseEntity(HttpStatus.OK);
    }
}
