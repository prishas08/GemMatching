
public class GemList 
{
	MyLinkedList<Gem> gemList = new MyLinkedList<Gem>();

	
	public int size()
	{
		return gemList.size();
	}
	
	public void draw(double y)
	{
		double x = 0.0;
		for(int i = 0; i < gemList.size(); i++)
		{
			gemList.get(i).draw(x, y);
			x+= 0.625;
		}
	}
	
	public String toString()
	{
		if(gemList.size()==0)
		{
			return "None";
		}
		String s = gemList.get(0).getType().toString();
		for(int i = 1; i < gemList.size(); i++)
		{
			s += " " + (gemList.get(i).getType().toString());
		}
		return s;
	}
	
	public void insertBefore(Gem gem, int index)
	{
		if(gemList.size()==0)
		{
			gemList.add(gem, 0);
		}
		else if(index >= gemList.size())
		{
			gemList.add(gem, gemList.size());
		}
		else
		{
			gemList.add(gem, index);
		}
	}
	
	public int score()
	{
		int score = 0;
		if(gemList.size()==0)
		{
			score = 0;
		}
		if(gemList.size()==1)
		{
			score = gemList.get(0).getPoints();
		}
		else
		{
			for(int i = 0; i < gemList.size(); i++)
			{
				 int currentPoints = gemList.get(i).getPoints();
				 int counter = 1;
				 while(true)
				 {
					 if(i==gemList.size()-1)
					 {
						 break;
					 }
					 if(gemList.get(i).getType() == gemList.get(i+1).getType())
					 {
						 currentPoints += gemList.get(i).getPoints();
						 counter++;
						 i++;
						 
					 }
					 else
					 {
						 break;
					 }
				 }
				 score += currentPoints * counter;
			}
		}
		return score;
	}
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(Gem.GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(Gem.GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(Gem.GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(Gem.GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(Gem.GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(Gem.GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
