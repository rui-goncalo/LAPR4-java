package eapli.base.warehousemanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class WRow implements AggregateRoot<Long> {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private int shelves;

    @XmlElement
    @JsonProperty
    @OneToOne(fetch = FetchType.EAGER)
    private Coordinates begin;

    @XmlElement
    @JsonProperty
    @OneToOne(fetch = FetchType.EAGER)
    private Coordinates end;

    public WRow(int shelves, Coordinates begin, Coordinates end) {
        this.shelves = shelves;
        this.begin = begin;
        this.end = end;
    }

    protected WRow() {
    }

    public Long getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public int getShelves() {
        return shelves;
    }

    public Coordinates getBegin() {
        return begin;
    }

    public Coordinates getEnd() {
        return end;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }
}