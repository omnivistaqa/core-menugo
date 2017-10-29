package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 8/1/2017.
 */
@Entity
@Table(name = "Bill")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "uuid")
public class Bill {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "UID", length = 16)
    private UUID uuid;
    private String type;
    private long price;
    private int status;
    private Date date;

    @ManyToOne
    private User user;

    @OneToMany(cascade=CascadeType.ALL,mappedBy = "bmiId.bill")
    //@ManytoMany
    //@JoinTable(name = "bill_item", joinColumns = @JoinColumn(name = "billID"), inverseJoinColumns = @JoinColumn(name = "ItemID"))
    private List<BillMenuItem> billMenuItem = new ArrayList<>();

    public List<BillMenuItem> getBillMenuItem() {
        return billMenuItem;
    }

    public void setBillMenuItem(List<BillMenuItem> billMenuItem) {
        this.billMenuItem = billMenuItem;
    }

    public Bill(UUID uuid, String type) {
        this.uuid = uuid;
        this.type = type;

    }

    public Bill(){}

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
