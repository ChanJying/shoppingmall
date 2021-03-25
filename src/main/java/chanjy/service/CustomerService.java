package chanjy.service;


import chanjy.pojo.Address;

public interface CustomerService {

    Address queryAddressByCustomerId(int customerId);

    int insertAddress(Address address);

    int updateAddress(Address address);
}
