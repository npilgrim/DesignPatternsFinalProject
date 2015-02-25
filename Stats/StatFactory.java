
public class StatFactory {
	private static StatC STATS;
	
	public static StatC getStats(){
		
		if(STATS ==null){
			STATS = new StatImp();
		}
		return STATS;
	}
}
