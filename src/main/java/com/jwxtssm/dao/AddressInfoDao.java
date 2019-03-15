package com.jwxtssm.dao;

import com.jwxtssm.entity.AddressInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressInfoDao {
	int addAddressInfo(AddressInfo addressInfo);
	AddressInfo queryById(int addressId);
	AddressInfo[] queryByBasicId(int basicId);
}
