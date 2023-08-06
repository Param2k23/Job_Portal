package bean;

public class CompanyInfoBean {
	private int Company_id;
	private String Username , Password;
	private String About;
	private int Establishyear;
	private String Email;
	public int getCompany_id()
	{
		return Company_id;
	}
	public void setUser_id(int Company_id)
	{
		this.Company_id = Company_id;
	}
	public String getUsername()
	{
		return Username;
	}
	public void setUsername(String Username)
	{
		this.Username = Username;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String Password)
	{
		this.Password = Password;
	}
	public void setEmail(String Email)
	{
		this.Email = Email;
	}
	public String getEmail()
	{
		return Email;
	}
	public int getEstablishyear()
	{
		return Establishyear;
	}
	public void setEstablishyear(int Establishyear)
	{
		this.Establishyear = Establishyear;
	}
	public String getAbout()
	{
		return About;
	}
	public void setAbout(String About)
	{
		this.About = About;
	}
}
