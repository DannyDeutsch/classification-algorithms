import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Set;
import java.util.List;
public class Node
{
	public int n_column;
	public String n_key;
	public int child_column;
	public boolean[] n_visited;
	public HashMap<String, ValuePair> n_hm;
	public double n_info;
	public Node n_parent;
	public ArrayList<ArrayList<String>> n_itemList;
	public ArrayList<Node> n_children;
	public int finishCase;  // -1  guess     0: poison      1 = edible

	
	public Node(int column, Node dad, List<ArrayList<String>> items, String key)
	{	this.n_key = key;
		this.n_column = column;
		 setItems(items);
		this.n_hm = new HashMap<String, ValuePair>();
		this.n_hm = setHM(this.n_column, this. n_itemList);		//TODO
		setInfo();
	//	System.out.println(this.n_info);
		setParent(dad);
		//setVisited();	
		this.n_children = new ArrayList<Node> ();
		
		}
	
	public void setItems(List<ArrayList<String>> x) {
	ArrayList<ArrayList<String>> itemList = new ArrayList<ArrayList<String>>();
	this.n_itemList = itemList;		
	for(int i =0; i < x.size(); i++){
	     ArrayList<String> item = new ArrayList<String>();
	     this.n_itemList.add(item);
		for(int j = 0; j< x.get(i).size(); j++){
		String add = x.get(i).get(j);
		//System.out.println(this.n_itemList);
		//System.out.println(this.n_itemList.get(i));
		this.n_itemList.get(i).add(add);
			}
		}
	}

    public void makeChildren(){
	ArrayList<ArrayList<ArrayList<String>>> itemSeperator = new ArrayList<ArrayList<ArrayList<String>>> ();
	ArrayList<String> checker = new ArrayList<String>();
	if (this.child_column > 0) {
		
	
	for(int i = 0; i < this.n_itemList.size(); i++){
		//System.out.println(this.n_itemList.get(i).get(this.child_column) + "   " + this.child_column + "  "  + this.n_itemList.size());
		if(! checker.contains(this.n_itemList.get(i).get(this.child_column))){
			checker.add(this.n_itemList.get(i).get(this.child_column));	
				//System.out.println(this.n_itemList.get(i).get(this.child_column)   + "  " + this.child_column);
				}	
		}	
	
      for(int j = 0; j< checker.size(); j++){
	 ArrayList<ArrayList<String>> key_items = new ArrayList<ArrayList<String>>(); 
	for(int i = 0; i < this.n_itemList.size(); i++){

		if(checker.get(j).equals( this.n_itemList.get(i).get(this.child_column))){
		ArrayList<String> shroom = new ArrayList<String>();	
		for(int x = 0; x< this.n_itemList.get(i).size(); x++){
			shroom.add(this.n_itemList.get(i).get(x));	}
			 key_items.add(shroom);
		
			}	
	   	  	
	    }
		itemSeperator.add(key_items);
	}	
	for(int p = 0; p < itemSeperator.size(); p++){
		Node update =  new Node (this.child_column, this, itemSeperator.get(p), checker.get(p));
		update.n_visited = new boolean[this.n_visited.length];
		
			for(int v =0; v < this.n_visited.length; v++){
						update.n_visited[v] = this.n_visited[v];	
				//	System.out.println(update.n_visited[v]);
		}

		this.n_children.add(update);
		
		//System.out.println(this.n_children.get(p).n_hm);	
		}
	}
}


