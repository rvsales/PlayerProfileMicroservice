package io.core.setting.PlayerProfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.core.setting.PlayerProfile.PlayerProfileRepository;
import io.core.setting.PlayerProfile.PlayerProfileModel;
import io.core.setting.PlayerProfile.PlayerProfileException;
import io.core.setting.PlayerProfile.ErrorType;
import io.core.setting.PlayerProfile.ErrorModel;


@Service
public class PlayerProfileService {
	
	private static final String PLAYER_PROFLE_NOT_FOUND = "Player Profile does not exists for a given email!!";
	private static final String INVALID_PARAMETER = "Invalid Parameter!!";
	private static final String ERROR_DURING_UPDATE_PROCESS = "We could not confirm your update request, please try again :(";
	
	@Autowired
	PlayerProfileRepository playerProfileRepository;
	
	public List<PlayerProfileModel> getPlayerProfile(String email) throws PlayerProfileException{
		
		List<PlayerProfileModel> players = playerProfileRepository.findByEmail(email);
		
		if(!players.isEmpty()){
			
			 return players;
			
		} else {
				
		throw new PlayerProfileException(new ErrorModel(ErrorType.DATA.getTitle(), PLAYER_PROFLE_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
	
		}
	}
	

	public PlayerProfileModel savePlayerProfileModel(PlayerProfileModel entity) throws PlayerProfileException{
		
		if(entity == null) {

			throw new PlayerProfileException(new ErrorModel(ErrorType.BUSINESS.getTitle(), INVALID_PARAMETER, HttpStatus.BAD_REQUEST.value()));
		}
		
		PlayerProfileModel playerProfile = new PlayerProfileModel();
		
		try {
			
			playerProfile = playerProfileRepository.savePlayerProfileModel(entity);

			if(playerProfile==null) {

				throw new PlayerProfileException(new ErrorModel(ErrorType.DATA.getTitle(), ERROR_DURING_UPDATE_PROCESS, HttpStatus.NO_CONTENT.value()));
							
			}

		} catch (Exception e) {
		
			throw new PlayerProfileException(new ErrorModel(ErrorType.DATA.getTitle(), ERROR_DURING_UPDATE_PROCESS, HttpStatus.NO_CONTENT.value()));
		
		}
				
		return playerProfile;
		
	}

}