import java.util.ArrayList;

/*****************************
 * class NonProjectCategory
 * 
 * This class represents any category of grades used for the course that are not part of the 
 * project grade. 
 * It contains the following instance variables:
 * 	numDroppedGrades: an integer indicating how many grades will be dropped from the category's 
 *     assessments before calculating a weighted average
 *
 */

public class NonProjectCategory extends Category {
	private int numDroppedGrades = 0;
	
	/* NonProjectCategory(String, double, int, double[])
	 * Constructor for the class
	 * 
	 * @param newName the name that will be used for the new instance of the class
	 * @param newWeight the weight that will be used for the new instance of the class
	 * @param newNumGradesToDrop the number of grades to be dropped by the new instance of the class
	 * @param rawGrades the individual grades that will be used for the new instance of the class
	 * 	Ignore grades that are invalid (for instance, if they are less than 0 or greater than 4.3)
	 * 
	 * TODO: Implement the body of this method (hint: it shouldn't be more than two lines)
	 * 
	 * You may wish to note how other methods are called to help you implement this.
	 */
	
	public NonProjectCategory(String newName, double newWeight, int newNumGradesToDrop, double [] rawGrades)
	{
		super(newName, newWeight, rawGrades);
		setNumDroppedGrades(newNumGradesToDrop);
	}
	
	/* calculateGrade()
	 * DO NOT MODIFY 
	 * 
	 * @return a double which is the weighted grade for the category
	 * 
	 * If the weight is invalid (less than 0 or greater than 1.0), then returns
	 * 0.0
	 * 
	 */
	
	public double calculateGrade()
	{
		boolean validWeight = ((this.weight > 0) && (this.weight <= 1.0));
		if(!grades.isEmpty() && validWeight)
		{
			return findAverageGrade(dropGrades() )* this.weight;
		}
		else 
			return 0.0;
	}
	
	/* dropNGrades()
	 * @param gradeList an ArrayList of Doubles which are all the grades to consider
	 * @param numberToDrop an int representin the number of grades to drop from the result
	 * @return an ArrayList of Doubles which are all the grades which were not dropped
	 * 
	 * If the list after dropping all grades is empty, then add a single double with a 0.0 
	 * grade to the list
	 * 
	 * Make the following modifications:
	 * 
	 * grades now references from parent class
	 * getNumDroppedGrades uses a getter
	 * 
	 */
	public ArrayList<Double> dropGrades(){
		ArrayList<Double> droppedList = new ArrayList<Double>();
		for(int itemCounter = 0; itemCounter < grades.size(); itemCounter++)
		{
			droppedList.add(grades.get(itemCounter));
		}

		int dropCounter = 0;
		while((getNumDroppedGrades() <= grades.size()) && (dropCounter < getNumDroppedGrades()))
		{
			int minIndex = 0;		
			for(int itemCounter = 0; itemCounter < droppedList.size(); itemCounter++)
			{
				if (-1 == droppedList.get(itemCounter).compareTo(droppedList.get(minIndex).doubleValue()))
				{
					minIndex = itemCounter;
				}
			}
			droppedList.remove(minIndex);
			dropCounter++;
		}
		
		return droppedList;
	}
	
	
	/* findAverageGrade(ArrayList<Double)
	 * DO NOT MODIFY 
	 * 
	 * @param a provided list of grades
	 * @return a double which is the average grade for the list passed in as an argument
	 * 
	 * If the weight is invalid (less than 0 or greater than 1.0), then returns
	 * 0.0
	 * 
	 */
	
	public double findAverageGrade(ArrayList<Double> rawGrades)
	{
		double mean = 0.0;
		double sum = 0.0;
		
		for (int gradeCounter = 0; gradeCounter < rawGrades.size(); gradeCounter++)
		{
			sum += rawGrades.get(gradeCounter).doubleValue();
		}
		
		mean = sum / rawGrades.size();
		
		if ((mean < 0.0) || (mean > 4.0))
		{
			mean = 0.0;
		}
		// include a check: if your mean is greater than 4.0 or less than 0.0
		// have the method return 0
				
		return mean;
	}

	
	// getters and setters
	
	public int getNumDroppedGrades() {
		return numDroppedGrades;
	}

	public void setNumDroppedGrades(int numDroppedGrades) {
		this.numDroppedGrades = numDroppedGrades;
	}
	
	

}
