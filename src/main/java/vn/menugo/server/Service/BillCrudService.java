package vn.menugo.server.Service;

import vn.menugo.server.model.Bill;

import java.util.UUID;

/**
 * Created by itn0309 on 8/3/2017.
 */
public interface BillCrudService {
    void create(Bill cat);
    Bill delete(UUID uuid);
    Bill update(Bill cat);
}
