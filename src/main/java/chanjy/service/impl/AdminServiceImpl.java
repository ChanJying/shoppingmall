package chanjy.service.impl;

import chanjy.mapper.AdminMapper;
import chanjy.pojo.Admin;
import chanjy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public int deleteAdmin(int id) {
        return adminMapper.deleteAdmin(id);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public Admin selectAdmin(String account,String password) {
        return adminMapper.selectAdmin(account,password);
    }

    public List<Admin> selectAdminByRole(){
        return adminMapper.selectAdminByRole();
    }
}
