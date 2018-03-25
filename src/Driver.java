import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
	Run run=new Run();
	
	
	public void Menu() {//this is main page
		//print out menu
		System.out.println("MiniNet Menu");
		System.out.println();
		System.out.println("================================");
		System.out.println();
		System.out.println("1.List everyone");
		//select by name and show person profile,then you can update profile or delete person
		System.out.println("2.Select a person");
		//you can connect two person 
		System.out.println("3.Are these two direct friends?");
		System.out.println("4.Add a person into network");
		System.out.println("5.help");
		System.out.println("6.Exit");
		System.out.println();
		System.out.println();
		System.out.println("Enter an option:__");
	}
	//after choose menu 
	public void choose()
	{
		this.Menu();
		Scanner s= new Scanner(System.in);
		int num=s.nextInt();
		switch(num) {
		case 1://list all people
			System.out.println("Here are all of the people:");
			run.listArray();
			this.choose();
			break;
		case 2://select person
			System.out.println("enter the name you want to  search");
			Scanner s5=new Scanner(System.in);
			String name3=s5.nextLine();
			run.search(name3).getinfo();
			System.out.println("Children:");
			run.getAccByName(name3).listChildren();
			System.out.println("Friends:");
			run.getAccByName(name3).listFriends();
			System.out.println("Parents:");
			run.getAccByName(name3).listParents();
			this.choose2();
			
			break;
		case 3://are they friends?
			System.out.println("Enter the first person name: ");
			Scanner sa=new Scanner(System.in);
			String af=sa.nextLine();
			System.out.println("Enter the second person name: ");
			Scanner sa2=new Scanner(System.in);
			String af2=sa.nextLine();
			
			this.judgeFriends(run.getAccByName(af).listFriends(),af,af2);
			//there are a and b, if there are friends, they will exist in each other friend list
			this.choose();
			
			break;
		case 4://add people into network
			
			System.out.println("Enter name:__");
			Scanner s1=new Scanner(System.in);
			String name=s1.nextLine();
			run.createAccount(name);
			System.out.println("account is created.");
			System.out.println("enter age:_");
			Scanner s2=new Scanner(System.in);
			int age=s2.nextInt();
			run.getAccByName(name).setAge(age);
			System.out.println("age is "+run.getAccByName(name).getAge());
			
			
			System.out.println("set gender:_");
			Scanner s4=new Scanner(System.in);
			String gender=s4.nextLine();
			run.getAccByName(name).setGender(gender);
			System.out.println("set your status:__");
			Scanner s3=new Scanner(System.in);
			String status=s3.nextLine();
			run.getAccByName(name).setStatus(status);
			System.out.println("status is: "+run.getAccByName(name).getStatus());
			System.out.println("your account name is: "+run.getAccByName(name).getName());
			System.out.println("your account age is: "+run.getAccByName(name).getAge());
			System.out.println("your account gender is: "+run.getAccByName(name).getGender());
			System.out.println("your account status is: "+run.getAccByName(name).getStatus());
			System.out.println();
			//judge the age
			if(run.getAccByName(name).getAge()<16)
			{
				if(run.getAccByName(name).getAge()<=2)
				{
					System.out.println("you age is under the 2 years old");
					System.out.println("you cannot add any friend");
					//stop use edit relationship
					System.out.println("you must link two adults");
					System.out.println("These are all of people:");
					run.listArray();
					System.out.println("enter parents1 name: ");
					Scanner sp=new Scanner(System.in);
					String ap=sp.nextLine();
					run.getAccByName(name).setParents(ap);
					System.out.println("enter parents2 name: ");
					Scanner sp2=new Scanner(System.in);
					String ap2=sp2.nextLine();
					run.getAccByName(name).setParents(ap2);
					System.out.println("now, "+ap+" and "+ap2+" is the parent of "+name);
					this.choose();
				}
				else
				{
					System.out.println("your age is under the 16 years old");
					System.out.println("your must linked with two adults");
					//add two adults
					System.out.println("These are all of people:");
					run.listArray();
					System.out.println("enter parents1 name: ");
					Scanner sp=new Scanner(System.in);
					String ap=sp.nextLine();
					run.getAccByName(name).setParents(ap);
					System.out.println("enter parents2 name: ");
					Scanner sp2=new Scanner(System.in);
					String ap2=sp2.nextLine();
					run.getAccByName(name).setParents(ap2);
					System.out.println("now, "+ap+" and "+ap2+" is the parent of "+name);
					//do you want to add friends or back to the main page
					this.choice3();
				}
			}else
			{
			System.out.println("These are all of people:");
			run.listArray();
			this.choose2();//further decision
			break;
			}
		case 5://help
			System.out.println("you need choose an option,you can select or add person");
			System.out.println("you need create account in different name");
			this.choose();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("error, you need enter the number");
			this.choose();
			break;
		}
	}	
		
		
		//add friends or family 
		public void choose2()
		{
			
			System.out.println("enter your choice:");
			System.out.println("1.add friends");
			System.out.println("2.add child");
			System.out.println("3.add parents");
			System.out.println("4.list friends");
			System.out.println("5.back");
			Scanner s=new Scanner(System.in);
			int num=s.nextInt();
			switch(num)
			{
			case 1://add friends
				this.addFriends();//
				this.choose2();
				break;
			case 2://add child
				this.addChildren();
				this.choose2();
				break;
			case 3://add parent
				System.out.println();
				this.addParents();
				this.choose2();
				break;
			case 4://list his or her friends
				System.out.println("enter person name and show his friend list:");
				Scanner sf=new Scanner(System.in);
				String nf=sf.nextLine();
				System.out.println("--friend list--");
				run.getAccByName(nf).listFriends();
				this.choose();
				break;
			case 5://back
				this.choose();
				break;
			default:
				System.out.println("error,try again");
				this.choose2();
				break;
			}
		}
		//add friends
		//in this function we need to judge object's age 
		public void addFriends()
		{
//			System.out.println("Enter your name:__");
//			Scanner sa=new Scanner(System.in);
//			String an=sa.nextLine();
//			System.out.println("Enter the friend's name you want add: ");
//			Scanner sa2=new Scanner(System.in);
//			String an2=sa.nextLine();
//			run.getAccByName(an).setFriends(an2);	//add into friend
//			run.getAccByName(an2).setFriends(an);	//add into friend
//			System.out.println("now, "+an+" and "+an2+" are friends");
			this.choice3();
		}
		//add parents
		public void addParents()
		{
			System.out.println("Enter your name:_");
			Scanner sp=new Scanner(System.in);
			String ap=sp.nextLine();
			System.out.println("enter the Mom name:_");
			Scanner sp2=new Scanner(System.in);
			String ap2=sp2.nextLine();
			System.out.println("enter the Dad name:_");
			Scanner sp3=new Scanner(System.in);
			String ap3=sp3.nextLine();
			run.getAccByName(ap).setParents(ap2);	//add Mom name
			run.getAccByName(ap).setParents(ap3);	//add the Dad name
			System.out.println("now, "+ap2+" and "+ap3+" is the parents of "+ap);
		}
		//add children
		public void addChildren()
		{
			System.out.println("enter your name:__");
			Scanner sc=new Scanner(System.in);
			String ac=sc.nextLine();
			System.out.println("enter children name:__");
			Scanner sc2=new Scanner(System.in);
			String ac2=sc2.nextLine();
			run.getAccByName(ac).setChildren(ac2);  //add children
			System.out.println("now "+ac2+" is the child of "+ac);
		}
		
		public void judgeFriends(String arr1[],String name1,String name2)
		{
			for(int i=0;i<arr1.length;i++)
			{	
					if(arr1[i]==null)
					{
						break;
					}
					if(arr1[i].equals(name2))
					{
						System.out.println("they are direct friends");
						this.choose();
						break;
					}
			}//avoid null pointer exception
			System.out.println("they aren't direct friends");
			this.choose();
			
		}
		public void choice3()
		{
		System.out.println("enter your choice:");
		System.out.println("1.add friends 2.back to the main page");
		Scanner ch=new Scanner(System.in);
		int eh=ch.nextInt();
		switch(eh)
		{
		case 1:
			System.out.println("enter your name: ");
			Scanner sf=new Scanner(System.in);
			String af=sf.nextLine();
			System.out.println("enter friend's name: ");
			Scanner sf2=new Scanner(System.in);
			String af2=sf2.nextLine();
			//judge age
			int age1=run.getAccByName(af).getAge();
			int age2=run.getAccByName(af2).getAge();
			if(age1<16&&Math.abs(age1-age2)<=3)
			{
			run.getAccByName(af).setFriends(af2);
			this.choose();
			}else
			{
				System.out.println("you can't add ");
				System.out.println("because your friends must a teenager and your age gap must less than 3 ");
				this.choose();
			}
			break;
		case 2:
			this.choose();
			break;
		default:
			System.out.println("wrong choice, try again.");
			this.choice3();
			break;
		}
		}
}
