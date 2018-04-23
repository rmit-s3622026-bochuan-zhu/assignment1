import java.util.Scanner;

public class Run {
	private Account[] accounts=new Account[100];//attribute 100 spaces in the array
	public void initialAccount()
	{
		//initial account
		//There are 4 accounts, Alice, Bob, Cindy and Don
		//Alice and Bob have a child named Cindy; Don is Alice and Bobs' common friend
		this.createAccount("Alice");
		this.getAccByName("Alice").setAge(40);
		this.createAccount("Bob");
		this.getAccByName("Bob").setAge(40);
		this.createAccount("Cindy");
		this.getAccByName("Cindy").setAge(10);
		this.createAccount("Don");
		this.getAccByName("Don").setAge(20);
		this.getAccByName("Cindy").setParents("Alice");
		this.getAccByName("Cindy").setParents("Bob");
		this.getAccByName("Alice").setFriends("Don");
		this.getAccByName("Bob").setFriends("Don");
		this.getAccByName("Alice").setChildren("Cindy");
		this.getAccByName("Bob").setChildren("Cindy");
	}
	public Account getAccByName(String name)
	{
		for(Account acc:accounts)
		{
			if(acc !=null&&name.equals(acc.getName()))
			{
				return acc;
			}
		}
		return null;
	}
	//list all of elements in the array
	public void listArray() {
		for(Account acc2:accounts)
		{
			if (acc2 !=null)
			{
				System.out.println(acc2.getName());
			}
		}
	}
			
	//create account
	public boolean createAccount(String name) {
		//check if it is exist
		Account acc = getAccByName(name);
		if(acc == null)
		{
			acc = new Account();
			acc.setName(name);
			
			for(int i=0;i<accounts.length;i++)
			{
				if(accounts[i] == null)
				{
					accounts[i] = acc;
					return true;
				}
			}
			//if account is full, there is an alarm
			return false;
		}else {
			//account exist, show the hint
			System.out.println("account is exist");
		}
		return false;
	}
	
	//search 
	public Account search(String name)
	{
		try {
		for(Account acc:accounts)
		{
			if(name.equals(acc.getName()))
			{
				System.out.println("name is found");
				return acc;
				
			}
			
		}
		}
		catch(Exception e) {
			System.out.println("error! name out found");
		}
		return null;
	}
		
}
