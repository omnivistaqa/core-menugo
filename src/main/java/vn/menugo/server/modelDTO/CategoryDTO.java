package vn.menugo.server.modelDTO;

import java.util.UUID;

/**
 * Created by itn0309 on 7/18/2017.
 */
public class CategoryDTO {

    private UUID uuid;
    private String name;
    private String defaultImage;

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
}
