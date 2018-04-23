
public  class Account implements Method{	//set Account info in this class
	private String name;
	private int age;
	private String gender;
	private String status=null;
	private String []couple=new String[1]; //create an array to store couple
	private String[] friends=new String[100];	//create an array to store friends
	private String[] parents=new String[100];	//create an array to store parents
	private String[] children=new String[100];  //create an array to store children
	private String[] colleague=new String[100]; //create an array to store colleague
	private String[] classmates=new String[100]; //create an array to store classmates
	Run run=new Run();
	
	public Account()	
	{
		
	}
	//set friends
	public void setFriends(String input)	
	{
		for(int i=0;i<friends.length;i++)
		{
		if(friends[i]==null)
		{
		this.friends[i]=new String(input);
		break;
		}
		}
	}
	//set parents
	public void setParents(String input)
	{
		for(int i=0;i<parents.length;i++)
		{
			if(parents[i]==null)
			{
				this.parents[i]=new String(input);
				break;
			}
		}
	}
	
	//set children 
	public void setChildren(String input)
	{
		for(int i=0;i<children.length;i++)
		{
			if(children[i]==null)
			{
				this.children[i]=new String(input);
				break;
			}
		}
	}
	//set colleagues
	public void setColleague(String input)
	{
		for(int i=0;i<colleague.length;i++)
		{
			if(colleague[i]==null)
			{
				this.colleague[i]=new String(input);
				break;
			}
		}
	}
	//set classmates
	public void setClassmats(String input)
	{
		for(int i=0;i<classmates.length;i++)
		{
			if(classmates[i]==null)
			{
				this.classmates[i]=new String(input);
				break;
			}
		}
	}
	
	
	//list all parents of the selected person
	public String[] listParents()
	{
		for(int i=0;i<parents.length;i++)
		{
			if(parents[i]!=null)
			{
				System.out.println(parents[i]);
			}
		}
		return parents;
	}
	
	//list all children
	public String[] listChildren()
	{
		for(int i=0;i<children.length;i++)
		{
			if(children[i]!=null)
			{
				System.out.println(children[i]);
			}
		}
		return children;
	}
	//list colleagues
	public String[] listColleagues()
	{
		for(int i=0;i<colleague.length;i++)
		{
			if(colleague[i]!=null)
			{
				System.out.println(colleague[i]);
			}
		}
		return colleague;
	}
	//list classmats
	public String[] listClassmates()
	{
		for(int i=0;i<classmates.length;i++)
		{
			if(classmates[i]!=null)
			{
				System.out.println(classmates[i]);
			}
		}
		return classmates;
	}
	//list all friends
		public String[] listFriends()
		{
			for(int i=0;i<friends.length;i++)
			{
				if(friends[i]!=null)
				{
				System.out.println(friends[i]);
				}
			}
			return friends;
		}
	
	public void setName(String name)	//set name
	{
		this.name=name;
	}
	public String getName()	//get account name
	{
		return name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}

	public void setCouple(String input) 
	{
		
		for(int i=0;i<children.length;i++)
		{
			if(couple[i]==null)
			{
				this.couple[i]=new String(input);
				break;
			}
		}
		
	}
	public String[] listCouple()
	{
		for(int i=0;i<couple.length;i++)
		{
			if(couple[i]!=null)
			{
				System.out.println(couple[i]);
			}
		}
		return couple;
	}
	public int getAge()
	{
		return age;
	}
	public void  getinfo()	//get account info and details
	{
		System.out.println("---- profile----");
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Gender: "+gender);
		System.out.println("Status: "+status);
	}
	public void setStatus(String status)	//set up status
	{
		this.status=status;
	}
	public String getStatus()
	{
		return status;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public String getGender()
	{
		return gender;
	}
	
}
