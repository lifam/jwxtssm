package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.AddressInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressInfo {
	int addAddressInfo(AddressInfo addressInfo);
}
