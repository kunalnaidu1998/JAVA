/* CourseCalculator.java
 * 
 * This program calculates your student final grade as a weighted average
 * given a set of raw grades in each of five grading categories and the corresponding
 * weights.
 * 
 * Recall that students will have:
 *   10 Individual Assignments (10% or 0.1 of your overall grade)
 *   11 Individual Quizzes (20% or 0.2 of your overall grade)
 *   6 Coding Challenges (30% or 0.3 of your overall grade)
 *   10 Team Quizzes (10% or 0.1 of your overall grade)
 *   1 Team Project (30% or 0.3 of your overall grade)
 */

public class CourseCalculator {

	// TODO: these variables should no longer be public (use the default visibility for now)
	// or static

	double[] iAssignmentGrades = {2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0};
	double[] iQuizGrades = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	double[] iCodingChallengeGrades = {3.0, 3.0, 3.0, 3.0, 3.0, 3.0};
	double[] tQuizGrades = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
	double tProjectGrade = 1.0;
	double finalGrade = 0;
	
	
	// Constructor for the class. Do not modify.	
	public CourseCalculator()
	{
		calculateFinalGrade();
	}
	
	
	// TODO: implement similar methods for each of the other grade categories:
	// iQuizGrades
	// iCodingChallengeGrades
	// tQuizGrades
	// tProjectGrade
	// Don't forget to add an appropriate comment block
				
	public double calculateIAssignmentGrade(double [] rawGrades)
	{
		final double iAssignmentGradeWeight = 0.1;
		return findAverageGrade(rawGrades) * iAssignmentGradeWeight;
	}
	
	
	public double calculateIQuizGrade(double [] rawGrades)
	{
		final double iAssignmentGradeWeight = 0.2;
		return findAverageGrade(rawGrades) * iAssignmentGradeWeight;
	}
	
	public double calculateICodingChallengeGrade(double [] rawGrades)
	{
		final double iAssignmentGradeWeight = 0.3;
		return findAverageGrade(rawGrades) * iAssignmentGradeWeight;
	}
	
	public double calculateTQuizGrade(double [] rawGrades)
	{
		final double iAssignmentGradeWeight = 0.1;
		return findAverageGrade(rawGrades) * iAssignmentGradeWeight;
	}
	
	public double calculateTProjectGrade(double rawGrades)
	{
		final double iAssignmentGradeWeight = 0.3;
		return rawGrades * iAssignmentGradeWeight;
	}

	// You should refer to this method to help you understand how each of the 
	// methods it calls should be implemented.
	// DO NOT MODIFY.
	public void calculateFinalGrade()
	{
		finalGrade = calculateIAssignmentGrade(iAssignmentGrades) +
				calculateIQuizGrade(iQuizGrades) +
				calculateICodingChallengeGrade(iCodingChallengeGrades) +
				calculateTQuizGrade(tQuizGrades) + 
				calculateTProjectGrade(tProjectGrade);
	}
	
	// Provided only to help your main method run. 
	// You may modify this, but I do not recommend it
	
	public String toString()
	{
		return "Your final grade will be " + finalGrade;
	}
		


	/* This method should calculate the mean of all the values in the array.
	 * 
	 * To do this, you should sum all the values in the array and divide 
	 * this sum by the number of values in the array
	 * 
	 * DO NOT MODIFY THIS METHOD
	 * 
	 *  @param An array of doubles containing the raw grades to be averaged 
	 * 	@return The mean of the values contained in the input array
	 */
	
	
	public double findAverageGrade(double [] rawGrades)
	{
		double sum = 0.0;
		for (double i : rawGrades) {
				sum += i;
		}
		double mean = sum/(rawGrades.length);
		if ((mean < 0) || (mean > 4.0)) {
			mean = 0.0;
		}
		return mean;		
	}
	
	// Provided for your convenience only, to help you understand
	//    how the code is put together. You may modify this.
	
	public static void main(String[] args) {
		
		CourseCalculator myCourseCalculator = new CourseCalculator();
		System.out.println(myCourseCalculator.toString());

	}
	
}


