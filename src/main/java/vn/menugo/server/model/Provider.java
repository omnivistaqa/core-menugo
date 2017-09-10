package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Created by itn0309 on 5/29/2017.
 */

/*
@NamedQuery(name = "Provider.findByName",
           query = "SELECT p FROM Provider p WHERE p.name = 'name'"
)
@NamedNativeQuery(name = "Provider.findByUuid”,
        query="SELECT * FROM Provider t WHERE t.title = 'title'",
        resultClass = Provider.class
)*/
@Entity
@Table(name = "Providers")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "uuid")
public class Provider {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "UID", length = 16)
    private UUID uuid;
    //@Column(columnDefinition = "NVARCHAR(MAX)")
    private String name;
    private String image;
    private String description;
    private String address;
    private String url;
    private String latitude;
    private String longitude;
    private String openHour;
    private String star;

    @OneToMany
    //@JsonBackReference(value = "menu")
    private List<MenuItem> menu = new ArrayList<MenuItem>();

    @OneToMany
    private List<Category> cat = new ArrayList<Category>();

    public Provider (){}

    public Provider(UUID uuid, String name, String image, String description, String address, String url, String latitude, String longitude, String openHour, String star) {
        this.uuid = uuid;
        this.name = name;
        this.image = image;
        this.description = description;
        this.address = address;
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
        this.openHour = openHour;
        this.star = star;
    }

    public Provider(UUID uuid, String name, String image, String description, String address, String url, String latitude, String longitude, String openHour, String star, List<MenuItem> menu, List<Category> cat) {
        this.uuid = uuid;
        this.name = name;
        this.image = image;
        this.description = description;
        this.address = address;
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
        this.openHour = openHour;
        this.star = star;
        this.menu = menu;
        this.cat = cat;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public List<Category> getCat() {
        return cat;
    }

    public void setCat(List<Category> cat) {
        this.cat = cat;
    }
}
