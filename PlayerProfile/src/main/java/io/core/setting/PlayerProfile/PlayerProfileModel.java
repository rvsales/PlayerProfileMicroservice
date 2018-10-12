package io.core.setting.PlayerProfile;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection = "playerProfile")
@AllArgsConstructor @NoArgsConstructor
public class PlayerProfileModel {

		@Id
		@Getter @Setter
		private String id; 	

		@Getter @Setter
		private String email;	

		@Getter @Setter
		private String firstName;	

		@Getter @Setter
		private String lastName;	

		@Getter @Setter
		private String gender;	

		@Getter @Setter
		private Date dob;	

		@Getter @Setter
		private Integer tennisStartAge;	

		@Getter @Setter
		private String preferredSurface;	

		@Getter @Setter
		private String playHand;	

		@Getter @Setter
		private String playDoubleHand;	

		@Getter @Setter
		private String category;	

		@Getter @Setter
		private String level;	

		@Getter @Setter
		private String gameType;	

		@Getter @Setter
		private String bio;
		
		@Override
		public String toString() {
		    return "playerProfile [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName 
		    		+ ", gender=" + gender + ", dob=" + dob + ", tennisStartAge=" + tennisStartAge + ", preferredSurface=" + preferredSurface 
		    		+ ", playHand=" + playHand + ", playDoubleHand=" + playDoubleHand + ", category=" + category + ", level=" + level 
		    		+ ", gameType=" + gameType + ", bio=" + bio + "]";
		}	

		   @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (o == null || getClass() != o.getClass()) return false;
		        PlayerProfileModel playerProfile = (PlayerProfileModel) o;
		        return Objects.equals(id, playerProfile.id);
		    }

		    @Override
		    public int hashCode() {
		        return Objects.hash(id);
		    }

}
