package ph.edu.up.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> retrieveAllCustomers() {
        return customerService.retrieveAllCustomers();
    }

    @PostMapping
    public void registerCustomer(@RequestBody Customer customer) {
        log.info("New customer registration {}", customer);
        customerService.registerCustomer(customer);
    }

}
