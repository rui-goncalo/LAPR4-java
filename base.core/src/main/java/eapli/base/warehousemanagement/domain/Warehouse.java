package eapli.base.warehousemanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Warehouse implements AggregateRoot<Long> {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private String name;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private float length;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private float width;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private float square;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private String unit;

    @XmlElementWrapper(name = "aisles")
    @XmlElement(name = "aisle")
    @JsonProperty
    @JoinColumn(name = "WAREHOUSE")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<WAisle> wAisles = new HashSet<>();

    @XmlElementWrapper(name = "agvdocks")
    @XmlElement(name = "agvdock")
    @JsonProperty
    @JoinColumn(name = "WAREHOUSE")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<AGVDock> agvDocks = new HashSet<>();

    public Warehouse(final String name, final float length, final float width, final float square, final String unit) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.square = square;
        this.unit = unit;
    }

    protected Warehouse() {
    }

    public Long getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getSquare() {
        return square;
    }

    public String getUnit() {
        return unit;
    }

    public Set<WAisle> getwAisles() {
        return wAisles;
    }

    public Set<AGVDock> getAgvDocks() {
        return agvDocks;
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