import java.util.Random;

public class HeroPartyBuilder 
{
	private static HeroPartyBuilder builder = null;
	
	private Hero h1, h2, h3, h4;
	
	//TODO for testing
	private Random rand = new Random();

	private HeroPartyBuilder() {} // stubbed out ctor
	
	public static HeroPartyBuilder getBuilder()
	{
		if(builder == null)
			builder = new HeroPartyBuilder();
		
		return builder;
	}
	
// TODO refactor next 4 methods to get hero choice from user
	public HeroPartyBuilder h1()
	{
		this.h1 = new Hero();
		this.h1.setSpeed(rand.nextInt(11));
		this.h1.setName("Member 1");
		
		return this;
	}
	
	public HeroPartyBuilder h2()
	{
		this.h2 = new Hero();
		this.h2.setSpeed(rand.nextInt(11));
		this.h2.setName("Member 2");
		
		return this;
	}
	
	public HeroPartyBuilder h3()
	{
		this.h3 = new Hero();
		this.h3.setSpeed(rand.nextInt(11));
		this.h3.setName("Member 3");
		
		return this;
	}
	
	public HeroPartyBuilder h4()
	{
		this.h4 = new Hero();
		this.h4.setSpeed(rand.nextInt(11));
		this.h4.setName("Member 4");
		
		return this;
	}
	
	public Party buildParty()
	{	
		return new Party(h1, h2, h3, h4);
	}

}
