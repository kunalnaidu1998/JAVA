import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class RecursionExercisesTestForEclipse {

	public RecursionExercisesTestForEclipse() {
		
	}
	//Check the submission file for the words "for" and "while"
	
	@Test
	public void testCheckWords(){
		Scanner scan = null;
		int forwhileCounter = 0;
		try {
			scan = new Scanner (new FileInputStream("src/RecursionExercises.java"));
		} catch (FileNotFoundException e){
			fail("RecursionExercises.java not found");
		}

		while (scan.hasNext()){
			String line = scan.nextLine();

			if (line.contains("//"))
			{
				System.out.println("continued: " + line);
				continue;
			}
			else if (line.contains("for") || line.contains("while")){
				forwhileCounter++;
			}
		}
		if (forwhileCounter > 0)
			fail("Found more than three instances of for or while loops");
		scan.close();
	}
	
	@Test
	public void test_sumRecursive_default()
	{
		RecursionExercises rExercises = new RecursionExercises();
		int [] testArray = {1, 3, 5, 2, 4, 8};
		int expected = 23;
		
		int actual = rExercises.sumRecursive(testArray);
		assertEquals("Testing expected sum",  expected, actual);		
	}
	
	@Test
	public void test_sumRecursive_oddInput()
	{
		RecursionExercises rExercises = new RecursionExercises();
		int [] testArray = {1, 3, 5};
		int expected = 9;
		
		int actual = rExercises.sumRecursive(testArray);
		assertEquals("Testing expected sum",  expected, actual);		
	}
	

	@Test
	public void test_sumRecursive_negativeInput()
	{
		RecursionExercises rExercises = new RecursionExercises();
		int [] testArray = {1, -3, 5};
		int expected = 3;
		
		int actual = rExercises.sumRecursive(testArray);
		assertEquals("Testing expected sum",  expected, actual);		
	}
	

	@Test
	public void test_sumRecursive_oneInput()
	{
		RecursionExercises rExercises = new RecursionExercises();
		int [] testArray = {5};
		int expected = 5;
		
		int actual = rExercises.sumRecursive(testArray);
		assertEquals("Testing expected sum",  expected, actual);		
	}
	

	@Test
	public void test_sumRecursive_emptyInput()
	{
		RecursionExercises rExercises = new RecursionExercises();
		int [] testArray = {};
		int expected = 0;
		
		int actual = rExercises.sumRecursive(testArray);
		assertEquals("Testing expected sum",  expected, actual);		
	}
	
	
}


