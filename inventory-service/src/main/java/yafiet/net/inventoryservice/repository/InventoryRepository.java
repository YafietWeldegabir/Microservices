package yafiet.net.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yafiet.net.inventoryservice.model.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findBySkuCode(String skuCode);
    List<Inventory> findAll();
}