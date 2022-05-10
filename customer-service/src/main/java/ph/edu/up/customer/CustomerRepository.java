package ph.edu.up.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.edu.up.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
