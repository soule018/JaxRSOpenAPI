package fr.istic.taa.jaxrs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Kanban implements Serializable {
    private Long id;
    private String name;
    private Collection<Section> listSection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Kanban() {
    }

    public Kanban(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Kanban(String name) {
        this.name = name;
    }

    public Kanban(Long id, Collection<Section> listSection) {
        this.id = id;
        this.listSection = listSection;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "kanban", cascade = CascadeType.PERSIST)
    public Collection<Section> getListSection() {
        return listSection;
    }

    public void setListSection(Collection<Section> listSection) {
        this.listSection = listSection;
    }
}
