package io.core.setting.PlayerProfile;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfileRepositoryCustom {
	
	List<PlayerProfileModel> findByEmail(String email);	
	
	PlayerProfileModel getPlayerProfileModel(String id);
	
	PlayerProfileModel savePlayerProfileModel(PlayerProfileModel entity);
}
