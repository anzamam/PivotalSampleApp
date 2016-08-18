package com.anz.trsender.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.anz.trsender.model.StepsTrack;

@Component
public class TrSenderLogDao {

	private static final Logger log = LoggerFactory.getLogger(TrSenderLogDao.class);

	@PersistenceContext(unitName = "persistentObject")
	private EntityManager dbEntityManager;

	@Transactional
	public List<StepsTrack> getIndexNameByDomain(String senderId) {
		log.info("Entering to creatingIndex method::::");
		String indexName = null;
		List<StepsTrack> objList = dbEntityManager.createNamedQuery("StepsTrack.findBySenderId", StepsTrack.class)
				.setParameter("senderId", senderId).getResultList();
		
		return objList;

	}
	
	@Transactional
	public Boolean saveStepTrack(StepsTrack stepsTrack) {
		log.info("Entering to creatingIndex method::::");
		Boolean status = false;
		try {
			dbEntityManager.persist(stepsTrack);
			status= true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;

	}

	
}
