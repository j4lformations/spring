package com.j4ltechnologies.formation.spring.orm.jee.domains;

import com.j4ltechnologies.formation.spring.orm.jee.utils.AppUtils;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Auteur, créée le 29/04/2021 à 11:56
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"email"}, callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Auteur extends BaseEntity {

    @NonNull
    @Column(unique = true)
    String email;

    @NonNull
    @Column(nullable = false)
    String prenom;

    @NonNull
    @Column(nullable = false)
    String nom;

    @NonNull
    LocalDate ddn;

    @Transient
    int age;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Livre> livres;

    public void addLivre(Livre livre) {
        if (livres == null) {
            livres = new ArrayList<>();
        }
        if (!livres.contains(livre)) {
            livres.add(livre);
        }
    }

    @PrePersist
    private void beforePersist() {
        setCreatedAt(LocalDateTime.now());
        email = email.trim().toLowerCase();
        prenom = AppUtils.capitalize(prenom);
        nom = nom.trim().toUpperCase();
    }

    @PostLoad
    private void postLoad() {
        age = AppUtils.calculeAge(ddn);
    }
}
