package com.jwxtssm.dao;

import com.jwxtssm.entity.ScoreSum;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreSumDao {
	int addScoreSum(ScoreSum scoreSum);
}
