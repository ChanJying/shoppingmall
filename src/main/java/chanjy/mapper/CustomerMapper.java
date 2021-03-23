package chanjy.mapper;


import chanjy.pojo.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

    Customer queryCustomerByAccount(String account);

    int insertCustomer(Customer customer);


}
