package bean;

public class ProjectBean {
	int User_id;
	int Company_id;
	int Project_id;
	private String Project_status,Technology;
	int Amount;
	private String project_url;
	private String rate_type;
	private String Solution_url;
	private int Contract_Status;
	private String About;
	public int getUser_id()
	{
		return User_id;
	}
	public void setUser_id(int User_id)
	{
		this.User_id = User_id;
	}
	public int getCompany_id()
	{
		return Company_id;
	}
	public void setCompany_id(int Company_id)
	{
		this.Company_id = Company_id;
	}
	public int getProject_id()
	{
		return Project_id;
	}
	public void setProject_id(int Project_id)
	{
		this.Project_id = Project_id;
	}
	public String getProject_status()
	{
		return Project_status;
	}
	public void setProject_status(String Project_status)
	{
		this.Project_status = Project_status;
	}
	public int getAmount()
	{
		return Amount;
	}
	public void setAmount(int Amount)
	{
		this.Amount = Amount;
	}
	public String getTechnology()
	{
		return Technology;
	}
	public void setTechnology(String Technology)
	{
		this.Technology = Technology;
	}
	public String getProject_url()
	{
		return project_url;
	}
	public void setProject_url(String project_url)
	{
		this.project_url = project_url;
	}
	public String getrate_type()
	{
		return rate_type;
	}
	public void setrate_type(String rate_type)
	{
		this.rate_type = rate_type;
	}
	public String getSolution_url()
	{
		return Solution_url;
	}
	public void setSolution_url(String Solution_url)
	{
		this.Solution_url = Solution_url;
	}
	public int getContract_Status()
	{
		return Contract_Status;
	}
	public void setContract_Status(int Contract_Status)
	{
		this.Contract_Status = Contract_Status;
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
