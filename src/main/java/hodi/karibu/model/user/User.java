package hodi.karibu.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
	
	@Column(name = "BRANCH")
	private String branch;
	@Id
	@Column(name = "TELLER_ID")
	private String tellerID;
	@Column(name = "TELLER_NAME")
	private String tellerName;
	@Column(name = "TELLER_LEVEL")
	private String tellerLvl;
	@Column(name = "ROLE")
	private String role;

}
