package com.example.demo.entityone;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "SAMPLEONE", name = "TABLE1")
public class Table1 implements Serializable {

    private static final long serialVersionUID = 746237126088051312L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 255, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}