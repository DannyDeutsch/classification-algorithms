

initiateTree()
 while (!stack.isEmpty)       // this hold unfinished nodes
 
    node= stack.pop  
    double attribute_info []; //information gain for each attribute
    List<HashMap<key, ValuePair<key_edible_count, key_total_count>>> filter; // list of all attribute and attributes key in hashmap
    
    for( int i = 0; node.visitedAttributes) // iterating thru attributes not yet visited (stored in node)
    {
          if(!visitedAttributes[i])
          {
              double info = 0.0;

              /* Populating edible_count and total_count */
              for(int j =0; node.ListItems.size())
              {
                  // If HM doesn't have this item, put it in there with ValuePair(0,0)
                  if(!filter.get(i).containsKey( ListItems.get(j)))
                  {        // item[i] is the column
                    New ValuePair vp = new ValuePair<listItems.get(j), 0>
                    filter.get(i).put(ListItems.get(j), 
                  }
                    
                  ValuePair.setEdibleCount(getEdibleCount()++);        // change hashmap value pair based on key (item[j].get()
                  ValuePair.setTotalCount(getTotalCount++);  // change edible count check item[j].get(column:0)
                }
                
                
                // calculate the info from this attribute
                attribute_info[i] = calculateInfo(i);
           
            }
              // now we have a List of HashMaps that contian their attribute's keys and edible counts and total count
              
              // iterate through list 'filter' to find highest gain ratio
              int childrenMaker = findAttribute(node.getInfo(), attribute_info);
              
              // create child nodes update childNode visited and childNode.list
              createChildren(filter.get(childrenMaker);
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
    





double calculateInfo(HashMap data) {
      double info = 0.0;
      for( key in data){
      ValuePair = map.get(key);
       info -= (valuepair.getEdible()/valuepair.getTotal) * math.log(base2) * (valuepair.getEdible()/valuepair.getTotal);
      }

return info
  }
  
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