package ec.ftt.model;

import java.util.Objects;

public class Password {

    private long id;
    private String name,
                   email,
                   password,
                   site;

    public Password() {

    }
    
    public Password(String id, String name, String email, String password, String site) {
		super();
		setId(id);
		setName(name);
		setEmail(email);
		setPassword(password);
		setSite(site);
	}
    
    public Password( String name, String email, String password, String site) {
		super();
		setName(name);
		setEmail(email);
		setPassword(password);
		setSite(site);
	}
	
	public Password(long id, String name, String email, String password, String site) {
		super();
		setId(id);
		setName(name);
		setEmail(email);
		setPassword(password);
		setSite(site);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setId(String id) {
        if (id.length()==0)
            setId(0);
        else
            setId(Long.valueOf(id));
    }
	
	@Override
	public String toString() {
		return "Password: [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", site=" + site + "]";
	}

}