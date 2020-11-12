package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Section implements Serializable {
    private Long id;
    private Kanban kanban;
    String name;

    public String getName() {
        return name;
    }

    public Section(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section() {
    }

    public Section(Long id, Kanban kanban) {
        this.id = id;
        this.kanban = kanban;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Kanban getKanban() {
        return kanban;
    }

    public void setKanban(Kanban kanban) {
        this.kanban = kanban;
    }
}
