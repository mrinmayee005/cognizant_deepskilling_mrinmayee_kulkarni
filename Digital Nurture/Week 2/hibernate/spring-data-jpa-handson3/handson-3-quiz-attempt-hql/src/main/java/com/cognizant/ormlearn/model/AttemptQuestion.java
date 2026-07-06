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
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "attempt_question")
public class AttemptQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "aq_at_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "aq_qu_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion")
    @OrderBy("id ASC")
    private Set<AttemptOption> attemptOptionList = new LinkedHashSet<>();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Attempt getAttempt() { return attempt; }
    public void setAttempt(Attempt attempt) { this.attempt = attempt; }
    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
    public Set<AttemptOption> getAttemptOptionList() { return attemptOptionList; }
    public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) { this.attemptOptionList = attemptOptionList; }
}

