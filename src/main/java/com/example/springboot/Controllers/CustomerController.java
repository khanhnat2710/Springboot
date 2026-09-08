package com.example.springboot.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.Service.CustomerService;
import com.example.springboot.entities.customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @GetMapping
    public List<customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/create")
    public String createCustomer(@RequestBody customer customer) {
        customerService.createCustomer(customer);
        return "Thêm khách hàng thành công";
    }

    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody customer customer) {
        customerService.updateCustomer(id, customer);
        return "Sửa thành công";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Xóa thành công";
    }
}
