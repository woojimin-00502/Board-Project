package com.thehambiz.test.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDao {
	public Map<String, Object> selectNoticeInfo(Map<String, Object> params) throws Exception;


}
