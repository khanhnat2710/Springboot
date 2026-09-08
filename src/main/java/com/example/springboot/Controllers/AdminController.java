package com.example.springboot.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.Service.AdminService;
import com.example.springboot.entities.admin;

//Đánh dấu RestController: làm việc với Restful API, chỉ trả dữ liệu theo dạng JSON
@RestController
//Định nghĩa API
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    public AdminService adminService;

    //Phương thức lấy toàn bộ dữ liệu
    @GetMapping
    public List<admin> getAllAdmin() {
        return adminService.getAllAdmin();
    }

    //Phương thức lấy 1 bản ghi
    @GetMapping("/{id}")
    public admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    //Phương thức để thêm dữ liệu
    @PostMapping("/create")
    public String createAdmin(@RequestBody admin admin) {
        adminService.createAdmin(admin);
        return "Thêm admin thành công";
    }

    //Phương thức để sửa dữ liệu 
    @PutMapping("/{id}")
    public String updateAdmin(@PathVariable Long id, @RequestBody admin admin) {
        adminService.updateAdmin(id, admin);
        return "Sửa thành công";
    }

    //Phương thức để xóa dữ liệu
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Xóa thành công";
    }
}
