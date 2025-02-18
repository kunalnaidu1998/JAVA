import java.util.ArrayList;

/*****************************
 * class Category
 * 
 * This class represents any category of grades used for the course. 
 * It contains the following instance variables:
 * 	name: a String which identifies the category
 *  weight: a value between 0.0 and 1.0 which defines how much the category is worth
 *  grades: an ArrayList of Doubles containing grades for the course, which should be between 0.0 and 4.3
 *
 */

public class Category {
	private String name = "";
	protected double weight;
	protected ArrayList<Double> grades;
	
	
	/* CourseCalculator()
	 * Constructor for the class
	 * 
	 * TODO: Implement the body of this method
	 * 
	 * You may wish to note how other methods are called to help you implement them
	 */
	
	public Category()
	{
		grades = new ArrayList<Double>();
		
	}
	
	/* Category(String, double, double[])
	 * Constructor for the class
	 * 
	 * @param newName the name that will be used for the new instance of the class
	 * @param newWeight the weight that will be used for the new instance of the class
	 * @param rawGrades the individual grades that will be used for the new instance of the class
	 * 	Ignore grades that are invalid (for instance, if they are less than 0 or greater than 4.3)
	 * 
	 * TODO: Implement the body of this method
	 * 
	 * You may wish to note how other methods are called to help you implement them.
	 */
	
	
	public Category(String newName, double newWeight, double [] rawGrades)
	{
		grades = new ArrayList<Double>();
		setName(newName);
		setWeight(newWeight);

		for(double i : rawGrades) {
			if(i >= 0 && i <= 4.3) {
				addGrade(i);
			}
		}
	}
	
	/* calculateGrade()
	 * DO NOT MODIFY 
	 * 
	 * @return a double which is the weighted grade for the category. In this case, we assume
	 *    there is only one grade in the Category
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
			return grades.get(0).doubleValue() * weight;
		}
		else
			return 0.0;
	}

	// getters and setters, toString methods
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void addGrade(double newGrade)
	{
		grades.add(new Double(newGrade));
	}
	
	public ArrayList<Double> getGrades()
	{
		ArrayList<Double> gradesClone = new ArrayList<Double>();
			for (int i = 0; i < grades.size(); i++)
			{
				gradesClone.add(new Double(grades.get(i)));
			}
			return gradesClone;
	}
		
	public String toString()
	{
		return name + " has weight " + weight + " and grades: " + grades.toString();
	}
}
