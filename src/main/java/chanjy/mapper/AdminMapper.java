package chanjy.mapper;


import chanjy.pojo.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    Admin selectAdmin(Admin admin);
}