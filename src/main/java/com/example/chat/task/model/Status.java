package com.example.chat.task.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity
@Table(name="status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private StatusName name;


    public Status() {
    }

    public Status(Long id) {
        this.id = id;
    }

    public Status(StatusName name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusName getName() {
        return name;
    }

    public void setName(StatusName name) {
        this.name = name;
    }
}
