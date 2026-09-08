package com.example.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repositories.CustomerRepository;
import com.example.springboot.entities.customer;

@Service
public class CustomerService {
    //Dối tượng giúp làm việc với db
    @Autowired
    public CustomerRepository customerRepository;

    //Phương thức lấy tất cả bản ghi
    public List<customer> getAllCustomer() {
        return customerRepository.findAll();
    }
    //Phương thức lấy 1 bản ghi theo id
    public customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Không có khách hàng phù hợp"));
    }
    //Phương thức lưu dữ liệu
    public customer createCustomer(customer customer) {
        return customerRepository.save(customer);
    }

    //phương thức sửa dữ liệu
    public customer updateCustomer(Long id, customer customer) {
        customer existingCustomer = this.getCustomerById(id);
        existingCustomer.setFullName(customer.getFullName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());
        return customerRepository.save(existingCustomer);
    }

    //Phương thức xóa dữ liệu
    public customer deleteCustomer(Long id) {
        customer existingCustomer = this.getCustomerById(id);
        customerRepository.deleteById(id);
        return existingCustomer;
    }
}
