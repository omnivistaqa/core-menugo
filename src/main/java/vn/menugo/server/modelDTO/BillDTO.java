package vn.menugo.server.modelDTO;

import java.util.Date;
import java.util.UUID;

/**
 * Created by itn0309 on 9/10/2017.
 */
public class BillDTO {

    private UUID uuid;
    private String type;
    private long price;
    private int status;
    private Date date;

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
