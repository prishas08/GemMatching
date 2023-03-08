public class Gem
{	
	GemType type;
	int points;
	
	public Gem()
	{
		//need to fix random method
		this(GemType.getRandomType(), ((int)Math.random()*10) * 5);
	}
	
	public Gem(GemType type, int points)
	{
		this.type = type;
		this.points = points;
	}
	
	public String toString()
	{
		return type + " " + points;
	}
	
	public GemType getType()
	{
		return this.type;
	}
	
	public int getPoints()
	{
		return this.points;
	}
	
	public void draw(double x, double y)
	{
		StdDraw.picture(x, y, this.type.getFileName());
	}
	
	enum GemType
	{
		GREEN ("gem_green.png"), 
		BLUE ("gem_blue.png"), 
		ORANGE ("gem_orange.png");

		private String fileName;
		
		private GemType(String fileName) {
			
			this.fileName = fileName;
		} 
		
		public static GemType getRandomType()
		{
			return values()[(int) (Math.random() * GemType.values().length)];
		}
		
		public String getFileName()
		{
			return fileName;
		}
		
		
	}
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
	
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
