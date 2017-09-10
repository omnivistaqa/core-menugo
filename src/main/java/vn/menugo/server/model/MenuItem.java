package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by itn0309 on 5/29/2017.
 */
@Entity
@Table(name = "MenuItem")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "uuid")
public class MenuItem {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "UID", length = 16)
    private UUID uuid;
   // @Column(columnDefinition = "NVARCHAR(MAX)")
    private String name;

    private long price;
    //@Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;
    private String note;

    @ManyToOne
    //@JsonManagedReference(value = "provider")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Provider provider;

    @ManyToOne
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonManagedReference(value = "category")
    private Category category;

    public MenuItem(UUID uuid, String name, long price, String description, String note) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.description = description;
        this.note = note;
    }

    public MenuItem(){}

    public MenuItem(UUID uuid, String name, long price, String description, String note, Provider provider, Category category) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.description = description;
        this.note = note;
        this.provider = provider;
        this.category = category;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
