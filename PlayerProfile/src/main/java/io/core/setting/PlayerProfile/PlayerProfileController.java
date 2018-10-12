package io.core.setting.PlayerProfile;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/v1/PlayerProfile",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE) 
public class PlayerProfileController {

	@Autowired
	PlayerProfileService playerProfileSvc;
	
	@RequestMapping(value = "/getPlayerProfile", method = RequestMethod.POST)
	public List<PlayerProfileModel> getPlayerProfile( @Valid @RequestBody PlayerProfileModel playerProfile) {
		
		return  playerProfileSvc.getPlayerProfile(playerProfile.getEmail());
	}

	@RequestMapping(value = "/setPlayerProfile", method = RequestMethod.POST)
	public ResponseEntity <PlayerProfileModel> savePlayerProfile(@Valid @RequestBody PlayerProfileModel playerProfile) {
		
		return ResponseEntity.ok(playerProfileSvc.savePlayerProfileModel(playerProfile));
	}

	@ExceptionHandler({PlayerProfileException.class})
	public ResponseEntity <ErrorModel> handleException(PlayerProfileException e)
	{
		return new ResponseEntity<>(e.getError(), HttpStatus.valueOf(e.getError().getHttpStatus()));
		
	}
	
}