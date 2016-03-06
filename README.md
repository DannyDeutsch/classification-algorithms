# classification-algorithms
C4.5, Naïve Bayesian classifiers

hi

Naive: Pseudo 
1) Input information List<List<Char>> 
2) Create a Map   Key = (column/attribute number) + key.  The value in the map will indicate count
ex  0e ( column 0 edible).  when we iterate through practice and are filling map with info we just check if it is there if not put it if it is then just increase the value.
Map<column atribute>  value, edible_Value(count of if it is that value and edible)

3) for i in itemList
      for a in attributes 
          if( i.a NOT IN MAP) ADD 
        Increase i.a value;
4) TEST
  for i in testItem
      double edible% = 1.0;
      for x in item_column
        edible% *=map(i.x).getEdible_Value();
      TestList.add(edible%);  

c4.5  
Find the best information gain add to queue.    

(info = the sum of all different key's for that attribute  (-((attribute -key count)/ total count) * log2 (attribute-keyCount/ total count) - attribute key count/ total count * log2 * .......
Information Equation
info a  =   attribute-key_count1/total count *((~~info gain given attribute~~) - ( attribute2-key/ attribute-key_count1)* log2(attribute2-key/attribute-key-count1) -  ( attribute2-key2/ attribute-key_count1)* log2(attribute2-key2/attribute-key-count1)- ....( attribute2-keyN/ attribute-key_count1)* log2(attribute2-keyN/attribute-key-count1)) * attribute-key2_count/totalCount * ( (~~info gain given attribute 1 key 2)........)    
Gain = info(per column) - info a ~~~~ choose highest ( per column)   ===> Create root w/ column num
      create children w/ column num. keys
      choose 1 and repeat part 1.   
if gain = 0 stop;

tree nodes need =  column number column key, column to look at next


TEST - follow tree- given column look at item_test.attribute key.  
that key looks at column x. given item.look at column.key. follow tree.  


when you find info gain- create tree - given N column X keys. 

Queue - current gain ratio
look at 





