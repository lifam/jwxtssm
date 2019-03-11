package com.jwxtssm.dao;

import com.jwxtssm.pojo.ScoreSum;
import org.springframework.stereotype.Repository;

@Repository
public interface IScoreSum {
	int addScoreSum(ScoreSum scoreSum);
}
