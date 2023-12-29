package com.thehambiz.test.svc;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thehambiz.test.dao.NoticeDao;

@Service
public class NoticeService {
	
	@Autowired
	NoticeDao noticeDao;
	
	public Map<String, Object> selectNoticeInfo(Map<String, Object> params) throws Exception {
		return noticeDao.selectNoticeInfo(params);
	}
	
	@PostConstruct
	public String test() {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			params = noticeDao.selectNoticeInfo(params);
			System.out.println("# test.params:"+params);
			
			return params.get("NOW").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return "";
	}

}


