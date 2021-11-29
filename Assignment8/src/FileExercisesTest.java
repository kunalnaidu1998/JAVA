import static org.junit.Assert.*;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

import org.junit.Test;

public class FileExercisesTest {
	
	private String getRandomFilename() {
		return "test" + (new Random()).nextInt(100000);
	}
	
	private String createFile(String text){
		String filename =  getRandomFilename() + ".txt";
		try {
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			output.print(text);
			output.close();
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to (re)create file " + filename);
		}
		return filename;
	}
	
	private String createFile(double[] nums){
		String filename = getRandomFilename() + ".bin";
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
			out.writeInt(nums.length);
			for (int counter = 0; counter < nums.length; counter++) {
				out.writeDouble(nums[counter]);
			}
			out.close();		
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to create file " + filename);
		}
		return filename;
	}

	private String createFile(int[] nums){
		String filename = getRandomFilename() + ".bin";
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
			out.writeInt(nums.length);
			for (int counter = 0; counter < nums.length; counter++) {
				out.writeInt(nums[counter]);
			}
			out.close();		
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to create file " + filename);
		}
		return filename;
	}
	
	//Test with valid files
	
	@Test
	public void test_checkMonth_Invalid(){
		try {
			FileExercises f1 = new FileExercises();
			f1.checkMonth(0);
			fail("0 is not a valid month of the year,  expected an IOException, but no exception was thrown.");
		} catch (IOException ioe) {
			assertEquals("Expected message in IOException to be 'negative number'", "Invalid month number", ioe.getMessage());			
		}
		try {
			FileExercises f1 = new FileExercises();
			f1.checkMonth(13);
			fail("13 is not a valid month of the year,  expected an IOException, but no exception was thrown.");
		} catch (IOException ioe) {
			assertEquals("Expected message in IOException to be 'negative number'", "Invalid month number", ioe.getMessage());			
		}
	}

	@Test
	public void test_checkMonth_valid(){
		try {
			FileExercises f1 = new FileExercises();
			int num = f1.checkMonth(1);
			assertEquals("Called checkMonth with 1", 1, num);
		} catch (IOException ioe) {
			fail("Called checkMonth with 1, expected 1 to be returned, instead there was an IOException with message " + ioe.getMessage());
		}
		try {
			FileExercises f1 = new FileExercises();
			int num = f1.checkMonth(12);
			assertEquals("Called checkMonth with 12", 12, num);
		} catch (IOException ioe) {
			fail("Called checkMonth with 12, expected 12 to be returned, instead there was an IOException with message " + ioe.getMessage());
		}
	}
	
	@Test
	public void test_numberSearch_noNumberInFile() {
		String inFilename = createFile("This is a test\nfor counting this word\nand here and there is a few tests\nand another test");
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		
		// run the test
		try {
			boolean actual = fl.numberSearch(3.5, inFilename);
			assertFalse("The number 3.5 does not appear in the file", actual);
		} catch (FileNotFoundException fnfe) {
			fail("File exists but caught FileNotFoundException: " + fnfe.getMessage());
		}
		
		File f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_numberSearch_numberOnceAtEndOfFile() {
		
		String inFilename = createFile("Hello World\nSome more text 2\n And some4 numbers\n some number3.7");
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		
		// run the test
		try {
			boolean actual = fl.numberSearch(3.7, inFilename);
			assertTrue("The number 3.7 appears once in the file", actual);
		} catch (FileNotFoundException fnfe) {
			fail("File exists so no FileNotFoundException expected: " + fnfe.getMessage());
		}
		
		File f = new File(inFilename);
		f.delete();
	}
	
	
	@Test
	public void test_numberSearch_numberManyTimesInFile1() {
		String inFilename = createFile("3.53.53.53.5");
		FileExercises fl = new FileExercises();
		
		try {
			boolean actual = fl.numberSearch(3.5, inFilename);
			assertTrue("The number 3.5 appears in the file", actual);
		} catch (FileNotFoundException fnfe) {
			fail("File exists so no FileNotFoundException expected: " + fnfe.getMessage());
		}
		File f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_numberSearch_invalidFileName() {
		FileExercises fl = new FileExercises();
		
		String inFilename = getRandomFilename() + ".txt";
		File f = new File(inFilename);
		f.delete();
		
		try {
			fl.numberSearch(33.7, inFilename);
			fail("File does not exist so FileNotFoundException expected");
		} catch (FileNotFoundException fnfe) {
			// expected, passed the test
		}
		f = new File(inFilename);
		f.delete();
	}

}
