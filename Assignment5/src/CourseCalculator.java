import java.util.ArrayList;

/* CourseCalculator.java
 * 
 * This program calculates the gradeas a weighted average
 * given a set of raw grades in each of five grading categories and the corresponding
 * weights.
 * 
 * Recall that student will have:
 *   10 Individual Assignments (10% or 0.1 of your overall grade)
 *   11 Individual Quizzes (20% or 0.2 of your overall grade)
 *   6 Coding Challenges (30% or 0.3 of your overall grade)
 *   10 Team Quizzes (10% or 0.1 of your overall grade)
 *   1 Team Project (30% or 0.3 of your overall grade)
 */

public class CourseCalculator {
	
	private double finalGrade = 0.0;
	private ArrayList<Category> scheme;
	
	/* CourseCalculator
	 * Constructor for the class: DO NOT MODIFY 
	 * 
	 * You may wish to note how other methods are called to help you implement them
	 */
		
	public CourseCalculator()
	{
		
		double [] iAssignmentGrades = {2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0};
		double [] iQuizGrades = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		double[] iCodingChallengeGrades = {3.0, 3.0, 3.0, 3.0, 3.0, 3.0};
		double [] tQuizGrades = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		scheme = new ArrayList<Category>();
		
		scheme.add(new NonProjectCategory("iAssignment", 0.1, 2, iAssignmentGrades));
		scheme.add(new NonProjectCategory("iQuiz", 0.2, 2, iQuizGrades ));
		scheme.add(new NonProjectCategory("iCodingChallenge", 0.3, 1, iCodingChallengeGrades));
		scheme.add(new NonProjectCategory("tQuiz", 0.1, 1, tQuizGrades));
		scheme.add(new ProjectCategory(0.3, 4.0));
		calculateFinalGrade();
	}
	
	public void calculateFinalGrade()
	{
		finalGrade = 0.0;
		
		for (int categoryCounter = 0; categoryCounter < scheme.size(); categoryCounter++)
		{
			finalGrade += scheme.get(categoryCounter).calculateGrade();
		}
		
	}
	
	public String toString()
	{
		return "Your final grade will be " + finalGrade;
	}
		
	/**
	 * @return the finalGrade
	 */
	public double getFinalGrade() {
		return finalGrade;
	}

	public static void main(String [] args)
	{
		CourseCalculator myCalculator = new CourseCalculator();
		System.out.println(myCalculator.toString());
	}
	
}


