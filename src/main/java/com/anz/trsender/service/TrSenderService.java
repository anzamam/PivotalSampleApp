package com.anz.trsender.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.trsender.dao.TrSenderLogDao;
import com.anz.trsender.model.StepsTrack;

@Service
public class TrSenderService {

	private static final Logger log = LoggerFactory.getLogger (TrSenderService.class);

	
	
	@Autowired
	private TrSenderLogDao trSenderLogDao;
	


	public List<StepsTrack> getObjectBySenderId(String senderId) {
		return trSenderLogDao.getIndexNameByDomain(senderId);
	}

	
	public Boolean saveObject(StepsTrack stepsTrackObj){
		
		return trSenderLogDao.saveStepTrack(stepsTrackObj);
	}
	


}
