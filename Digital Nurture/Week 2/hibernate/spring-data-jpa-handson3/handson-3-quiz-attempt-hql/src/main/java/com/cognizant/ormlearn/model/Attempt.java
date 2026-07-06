package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @Column(name = "at_date")
    private LocalDate date;

    @OneToMany(mappedBy = "attempt")
    @OrderBy("id ASC")
    private Set<AttemptQuestion> attemptQuestionList = new LinkedHashSet<>();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Set<AttemptQuestion> getAttemptQuestionList() { return attemptQuestionList; }
    public void setAttemptQuestionList(Set<AttemptQuestion> attemptQuestionList) { this.attemptQuestionList = attemptQuestionList; }
}

