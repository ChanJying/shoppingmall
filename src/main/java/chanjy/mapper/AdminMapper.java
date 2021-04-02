package chanjy.mapper;


import chanjy.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    Admin selectAdmin(@Param("account") String account,@Param("password") String password);

    List<Admin> selectAdminByRole();

   int updateAdmin (Admin admin);

   int deleteAdmin(int id);

   int insertAdmin(Admin admin);
}