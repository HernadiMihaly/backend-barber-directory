package hu.unideb.barbersdirectory.controller;

import hu.unideb.barbersdirectory.model.dto.BarberDTO;
import hu.unideb.barbersdirectory.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
public class ApplicationController {
    private final BarberService barberService;

    @Autowired
    public ApplicationController(BarberService barberService) {
        this.barberService = barberService;
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/barbers")
    public ResponseEntity<List<BarberDTO>> getAllBarbers(){
        List<BarberDTO> barbers = barberService.findAllBarbers();
        return new ResponseEntity<>(barbers, HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/barbers/{id}")
    public ResponseEntity<BarberDTO> getBarberById(@PathVariable("id") Long id) throws Throwable {
            BarberDTO barberDTO = barberService.findBarberById(id);
            return new ResponseEntity<>(barberDTO, HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200/")
    @PostMapping("/barbers")
    public ResponseEntity<BarberDTO> addBarber(@RequestBody BarberDTO barberDTO){
        BarberDTO addedBarberDTO = barberService.saveBarber(barberDTO);
        return new ResponseEntity<>(addedBarberDTO, HttpStatus.CREATED);
    }

    @CrossOrigin("http://localhost:4200/")
    @DeleteMapping("/barbers/{id}")
    public ResponseEntity<?> deleteBarber(@PathVariable("id") Long id){
        barberService.deleteBarber(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:4200/")
    @PutMapping("/barbers")
    public ResponseEntity<BarberDTO> updateBarber(@RequestBody BarberDTO barberDTO){
        BarberDTO updatedBarberDTO = barberService.updateBarber(barberDTO);
        return new ResponseEntity<>(updatedBarberDTO, HttpStatus.OK);
    }
}
