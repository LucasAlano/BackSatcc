package com.satc.com.satc.Model;

import javax.persistence.*;

@MappedSuperclass
public abstract class EntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    /**Getter**/
    public Long getId() {
        return id;
    }

    /**Setter**/
    public void setId(Long id) {
        this.id = id;
    }
}
