package ph.edu.up.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.edu.up.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
