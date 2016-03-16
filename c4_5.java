
import java.io.PrintWriter;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.HashMap;
public class c4_5
{
        ArrayList<ArrayList<String>> Mushrooms;

        ArrayList<ArrayList<String>> testMushrooms;
	Node root;
        String data;
        int num_trans, totalItems, support;
        List<String> allInfo;

        public void readMushrooms(InputStream in) throws Exception
        {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                Pattern p = Pattern.compile("\\s");
                String line;
                String[]  mushroom;
                String[] t;

                Mushrooms = new ArrayList<ArrayList<String>>();

                while ((line = reader.readLine()) != null)
                {
                        t = p.split(line);
                        mushroom  = new String[t.length];

                        for (int i=0; i<t.length; i++){
                               mushroom[i]= (t[i]);}
			ArrayList<String> n_mushroom = new ArrayList<String>();
			for(int i = 0; i <mushroom.length; i++){
			n_mushroom.add(mushroom[i]);	
			}
                        Mushrooms.add(n_mushroom);
                }

                reader.close();
        }
                public void readMushroomTest(InputStream in) throws Exception
        {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                Pattern p = Pattern.compile("\\s");
                String line;
                String[]  mushroom;
                String[] t;

                testMushrooms = new ArrayList<ArrayList<String>>();

                while ((line = reader.readLine()) != null)
                {
                        t = p.split(line);
                        mushroom  = new String[t.length];

                        for (int i=0; i<t.length; i++){
                               mushroom[i]= (t[i]);}
			ArrayList<String> n_mushroom = new ArrayList<String>();
			for(int i = 0; i <mushroom.length; i++){
			n_mushroom.add(mushroom[i]);	
			}
                        testMushrooms.add(n_mushroom);
                }

                reader.close();
        }



public void build(){
	root = new Node ( 0, null, Mushrooms, "");
	//System.out.println(root.n_itemList);
												/*uses a stack with an initiated root*/	
	Stack<Node> stack = new Stack<Node>();
	stack.push(root);

	root.setVisited(root);  /*boolean visited or not*/
	root.n_visited[0] = true;

	while( ! stack.empty()){
	Node place = stack.pop();
	boolean done = true;
	int e =0;
	int p = 0;
	for(int i = 0; i < place.n_itemList.size(); i++){
		if(place.n_itemList.get(i).get(0).equals("p")){  	/*checks if we need to continue  3 cases */
			p +=1;
			done= false;
			}
			else e+=1;
			}
			if(p == place.n_itemList.size()){
					place.finishCase = 2;
					
					continue;
			}

	if( ! done){
	
	place.child_column = place.findNext();
	
	if(place.child_column == -1){
		if(((double)e/(double)place.n_itemList.size())> .5)  // can't decide
					{place.finishCase = 1;}
				else  {place.finishCase= 2;}
	
			continue;
	}
	place.n_visited[place.child_column] = true;
	place.makeChildren();		
	for(int i =0; i < place.n_children.size(); i++){
		stack.push(place.n_children.get(i));	}


		}
		if(done)  place.finishCase = 1;
	
	
	}
}
	public void printInfo() throws Exception {
    	PrintWriter  output = new PrintWriter("/Users/robertlantry/Documents/cs378/project2/done.txt");
    	int correct =0;
    	for(ArrayList<String> x : testMushrooms){
    		Node hold = root;
    		while(hold.finishCase == 0){
    				for (Node n: hold.n_children) {
    					if(n.n_key.equals(x.get(hold.child_column))){
    						hold = n;
    				
    						}

    					}
    	
    			}
    			if (hold.finishCase == 1) {
    					if(x.get(0).equals("e")) {
    						correct +=1;
    						output.println(x.get(0) +"e");	}
    			}
    			if (hold.finishCase == 2) {
    					if(x.get(0).equals("p"))
    						 correct +=1;
    						output.println(x.get(0) + "p");	}


    			
    		 	

	}
	output.println(((double) correct/(double)testMushrooms.size()));
	output.close();
}


public static void main(String[] args) throws Exception {
        final String test = "/Users/robertlantry/Documents/cs378/project2/mushroom_test.txt";
        final String input   = "/Users/robertlantry/Documents/cs378/project2/mushroom_practice.txt";
        
        c4_5 c = new c4_5();
	   c.readMushrooms(new FileInputStream(input));
	   c.readMushroomTest(new FileInputStream(test));
	   c.build(); 
	 	c.printInfo();

        }


}

