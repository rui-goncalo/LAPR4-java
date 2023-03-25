package eapli.base.warehousemanagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.base.ordermanagement.domain.NewOrder;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class AGVDock implements AggregateRoot<String> {
    @Version
    private Long version;

    @Id
    private String id;

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

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private String description;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private String agvModel;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private float carryWeight;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private float maxWeight;

    @XmlElement
    @JsonProperty
    @OneToOne
    private Coordinates baseLocation;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private String state;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private int currentPosX;

    @XmlElement
    @JsonProperty
    @Column(nullable = false)
    private int currentPosY;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private NewOrder order;

    public AGVDock(String id, String accessibility, Coordinates begin, Coordinates end, Coordinates depth, String description, String agvModel, float carryWeight, float maxWeight, Coordinates baseLocation, String state, int currentPosX, int currentPosY) {
        this.id = id;
        this.accessibility = accessibility;
        this.begin = begin;
        this.end = end;
        this.depth = depth;
        this.description = description;
        this.agvModel = agvModel;
        this.carryWeight = carryWeight;
        this.maxWeight = maxWeight;
        this.baseLocation = baseLocation;
        this.state = state;
        this.currentPosX = currentPosX;
        this.currentPosY = currentPosY;
    }

    public AGVDock(String id, String accessibility, Coordinates begin, Coordinates end, Coordinates depth, String description, String agvModel, float carryWeight, float maxWeight, Coordinates baseLocation, String state, NewOrder order) {
        this.id = id;
        this.accessibility = accessibility;
        this.begin = begin;
        this.end = end;
        this.depth = depth;
        this.description = description;
        this.agvModel = agvModel;
        this.carryWeight = carryWeight;
        this.maxWeight = maxWeight;
        this.baseLocation = baseLocation;
        this.state = state;
        this.order = order;
    }

    protected AGVDock() {
    }

    public Long getVersion() {
        return version;
    }

    public String getId() {
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

    public String getDescription() {
        return description;
    }

    public String getAgvModel() {
        return agvModel;
    }

    public float getCarryWeight() {
        return carryWeight;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public Coordinates getBaseLocation() {
        return baseLocation;
    }

    public String getState() {
        return state;
    }

    public int getCurrentPosX() {
        return currentPosX;
    }

    public int getCurrentPosY() {
        return currentPosY;
    }

    public NewOrder getOrder() {
        return order;
    }

    public void setOrder(NewOrder order) {
        this.order = order;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return this.id;
    }
}