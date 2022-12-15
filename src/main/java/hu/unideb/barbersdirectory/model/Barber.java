package hu.unideb.barbersdirectory.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "barber")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Barber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    @Column(name= "nick_name")
    private String nickName;
    @Column(name= "phone_number")
    private String phoneNumber;
    @Column(name= "instagram_username")
    private String instagramUsername;
    @Column(name= "image_link")
    private String imageLink;
    @Column(name= "haircut_price")
    private Integer haircutPrice;
    @Column(name= "added_date")
    private String addedDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
