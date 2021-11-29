
import java.util.Arrays;

public class RecursionExercises {

	
	public RecursionExercises() {
		// TODO Auto-generated constructor stub
	}
	
	/***********
	 * sumRecursive
	 * TODO Implement the body of this method
	 *
	 * This should sum together all values in the input array by dividing the 
	 * input array in two, and making a recursive call using each half as the input.
	 *   
	 * @param input: integer array containing the values to be added together
	 * @return 	When the length of the input is 1, return the input array.
	 * 			If the length of the input is 0, return 0
	 * 			Otherwise, return the sum of the recursive call to each half
	 */
	
	
	public int sumRecursive(int [] input)
	{
		if (input.length == 1) {
			return input[0];
		}
		else if (input.length == 0) {
			return 0;
		}
		else {
			int leftHalf = sumRecursive(Arrays.copyOfRange(input, 0, (input.length/2)));
			int rightHalf = sumRecursive(Arrays.copyOfRange(input, input.length/2, input.length));
			return leftHalf +rightHalf;
		}
		
	}
	
	
	
	
	// Main. DO NOT MODIFY.
	
	
	public static void main(String [] args)
	{
		
		
	}
	
	
	

}
