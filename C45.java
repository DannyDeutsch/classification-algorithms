public class C45
{
	/* Given training data, generates decision tree */
	public void c45()
	{
		
	}


	private double calcGainRatio()
	{
		double gain_ratio;

		return gain_ratio;
	}


// BASE CASES
		// If the samples in the list belong to the same class:
		// 		> create a leaf node for the decision tree saying to choose that class.
		// If none of the features provide any information gain, OR instance of previously-unseen class encountered:
		// 		> create a decision node higher up the tree using the expected value of the class.

		// For each attribute a, find the normalized information gain ratio from splitting on a

		// Let a_best be the attribute with the highest normalized information gain

		// Create a decision node that splits on a_best
		
		// Recur on the sublists obtained by splitting on a_best, and add those nodes as children of node





	
	/* Build decision tree classifier from training data */


	/* Extract rules from tree, one rule per leaf */


	/****************
	    PRUNE TREE
	 ****************/
	
	// Estimate rule accuracy, using training tuples and their class labels

	// Adjust accuracy estimate to compensate for bias

	// Remove rules that do not contribute to overall accuracy of rule set

	// Group rules by class, then rank class rule sets based on false positive frequency, least first

	// Remove duplicate rules

}