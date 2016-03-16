public class ValuePair
{
	private int edibleCount;
	private int totalCount;

	//TODO
	public ValuePair(int edible, int total)
	{
	set(edible, total);	
	}



	/* Getters */
	public int getEdibleCount()
	{
		return edibleCount;
	}

	public int getTotalCount()
	{
		return totalCount;
	}



	/* Setters */

	public void set(int x, int y){
	
		this.edibleCount= x;
		this.totalCount = y;
	}
	public void setEdibleCount(int edibleCount)
	{
		this.edibleCount = edibleCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}
}