	public double entropy(HashMap<String, ValuePair> hm, Node parent){
		double gainNum = 0.0;
				      if(hm == null || parent == null){
				      	return Double.MAX_VALUE;  	}
        Set<String> x = hm.keySet();
        double ratio = 0.0;
        double ed_tot = 0.0;
		double non_ed_tot = 0.0;

	    for(String s: x){
               if(hm.get(s).getTotalCount() != 0){
                ratio = (double) hm.get(s).getTotalCount()/ (double)parent.n_itemList.size();
		ed_tot = ((double) (double) hm.get(s).getEdibleCount()/ (double) hm.get(s).getTotalCount());
		non_ed_tot = ((double)hm.get(s).getTotalCount() - (double) hm.get(s).getEdibleCount())/ ((double) hm.get(s).getTotalCount());
		//System.out.println( s + " " +ratio + "  " + non_ed_tot + "  " + ed_tot);
	
          
		         
                	
		gainNum += ( ratio * ( (-ed_tot * Math.log(2) * ed_tot) - (non_ed_tot * Math.log(2) * non_ed_tot)));
				}
					gainNum = parent.n_info - gainNum* parent.n_info;

				}
		
			return gainNum;}


	public int findNext(){
 	     int best = -1; 
	     double max = -  Double.MAX_VALUE;
	     double[] entropy = new double[this.n_visited.length];
	     ArrayList<HashMap<String, ValuePair>> hmList = new ArrayList<HashMap<String, ValuePair>>();
			//fill HashMap for specific attribute


// fill list hash map
   for(int i=0; i < this.n_visited.length; i++){
	HashMap<String, ValuePair> adding = new HashMap<String, ValuePair>();
	
	     
	      if(this.n_visited[i] == true){
	      	
	      	hmList.add(null);  
	      	
	      	continue;}

		 else if(this.n_visited[i] == false){
 	for(int j = 0; j < this.n_visited.length; j++){
			adding = setHM(j, this.n_itemList);

			hmList.add(adding);
                        			}
					}
				}

			

		for (int j = 0; j < entropy.length; j++){
				double gainNum = -Double.MAX_VALUE;
					if (this.n_visited[j]  == true) {
						entropy[j] = - Double.MAX_VALUE;
					}
					 if(this.n_visited[j] == false){
			entropy[j] = entropy(hmList.get(j), this);
				}
			
					if(max < entropy[j] ){
						max = entropy[j];
						best = j;
			
							
					}
					
			}
	   		
	

	return best;
	}

	public void setVisited(Node root){

		this.n_visited = new boolean[this.n_itemList.get(0).size()];
	for(int i =0; i < n_itemList.get(0).size(); i++){

			this.n_visited[i] = false;
			
			}
		
		 this.n_visited[0] = true; 
	}
	public void setInfo(){
		double info = 0.0;
		if(this.n_hm == null){
		 return;

		}
		Set<String> x = this.n_hm.keySet();
		double ratio = 0.0;
		for(String s: x){
		if(this.n_hm.get(s).getTotalCount() != 0){
		ratio = ((double)this.n_hm.get(s).getEdibleCount())/ ((double) this.n_hm.get(s).getTotalCount());
		
		info -= (ratio) * (ratio * Math.log(2));
			}
		}
		this.n_info = info;
	}



	public void setParent(Node dad){

		n_parent = dad;	}
	



	public HashMap<String, ValuePair> setHM(int column, ArrayList<ArrayList<String>> itemList){
	 	HashMap<String, ValuePair> hm = new HashMap<String, ValuePair>();
	     for(int i=0; i < itemList.size();i++){
		String enter = itemList.get(i).get(column);
		if(! hm.containsKey(enter)){
			int b = 0;
			ValuePair vp = new ValuePair(b,b);
			hm.put(enter, vp);
			}
		String n_key = itemList.get(i).get(column);
		String n_edible = (String)itemList.get(i).get(0);
		String edible = "e";
		int alter = hm.get(n_key).getEdibleCount();
		if(n_edible.equals( edible)){
			 alter += 1;
			}
			int alter2 = hm.get(n_key).getTotalCount() + 1;
			ValuePair x = hm.get(n_key);
			x.setTotalCount(alter2);
			x.setEdibleCount(alter);
			hm.put(n_key, x);
			
			}

return hm;
		}	







}

