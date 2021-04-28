package com.j4ltechnologies.formation.spring.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe AbstractEntity, créée le 28/04/2021 à 11:31
 *
 * @author Joachim Zadi
 * @version 1.0 du 28/04/2021
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Version
    private int version;

    private LocalDateTime createdAt;

    @PrePersist
    private void init(){
        createdAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getCreatedAt() {
		return createdAt;
	}
}
