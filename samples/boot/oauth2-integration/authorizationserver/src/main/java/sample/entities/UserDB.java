package sample.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDB {
	@Id
	private String id;

	private String name;

	private String password;

	private String archive;

	private String role;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getArchive() {
		return archive;
	}

	public String getRole() {
		return role;
	}
}
