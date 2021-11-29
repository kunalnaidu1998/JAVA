

/*****************************
 * class ProjectCategory
 * 
 * This class represents the project grade of the course. 
 * It contains the following instance variables:
 * 
 */


public class ProjectCategory extends Category {
	
	//TODO: Add all instance variables per the assignment specification
	private double currentAdjustmentFactor = 1.0;
	
	
	public ProjectCategory(double weight, double rawGrade)
	{
		super("Project", weight, new double[]{rawGrade});
	}
	
	/********
	 * TODO: Implement a constructor which takes in the following parameters. You may use call
	 * a constructor from this class or the superclass.
	 * 
	 * @param weight
	 * @param rawGrade
	 * @param adjustmentFactor
	 */
	
	public ProjectCategory(double weight, double rawGrade, double adjustmentFactor) {
		super("Project", weight, new double[]{rawGrade});
		setAdjustmentFactor(adjustmentFactor);
	}
	
	
	/*******
	 * getAdjustedGrade()
	 * TODO: Add a method which gets the adjusted grade. If the grades array should hold more than one value, 
	 *   return 0.0. If the product of the adjustment factor and the grade is greater than 4.3, then return
	 *   4.3
	 * @return double the adjusted grade (i.e. adjustment factor * grade)
	 */
	
	public double getAdjustedGrade() {
		double newGrade;
		if (grades.size() == 1) {
			newGrade = currentAdjustmentFactor*grades.get(0);
			if (newGrade > 4.3) {
				newGrade = 4.3;
			}
			return newGrade;
		}
		else {
			return 0.0;
		}
	}
	
	/****
	 * TOOD: 
	 * Override this method so that it calculates the weighted grade based upon the adjusted 
	 * grade. It should still check that the weight is valid (i.e. greater than 0 and less than
	 * or equal to 1.0), and return 0 if it is not.
	 * 
	 * HINT: You may want to copy most of your code from elsewhere (where you have
	 * removed it, and then modify it according to the design of this class)
	 * @return double: the calculated grade (adjusted grade * weight)
	 */
	
	@Override
	public double calculateGrade()
	{
		boolean validWeight = ((this.weight > 0) && (this.weight <= 1.0));
		if(validWeight)
		{
			return getAdjustedGrade() * weight;
		}
		else
			return 0.0;
	}

	/****
	 * TODO: Generate a getter and setter for the adjustmentFactor instance variable.
	 * setAdjustmentFactor() should check that the adjustmentFactor is valid (greater than 0)
	 * */
	
	public void setAdjustmentFactor(double newAdFactor) {
		if (newAdFactor >= 0) {
			currentAdjustmentFactor = newAdFactor;
		}
	}
	public double getAdjustmentFactor() {
		return currentAdjustmentFactor;
	}
	
	
}
