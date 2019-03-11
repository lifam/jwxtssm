package com.jwxtssm.dao;

import com.jwxtssm.entity.AttachDoc;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachDocDao {
	int addAttachDoc(AttachDoc attachDoc);
}
