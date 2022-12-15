package hu.unideb.barbersdirectory.service;

import hu.unideb.barbersdirectory.model.dto.BarberDTO;

import java.util.List;

public interface BarberService {
    BarberDTO saveBarber(BarberDTO barberDTO);
    List<BarberDTO> findAllBarbers();
    BarberDTO findBarberById(Long id) throws Throwable;
    BarberDTO updateBarber(BarberDTO barberDTO);
    void deleteBarber(Long id);
}
