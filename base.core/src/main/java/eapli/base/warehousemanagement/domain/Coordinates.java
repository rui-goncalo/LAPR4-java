package eapli.base.warehousemanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Coordinates implements AggregateRoot<Long> {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private int lSquare;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private int wSquare;

    public Coordinates(int lSquare, int wSquare) {
        this.lSquare = lSquare;
        this.wSquare = wSquare;
    }

    protected Coordinates() {
    }

    public Long getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public int getlSquare() {
        return lSquare;
    }

    public int getwSquare() {
        return wSquare;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "id=" + id +
                ", lSquare=" + lSquare +
                ", wSquare=" + wSquare +
                '}';
    }
}