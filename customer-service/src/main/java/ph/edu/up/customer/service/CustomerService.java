package ph.edu.up.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.customer.model.Customer;
import ph.edu.up.customer.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    public List<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }

}
