package com.example.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repositories.adminRepository;
import com.example.springboot.entities.admin;

@Service
public class AdminService {
    //Đối tượng giúp làm việc với DB
    @Autowired
    public adminRepository adminRepository;
    //Phương thức lấy tất cả bản ghi
    public List<admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    //Phương thức lấy 1 bản ghi theo id
    public admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Không có admin phù hợp"));
    }

    //Phương thức lưu dữ liệu
    public admin createAdmin(admin admin) {
        return adminRepository.save(admin);
    }

    //phương thức sửa dữ liệu
    public admin updateAdmin(Long id, admin admin) {
        admin existingAdmin = this.getAdminById(id);
        existingAdmin.setFullName(admin.getFullName());
        return adminRepository.save(existingAdmin);
    }

    //Phương thức xóa dữ liệu
    public admin deleteAdmin(Long id) {
        admin existingAdmin = this.getAdminById(id);
        adminRepository.deleteById(id);
        return existingAdmin;
    }
}
