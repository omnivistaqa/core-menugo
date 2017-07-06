package vn.menogo.server.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Created by itn0309 on 5/29/2017.
 */
@Entity
/*
@NamedQuery(name = "Provider.findByName",
           query = "SELECT p FROM Provider p WHERE p.name = 'name'"
)
@NamedNativeQuery(name = "Provider.findByUuid”,
        query="SELECT * FROM Provider t WHERE t.title = 'title'",
        resultClass = Provider.class
)*/
@Table(name = "Providers")
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
    private String gps;
    private String openHour;
    private String star;

    public Provider (){}

    public Provider(UUID uuid, String name, String image, String description, String address, String url, String gps, String openHour, String star) {
        this.uuid = uuid;
        this.name = name;
        this.image = image;
        this.description = description;
        this.address = address;
        this.url = url;
        this.gps = gps;
        this.openHour = openHour;
        this.star = star;
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

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
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
}
