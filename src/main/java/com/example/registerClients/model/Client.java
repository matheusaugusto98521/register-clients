package com.example.registerClients.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb-clients")
@Data
@NoArgsConstructor
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idClient")
    private UUID id;

    @Column(nullable = false, length = 100, name = "nameClient")
    private String name;

    @Column(nullable = false, unique = true)
    private String document;

    @Column(nullable = false)
    private String occupation;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    public void setBirthDate(String birthDate){
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        try{
            sfd.setLenient(false);
            this.birthDate = sfd.parse(birthDate);
        }catch (ParseException e){
            System.out.println("Data em formato errado!");
        }
    }
}
