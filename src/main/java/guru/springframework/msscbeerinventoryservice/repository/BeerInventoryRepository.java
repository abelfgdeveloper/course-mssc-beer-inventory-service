package guru.springframework.msscbeerinventoryservice.repository;

import guru.springframework.msscbeerinventoryservice.domain.BeerInventory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, String> {

  List<BeerInventory> findAllByBeerId(String beerId);
}
