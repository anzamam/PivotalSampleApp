package com.anz.trsender.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anz.trsender.model.StepsTrack;
import com.anz.trsender.service.TrSenderService;

@RestController(value = "/services")
public class TrSenderApiController {

	private static final Logger log = LoggerFactory.getLogger(TrSenderApiController.class);
	
	@Autowired
	TrSenderService trSenderService;
	/*
	 * WHERE_IS_MY_FRIEND: Show top 1 record based on a criteria (ex: SenderID) using GET
	 */
	
	@RequestMapping(path="/v1/senderlog/{senderId}",method=RequestMethod.GET)
	public List<StepsTrack> getLogBySenderId(@PathVariable(value="senderId") String senderId){
		log.info("Called ::with senderID="+senderId);
		
		List<StepsTrack> objList=null;
		
		objList =  trSenderService.getObjectBySenderId(senderId);
		
		return objList;
	}
	
	/*
	 * HERE_I_AM: Insert a new record using POST
	 */
	@RequestMapping(path="/v1/senderlog",method=RequestMethod.POST)
	public Boolean saveSenderLogObject(@RequestBody StepsTrack stepsTrack){
		log.info("Called ::with saved="+stepsTrack);
		
		Boolean status=false;
		
		status =  trSenderService.saveObject(stepsTrack);
		
		return status;
	}
}
