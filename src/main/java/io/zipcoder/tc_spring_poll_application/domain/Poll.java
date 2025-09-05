package io.zipcoder.tc_spring_poll_application.domain;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POLL_ID")
    private Long id;

    @Column(name = "QUESTION")
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_ID")
    @OrderBy
    private Set<Option> options;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for question
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter and Setter for options
    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }
}
