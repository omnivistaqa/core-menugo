package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Created by itn0309 on 7/7/2017.
 */
@Entity
@Table(name = "Category")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "uuid")
public class Category {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "UID", length = 16)
    private UUID uuid;
    // @Column(columnDefinition = "NVARCHAR(MAX)")
    private String name;

    private String defaultImage;
    @OneToMany
    //@JsonBackReference(value = "listItem")
    private List<MenuItem> listItem = new ArrayList<MenuItem>();

    @ManyToOne
    private Provider provider;

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

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public List<MenuItem> getMenu() {
        return listItem;
    }

    public void setMenu(List<MenuItem> listItem) {
        this.listItem = listItem;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Category(UUID uuid, String name, String defaultImage) {
        this.uuid = uuid;
        this.name = name;
        this.defaultImage = defaultImage;
    }
    public Category() {

    }
}
