package com.j4ltechnologies.formation.spring.orm.jee.domains;

import com.j4ltechnologies.formation.spring.orm.jee.utils.AppUtils;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe Livre, créée le 29/04/2021 à 12:16
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"isbn"}, callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Livre extends BaseEntity {

    @NonNull
    @Column(unique = true)
    String isbn;

    @NonNull
    String titre;

    @NonNull
    BigDecimal pu;

    @PrePersist
    private void beforePersist() {
        setCreatedAt(LocalDateTime.now());
        isbn=isbn.trim();
    }
}
