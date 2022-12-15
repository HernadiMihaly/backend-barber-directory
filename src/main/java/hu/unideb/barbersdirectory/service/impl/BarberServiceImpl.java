package hu.unideb.barbersdirectory.service.impl;

import hu.unideb.barbersdirectory.exceptionhandling.BarberNotFoundException;
import hu.unideb.barbersdirectory.model.Barber;
import hu.unideb.barbersdirectory.model.dto.BarberDTO;
import hu.unideb.barbersdirectory.repository.BarberRepository;
import hu.unideb.barbersdirectory.service.BarberService;
import hu.unideb.barbersdirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BarberServiceImpl implements BarberService {
    private final BarberRepository barberRepository;
    private final UserService userService;

    @Autowired
    public BarberServiceImpl(BarberRepository barberRepository, UserService userService) {
        this.barberRepository = barberRepository;
        this.userService = userService;
    }

    @Override
    public BarberDTO saveBarber(BarberDTO barberDTO) {
        Barber barberToAdd = getBarberFromDTO(barberDTO);
        Barber addedBarber = barberRepository.save(barberToAdd);

        return getBarberDTOFromBarber(addedBarber);
    }

    private Barber getBarberFromDTO(BarberDTO barberDTO) {
        return Barber.builder()
                .id(barberDTO.getId())
                .name(barberDTO.getName())
                .nickName(barberDTO.getNickName())
                .phoneNumber(barberDTO.getPhoneNumber())
                .instagramUsername(barberDTO.getInstagramUsername())
                .imageLink(barberDTO.getImageLink())
                .haircutPrice(barberDTO.getHaircutPrice())
                .addedDate(barberDTO.getAddedDate())
                .user(userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()))
                .build();
    }


    @Override
    public List<BarberDTO> findAllBarbers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Barber> barbers= barberRepository.findAllByUser_UserId(userService.getUserIdFromAuth(authentication));

        return getBarberDTOsFromBarbers(barbers);
    }

    private List<BarberDTO> getBarberDTOsFromBarbers(List<Barber> barbers){
        List<BarberDTO> barberDTOs = new ArrayList<>();

        barbers.forEach(barber -> barberDTOs.add(getBarberDTOFromBarber(barber)));

        return barberDTOs;
    }

    private BarberDTO getBarberDTOFromBarber(Barber barber){
       return BarberDTO.builder()
               .id(barber.getId())
               .name(barber.getName())
               .nickName(barber.getNickName())
               .phoneNumber(barber.getPhoneNumber())
               .instagramUsername(barber.getInstagramUsername())
               .imageLink(barber.getImageLink())
               .haircutPrice(barber.getHaircutPrice())
               .addedDate(barber.getAddedDate())
               .build();
    }



    @Override
    public BarberDTO findBarberById(Long id){
        Barber barber = barberRepository.findBarberById(id)
                .orElseThrow(() -> new BarberNotFoundException("Barber with id: " + id + " was not found, please search for another!"));
        return getBarberDTOFromBarber(barber);
    }

    @Override
    public BarberDTO updateBarber(BarberDTO barberDTO) {
        Barber barberToUpdate= getBarberFromDTO(barberDTO);
        Barber updatedBarber = barberRepository.save(barberToUpdate);

        return getBarberDTOFromBarber(updatedBarber);
    }

    @Override
    @Transactional
    public void deleteBarber(Long id) {
        barberRepository.deleteBarberById(id);
    }
}
