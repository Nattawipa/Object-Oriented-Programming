import java.util.ArrayList;

public class Member 
{
	public String email;
	public String password;
	public ArrayList <Repository> repoList;
	
	Member (String email , String password)
	{
		repoList = new ArrayList<Repository>();
		this.email = email;
		this.password = password;
	}
	
	public boolean addRepository (Repository repo)
	{
		if(repo == null)
		{
			return false;
		}
		else 
		{
			repoList.add(repo);
			return true;
		}
	}
	
	public boolean removeRepository (Repository repo)
	{
		for(int i = 0 ; i < repoList.size() ; i++)
		{
			 if(repoList.get(i)==repo) 
			 {
				 System.out.println(repo.toString()+"is successfully removed.");
				 repoList.remove(i);
				 return true;
			 }
		}
		return false;
	}
	
	public void printMemberInfo()
	{
		System.out.println("Email: "+email+" (pwd: "+password+")" );
	}
}
