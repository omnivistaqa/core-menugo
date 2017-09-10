package vn.menugo.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.Repo.BillRepository;
import vn.menugo.server.model.Bill;

import java.util.UUID;

/**
 * Created by itn0309 on 8/3/2017.
 */
@Service
public class BillRepositoryService implements BillCrudService {

    private final BillRepository billRepository;

    @Autowired
    public BillRepositoryService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public void create(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Bill delete(UUID uuid) {
        return null;
    }

    @Override
    public Bill update(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill findByUuid(UUID uuid) {
        return billRepository.findByUuid(uuid);
    }
}
