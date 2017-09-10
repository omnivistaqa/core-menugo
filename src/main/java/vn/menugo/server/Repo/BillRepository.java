package vn.menugo.server.Repo;

import org.springframework.data.repository.Repository;
import vn.menugo.server.model.Bill;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 8/3/2017.
 */
public interface BillRepository extends Repository<Bill, UUID> {
    Bill findByUuid(UUID uuid);
    List<Bill> findAll();
    Bill save(Bill name);
}
