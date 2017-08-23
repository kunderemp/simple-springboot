package id.kunderemp.controller;

import id.kunderemp.rest.request.SimpleRequest;
import id.kunderemp.rest.response.GeneralResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



//@CrossOrigin
@RestController
public class SimpleController {
	
	static Logger log = LogManager.getLogger(SimpleController.class);
	
	@RequestMapping(value="/postWithoutRequest",  consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<GeneralResponse<String>> postWithoutRequest(
			@RequestBody SimpleRequest request
			)
	{
		log.debug("SimpleController.postWithoutRequest()");
		GeneralResponse<String> generalResponse = new GeneralResponse<String>();
		generalResponse.setData("output data");
		generalResponse.setStatus("SUCCESS");
		return new ResponseEntity<GeneralResponse<String>>(generalResponse, HttpStatus.OK);
	}

}
