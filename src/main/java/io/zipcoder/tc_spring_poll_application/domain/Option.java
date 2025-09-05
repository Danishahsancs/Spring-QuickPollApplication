package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OPTION_ID")
    private Long id;

    @Column(name = "OPTION_VALUE")
    private String value;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for value
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
