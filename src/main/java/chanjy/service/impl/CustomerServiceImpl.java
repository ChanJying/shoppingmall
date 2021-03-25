package chanjy.service.impl;

import chanjy.mapper.CustomerMapper;
import chanjy.pojo.Address;
import chanjy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Address queryAddressByCustomerId(int customerId) {
        return customerMapper.queryAddressByCustomerId(customerId);
    }

    @Override
    public int insertAddress(Address address) {
        return customerMapper.insertAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return customerMapper.updateAddress(address);
    }
}
