/* CourseCalculator.java
 * 
 * This program calculates student grade for as a weighted average
 * given a set of raw grades in each of five grading categories and the corresponding
 * weights.
 * 
 * Recall that student will have:
 *   10 Individual Assignments
 *   11 Individual Quizzes
 *   6 Coding Challenges
 *   10 Team Quizzes
 *   1 Team Project
 */

public class CourseCalculator {
	
	// Raw grades 
	// Values should be between 0 and 4.3 (U of C's 4-point grading scale, with the course's
	// modification for A+ grades, which is 4.3)
	// These values can be changed to test whether the grade calculation is accurate
	
	double[] iAssignmentGrades = new double[10];
	double[] iQuizGrades = new double[11];
	double[] iCodingChallengeGrades = new double[6];
	double[] tQuizGrades = new double[6];
	double tProjectGrade = 1.0;
	
	public static void main(String[] args) {
		
		double iAssignmentGrade = findAverageGrade(iAssignmentGrades);
		double iQuizGrade = findAverageGrade(iQuizGrades);
		double iCodingChallengeGrade = findAverageGrade(iCodingChallengeGrades);
		double tQuizGrade = findAverageGrade(tQuizGrades);
								
		// Final grade (should be a calculated value)
		double finalGrade = 0.0;
		
		// Weights for each grade category
		final double iAssignmentQuizGradeWeight = 0.1;
		final double iQuizGradeWeight = 0.2;
		final double iCodingChallengeGradeWeight = 0.3;
		final double tQuizGradeWeight = 0.1;
		final double tProjectGradeWeight = 0.3;
	
		// Calculated grade. It is a weighted average of all grade categories.

		finalGrade = iAssignmentGrade * iAssignmentQuizGradeWeight +
				iQuizGrade * iQuizGradeWeight +
				iCodingChallengeGrade * iCodingChallengeGradeWeight + 
				tQuizGrade * tQuizGradeWeight +
				tProjectGrade * tProjectGradeWeight;
		
		System.out.println("Your final grade will be " + finalGrade);

	}
	
	
	/* This method should calculate the mean of all the values in the array.
	 * 
	 * To do this, you should sum all the values in the array and divide 
	 * this sum by the number of values in the array
	 * 
	 * @param An array of doubles containing the raw grades to be averaged 
	 * @return The mean of the values contained in the input array
	 */
	static double findAverageGrade(double [] rawGrades)
	{
		double sum = 0.0;
		for (double i : rawGrades) {
				sum += i;
		}
		double mean = sum/(rawGrades.length);
		if (mean < 0 || mean > 4.3) {
			mean = 0.0;
		}
		return mean;
	}

}	



