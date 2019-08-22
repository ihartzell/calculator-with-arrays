// Isaac Hartzell
// 2-11-17
// This program demonstrates a calculator with arrays.

import java.util.Arrays;
import java.util.Scanner;

public class ArraysCalculatorV2Finished 
{	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);						// *Special Notes.
		double[] operand1;											// operand1.length is for the for the size of the array.
		double[] operand2;											// Since both arrays are the same I only need operand1.length
		double[] resultArray;										// not operand2.length				
		double upperLimit;
		double lowerLimit;
		double dotProductValue;
		int numberChoice;
		int arraySize = 0;
		
		do
		{
			numberChoice = getMenuOption();
				
			if (numberChoice == 1)	//ADD
			{
				System.out.print("How many values are in the array?");
				arraySize = input.nextInt();
	
				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				resultArray = add(operand1, operand2);

				System.out.println("The result is " + Arrays.toString(resultArray));		
			}
			else if (numberChoice == 2) //SUBTRACT
			{
				System.out.print("How many values are in the array?");
				arraySize = input.nextInt();

				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				resultArray = subtract(operand1, operand2);

				System.out.println("The result is " + Arrays.toString(resultArray));
			}
			else if (numberChoice == 3) //MULTIPLY
			{
				System.out.print("How many values are in the array?");
				arraySize = input.nextInt();
				
				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				resultArray = multiply(operand1, operand2);

				System.out.println("The result is " + Arrays.toString(resultArray));
			}
			else if (numberChoice == 4) //DIVIDE
			{
				System.out.print("How many values are in the array?");
				arraySize = input.nextInt();
				
				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				resultArray = divide(operand1, operand2);

				System.out.println("The result is " + Arrays.toString(resultArray));
			}
			else if (numberChoice == 5) //DOT PRODUCT
			{
				System.out.print("How many values are in the array?");
				arraySize = input.nextInt();
		
				operand1 = getOperand("Enter the values in the first array, seperate the values by spaces", arraySize);
				operand2 = getOperand("Enter the values in the second array, seperate the values by spaces", arraySize);
				dotProductValue = dotProduct (operand1, operand2);		// I had to assign dotProduct method to dotProductValue
																		// because it returns a double, not an array.
				System.out.println("The result is " + dotProductValue);
			}
			else if (numberChoice == 6)	//RANDOM 
			{
				System.out.print("How many values should be in the random array?");
				arraySize = input.nextInt();
				
				lowerLimit = getOperand("What would you like the lower limit to be?");
				upperLimit = getOperand("What would you like the upper limit to be?");
				resultArray = random(lowerLimit, upperLimit, arraySize);	//arraySize becomes my size argument from input.

				System.out.println("The result is " + Arrays.toString(resultArray));
			}
			else if (numberChoice == 7)
			{
				System.out.println("Goodbye! Thank you for using Isaac's calculator.");	
			}
				
		}while(numberChoice >=1 && numberChoice <= 6);
							
	}
	
	public static int getMenuOption()	// Menu Method as well as menu checker.
	{
		Scanner input = new Scanner(System.in);
		int counter = 0;									
		int numberChoice;
			
		System.out.println("Menu");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");										
		System.out.println("4. Divide");
		System.out.println("5. Dot product");
		System.out.println("6. Generate Random Number ");
		System.out.println("7. Quit \n");
		System.out.print("What would you like to do? Pick a number 1-6:");
		numberChoice = input.nextInt();
		while ((numberChoice < 1 || numberChoice > 7) && counter < 2)	// Menu is already printed once, thus why counter < 2.
		{
			counter++;
			
			System.out.println("I'm sorry," + numberChoice + " wasn't one of the options.\n");
			System.out.println("Menu");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Dot product");
			System.out.println("6. Generate Random Number ");
			System.out.println("7. Quit \n");
			System.out.print("What would you like to do? Pick a number 1-6:");
			numberChoice = input.nextInt();
			
			if (counter == 2 && numberChoice < 1 || numberChoice > 7)	//If and only if the number chosen is outside the range
			{															// and the counter == 2 that user is locked out.
				System.out.println("\n"+"I'm sorry, due to (3) incorrect values you've been ");
				System.out.println("locked out. Please try again later.");
			}
			
		}
			
		return numberChoice;
	}
		
	public static double[] add(double[] operand1, double[] operand2)	//Add Method
	{
		double[] additionAnswer = new double[operand1.length];

		for(int arrayIndex = 0; arrayIndex < operand1.length; arrayIndex++)
		{
			additionAnswer[arrayIndex] = (operand1[arrayIndex] + operand2[arrayIndex]);
		}
		return additionAnswer;
	}
	
	public static double[] subtract(double[] operand1, double[] operand2)	//Subtract Method
	{
		double[] subtractionAnswer = new double[operand1.length];

		for(int arrayIndex = 0; arrayIndex < operand1.length; arrayIndex++)
		{
			subtractionAnswer[arrayIndex] = (operand1[arrayIndex] - operand2[arrayIndex]);
		}
		return subtractionAnswer;
	}
	
	public static double getOperand(String prompt)	//getOperand Method for prompt
	{
		Scanner scan = new Scanner(System.in);
		double number;

		System.out.println(prompt);
		number = scan.nextDouble();

		return number;
	}

	public static double[] getOperand(String prompt, int size)	//getOperand method for operandArray prompt
	{
		Scanner input = new Scanner(System.in);
		double[] operandArray = new double[size];	// new double[size] is to specify the size of the array.

		System.out.println(prompt);

		for(int arrayIndex = 0; arrayIndex < size; arrayIndex++)
		{
			operandArray[arrayIndex] = input.nextDouble();
		}
		return operandArray;
	}

	public static double[] multiply(double[] operand1, double[] operand2)	//Multiply method
	{
		double[] multiplicationAnswer = new double[operand1.length];	

		for(int arrayIndex = 0; arrayIndex < operand1.length; arrayIndex++)
		{
			multiplicationAnswer[arrayIndex] = (operand1[arrayIndex] * operand2[arrayIndex]);
		}
		return multiplicationAnswer;
	}
	
	public static double[] divide(double[] operand1, double[] operand2)	//Divide method
	{
		double[] divisionAnswer = new double[operand1.length];

		for(int arrayIndex = 0; arrayIndex < operand1.length; arrayIndex++)
		{
			if(operand2[arrayIndex] == 0)													
			{
				divisionAnswer[arrayIndex] = Double.NaN;	// Devision by zero
			}
			else
			{
				divisionAnswer[arrayIndex] = (operand1[arrayIndex] / operand2[arrayIndex]);
			}
		}
		return divisionAnswer;
	}
	public static double dotProduct(double[] operand1, double[] operand2)	//Dot product method
	{
		double dotProductAnswer = 0;

		for(int arrayIndex = 0; arrayIndex < operand1.length; arrayIndex++)
		{
			dotProductAnswer += (operand1[arrayIndex] * operand2[arrayIndex]);
		}
		return dotProductAnswer;
	}
	
	public static double[] random(double lowerLimit, double upperLimit, int size)	//Random Method
	{
		double[] randomNumberAnswer = new double[size];

		for(int arrayIndex = 0; arrayIndex < size; arrayIndex++)
		{
			randomNumberAnswer[arrayIndex] = Math.random() * (upperLimit - lowerLimit) + (lowerLimit); 							
		}
		return randomNumberAnswer;
	}

	
	
	
	
	
	
	
	
	
}
