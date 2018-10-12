package io.core.setting.PlayerProfile;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.core.setting.PlayerProfile.PlayerProfileModel;

@Repository
public interface PlayerProfileRepository extends MongoRepository<PlayerProfileModel,String> , PlayerProfileRepositoryCustom{

			
}
