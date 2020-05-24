
public class FreeMember extends Member
{
	FreeMember(String email, String password) 
	{
		super(email, password);
		// TODO Auto-generated constructor stub
		FREE_PRIVATE_REPOS = 3 ;
		numPrivateRepo = 0 ;
	}
	
	public int FREE_PRIVATE_REPOS;
	public int numPrivateRepo;
	
	public boolean addRepository (Repository repo)
	{
		if (repo.isPrivate()) 
		{
			if(numPrivateRepo == 3)
			{
				System.out.println(repo.toString()+" cannot be added because the number of private repository is reaching the limit");
				return false;
			}
			else 
			{
				repoList.add(repo);
				numPrivateRepo++;
				return true;
			}
		}
		else 
		{
			repoList.add(repo);
			return true;
		}
	}
	
	public boolean removeRepository (Repository repo)
	{
		if (repo.isPrivate()) 
		{
			for(int i = 0 ; i < repoList.size();i++) 
			{
				System.out.println(repo.toString()+" is successfully removed.");
				repoList.remove(repo);
				numPrivateRepo--;
				return true;
			}
		}
		return false;
		
	}
	
	public void printMemberInfo() 
	{
		System.out.println("---- FREE MEMBER ----");
		System.out.println("Email: "+email+" (pwd: "+password+")" );
		System.out.println("List of repositories");
		 
		for(int i=0 ; i<repoList.size() ; i++)
		{
			System.out.println(repoList.get(i));
		}
	}
	
	public int getNumPrivateRepo()
	{
		return numPrivateRepo;
	}
	
}
