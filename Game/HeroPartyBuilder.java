import java.util.*;

public class HeroPartyBuilder 
{
	private static HeroPartyBuilder builder = null;
	
	private Hero h1, h2, h3, h4;

	private HeroPartyBuilder() {} // stubbed out ctor
	
	public static HeroPartyBuilder getBuilder()
	{
		if(builder == null)
			builder = new HeroPartyBuilder();
		
		return builder;
	}
	
	public HeroPartyBuilder h1()
	{
		this.h1 = getHero();
		
		return this;
	}
	
	public HeroPartyBuilder h2()
	{
		this.h2 = getHero();
		
		return this;
	}
	
	public HeroPartyBuilder h3()
	{
		this.h3 = getHero();
		
		return this;
	}
	
	public HeroPartyBuilder h4()
	{
		this.h4 = getHero();
		
		return this;
	}
	
	public Party buildParty()
	{	
		return new Party(h1, h2, h3, h4);
	}
	
	public Hero getHero()
	{
		Hero h = null;
		int choice = -1;
		
		System.out.println("Please choose the type of hero you'd like:");
		System.out.println("\t[0] Jedi Master\n\t[1] Ranger of the North\n\t[2] Mage\n\t[3] Captain of the " +
				"starship Enterprise");
		while(choice < 0)
		{
			try
			{
				choice = Game.kb.nextInt();
				Game.kb.nextLine();
				if(choice < 0 || choice > 3)
					throw new InputMismatchException();
			}
			catch(InputMismatchException im)
			{
				System.out.println("Invalid choice. Try again.");
			}
		}
		
		switch(choice)
		{
			case 0:
				h = new Jedi();
				break;
			case 1:
				h = new Ranger();
				break;
			case 2:
				h = new Mage();
				break;
			case 3:
				h = new EnterpriseCaptain();
				break;
		}
		
		System.out.println("Enter the name of this hero: ");
		h.setName(Game.kb.nextLine());
		
		return h;
	}

}
