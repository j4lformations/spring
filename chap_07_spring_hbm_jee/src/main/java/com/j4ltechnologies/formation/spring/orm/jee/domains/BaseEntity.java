package com.j4ltechnologies.formation.spring.orm.jee.domains;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe BaseEntity, créée le 29/04/2021 à 12:24
 *
 * @author Joachim Zadi
 * @version 1.0 du 29/04/2021
 */
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Getter
    @Version
    int version;

    @Getter
    @Setter
    LocalDateTime createdAt;

}
