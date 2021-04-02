package chanjy.service;

import chanjy.pojo.Admin;

import java.util.List;

public interface AdminService {
    Admin selectAdmin( String account,String password);

    List<Admin> selectAdminByRole();

    int updateAdmin (Admin admin);

    int deleteAdmin(int id);

    int insertAdmin(Admin admin);
}
