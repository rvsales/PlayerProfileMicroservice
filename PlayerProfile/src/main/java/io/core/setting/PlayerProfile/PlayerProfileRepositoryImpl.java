package io.core.setting.PlayerProfile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerProfileRepositoryImpl implements PlayerProfileRepositoryCustom {

	private final MongoTemplate mongoTemplate;
	 
	@Autowired
	public PlayerProfileRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<PlayerProfileModel> findByEmail(String email) {
		
		final Query query = new Query();
		
		final List<Criteria> criteria = new ArrayList<>();
		
		if(email != null) {
			criteria.add(Criteria.where("email").is(email));
		}	
		
		if(!criteria.isEmpty()) {
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		}
		
		return mongoTemplate.find(query, PlayerProfileModel.class);
		
	}

	@Override
	public PlayerProfileModel getPlayerProfileModel(String id) {

		final Query query = new Query();
		
		final List<Criteria> criteria = new ArrayList<>();
		
		if(id != null) {
			criteria.add(Criteria.where("id").regex(id));
		}	
		
		if(!criteria.isEmpty()) {
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		}
		
		return (PlayerProfileModel) mongoTemplate.find(query, PlayerProfileModel.class);
		
		
	}

	@Override
	public PlayerProfileModel savePlayerProfileModel(PlayerProfileModel entity) {
		
			mongoTemplate.save(entity);
			return entity;
		
	}

}
