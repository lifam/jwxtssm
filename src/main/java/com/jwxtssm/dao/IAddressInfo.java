package com.jwxtssm.dao;

import com.jwxtssm.pojo.AddressInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressInfo {
	int addAddressInfo(AddressInfo addressInfo);
}
