package ph.edu.up.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ph.edu.up.customer.Customer;
import ph.edu.up.customer.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public void registerCustomer(Customer customer) {
        this.customerRepository.saveAndFlush(customer);
        Boolean isFraudster = restTemplate.getForObject(
                "http://localhost:8083/api/v1/fraud-check/{customerId}",
                Boolean.class,
                customer.getId()
        );

        if (isFraudster) {
            throw new IllegalStateException("Customer with customer id: " + customer.getId() + " is a fraudster");
        }
    }

    public List<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }

}
