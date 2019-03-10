package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.ScoreSum;
import org.springframework.stereotype.Repository;

@Repository
public interface IScoreSum {
	int addScoreSum(ScoreSum scoreSum);
}
