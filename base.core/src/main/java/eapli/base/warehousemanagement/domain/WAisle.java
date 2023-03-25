package eapli.base.warehousemanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WAisle implements AggregateRoot<Long> {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private String accessibility;

    @XmlElement
    @JsonProperty
    @OneToOne(fetch = FetchType.EAGER)
    private Coordinates begin;

    @XmlElement
    @JsonProperty
    @OneToOne(fetch = FetchType.EAGER)
    private Coordinates end;

    @XmlElement
    @JsonProperty
    @OneToOne(fetch = FetchType.EAGER)
    private Coordinates depth;

    @XmlElementWrapper(name = "rows")
    @XmlElement(name = "row")
    @JsonProperty
    @JoinColumn(name = "AISLE")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<WRow> wRows = new HashSet<>();

    public WAisle(String accessibility, Coordinates begin, Coordinates end, Coordinates depth) {
        this.accessibility = accessibility;
        this.begin = begin;
        this.end = end;
        this.depth = depth;
    }

    protected WAisle() {
    }

    public Long getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public Coordinates getBegin() {
        return begin;
    }

    public Coordinates getEnd() {
        return end;
    }

    public Coordinates getDepth() {
        return depth;
    }

    public Set<WRow> getwRows() {
        return wRows;
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