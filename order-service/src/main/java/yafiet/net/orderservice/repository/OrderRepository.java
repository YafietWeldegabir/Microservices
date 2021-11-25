package yafiet.net.orderservice.repository;

 import org.springframework.data.jpa.repository.JpaRepository;
import yafiet.net.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
