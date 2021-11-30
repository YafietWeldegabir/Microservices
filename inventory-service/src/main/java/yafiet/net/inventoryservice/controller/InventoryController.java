package yafiet.net.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yafiet.net.inventoryservice.model.Inventory;
import yafiet.net.inventoryservice.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryRepository inventoryRepository;


    @GetMapping("/{skuCode}")
    Boolean isInStock(@PathVariable String skuCode) {
         Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException("Cannot Find Product by sku code " + skuCode));
        return inventory.getStock() > 0;
    }

    @GetMapping
    List<Inventory> stock(){
        return inventoryRepository.findAll();
    }
}

