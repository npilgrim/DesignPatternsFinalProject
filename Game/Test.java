public class Test
{
	public static void main(String[] args) throws Exception
	{
		RandomNameGenerator rng = RandomNameGenerator.getGenerator();
		System.out.println(rng.randomName());
	}
}
