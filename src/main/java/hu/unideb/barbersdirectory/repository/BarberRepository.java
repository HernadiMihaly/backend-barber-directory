package hu.unideb.barbersdirectory.repository;

import hu.unideb.barbersdirectory.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Long> {
    void deleteBarberById(Long id);
    Optional<Barber> findBarberById(Long id);
    List<Barber> findAllByUser_UserId(Long id);
}
