

initiateTree()
 while ( ! stack.isEmpty)       // this hold unfinished nodes
 
    node= stack.pop  
    double attribute_info [];
    List<HashMap<key, ValuePair<key_edible_count, key_total_count>>> filter; // list of all attribute and attributes key in hashmap
    for( int i = 0; node.visitedAttributes) {       // this is possible attributes that can follow current node
         
          if(!visitedAttributes[i]) {
              double info = 0.0;
              for(int j =0; node.ListItems.size()){
              
                  if(!filter.get(i).containsKey( ListItems.get(j))){        // item[i] is the column
                    New ValuePair vp = new ValuePair<listItems.get(j), 0>
                    filter.get(i).put(ListItems.get(j), 
                    }
                    
                  updateKeyCount();       // change hashmap value pair based on key (item[j].get()
                  updateKeyEdibleCount();  // change edible count check item[j].get(column:0)
                }
                
                
                attribute_info[i] = calculateInfo(i);  // calculate the info from this attribute
           
            } // this is end of first for loop
              // now we have a List of HashMaps that contian their attribute's keys and edible counts and total count
              
              int childrenMaker = findAttribute(node.getInfo(), attribute_info);      // iterate through list 'filter'  find highest gain ratio
              
              createChildren(filter.get(childrenMaker);  // create child nodes update childNode visited and childNode.list
              }
}}
METHODS 
------
createChildren( int attributeNum){    // this might need to be in the method above because it might 
                                      //just take to many parameters to do it but i just wanted to seperate to look cleaner 
    List<List<String>> itemSeperator    //list of items organized by attribute key
    String[] numKeys = filter.KeySet(attributeNum).toArray;   // moved to set to array so that its easier to iterate with a number associated
      for( int i =0; in parentNode.ItemList){
            for( int j in NumKeys){                     // this iterates through the parent nodes' itemSet and looks for key's of that attribute
            if( itemList.get(i).get(attributeNum) = numKeys[j]){   //the key in the itemset is in the map use that number and add that item to the list of that number 
            itemSeperator.get(numKeys[j]).add(ItemList.get(i));}  
          }
      }
      Node.visted[attrributNum] = true;
    }  
    



--------

double calculateInfo(HashMap data) {
      double info = 0.0;
      for( key in data){
      ValuePair = map.get(key);
       info -= (valuepair.getEdible()/valuepair.getTotal) * math.log(base2) * (valuepair.getEdible()/valuepair.getTotal);
      }

return info
  }
  
  ----------
 int  findAttribute( Double parentInfo, Double [] allInfo){
 int best = 0;
 double max = 0.0;
      for( int i =0; i < allInfo.length){
         double split = parentInfo - allInfo[i]*parentInfo;
         split = split/allInfo
          if ( max < split){
                max = split;
                best = i;
                }
                return best;
 }
---------



Classes

------------
Class Node{
int columnNum;
boolean [] visited;
HashMap< K, ValuePair>;
double info;
Node parent;
}

--------------

Class ValuePair{
int edibleCount
int totalCount

Set_edibleCount()
Set_totalCount()

get_edibleCount()
get_totalCount()

}







