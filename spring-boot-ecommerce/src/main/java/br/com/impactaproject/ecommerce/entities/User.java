package br.com.impactaproject.ecommerce.entities;

import br.com.impactaproject.ecommerce.entities.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_profiles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "profile")
    @Enumerated(EnumType.STRING)
    private Set<Profile> profile = new HashSet<>();
    private Boolean membro;

    public Boolean isMembro() {
        return membro;
    }
}