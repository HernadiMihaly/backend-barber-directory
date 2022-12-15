package hu.unideb.barbersdirectory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BarberDTO {
    private Long id;

    private String name;

    private String nickName;

    private String phoneNumber;

    private String instagramUsername;

    private String imageLink;

    private Integer haircutPrice;

    private String addedDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
}
