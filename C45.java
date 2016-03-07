import java.util.*;


public class C45
{
	/* Given training data, generates decision tree */
	public void c45()
	{
		// Create root node, populating it with List<List<String>>
	}


	private double calcGainRatio(HashMap)
	{
		double gain_ratio;

		return gain_ratio;
	}

	private findABest


// BASE CASES
		// If the samples in the list belong to the same class:

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