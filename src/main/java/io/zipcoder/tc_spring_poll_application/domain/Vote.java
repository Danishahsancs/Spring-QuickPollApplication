package io.zipcoder.tc_spring_poll_application.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VOTE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    private Option option;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for option
    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
