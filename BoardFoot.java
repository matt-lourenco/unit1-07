/****************************************************************************
 *
 * Created by: Matthew lourenco
 * Created on: Feb 2018
 * Calculates one dimension of a board foot when the two others are given
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardFoot {
	
	private static final double boardFootVolume = 144.0;
	private double length;
	private double width;
	private double height;
	
	BoardFoot() {
		//Default values for dimensions
		length = -1;
		width = -1;
		height = -1;
	}
	
	BoardFoot(double inLength, double inWidth, double inHeight) {
		//Constructor overloaded values for dimensions
		this();
		
		length = inLength;
		width = inWidth;
		height = inHeight;
		
		//find which value is missing
		if(length == -1 && width != -1 && height != -1) {
			//Calculate length
			length = boardFootVolume / width / height;
			
		} else if(length != -1 && width == -1 && height != -1) {
			//Calculate width
			width = boardFootVolume / length / height;
			
		} else if(length != -1 && width != -1 && height == -1) {
			//Calculate height
			height = boardFootVolume / length / width;
	
		} else {
			System.out.println("error, check number of dimensions inputted");
		}
	}
	
	public double getLength() {
		//Get the length
		return length;
	}
	public double getWidth() {
		//Get the width
		return width;
	}
	public double getHeight() {
		//Get the height
		return height;
	}
	
	public static void main(String[] args) {
		//Get user input and run the RollDie method
		
		String userInputLength = null;
		String userInputWidth = null;
		String userInputHeight = null;
		double dUserInputLength = -1;
		double dUserInputWidth = -1;
		double dUserInputHeight = -1;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader
	(System.in));
		while(true) {
			System.out.println("Enter the length or enter nothing: ");
			try {
				//Get user input
				userInputLength = reader.readLine();
			} catch (IOException noInput) {
				noInput.printStackTrace();
			}
			try {
				//Convert string to double
				dUserInputLength = Double.parseDouble(userInputLength);
				break;
			} catch (NumberFormatException stringInput) {
				if (userInputLength.isEmpty()) {
					//User did not input length
					break;
				} else {
					System.out.println("Please enter an integer");
				}
			}
		}
		while(true) {
			System.out.println("Enter the width or enter nothing: ");
			try {
				//Get user input
				userInputWidth = reader.readLine();
			} catch (IOException noInput) {
				noInput.printStackTrace();
			}
			try {
				//Convert string to double
				dUserInputWidth = Double.parseDouble(userInputWidth);
				break;
			} catch (NumberFormatException stringInput) {
				if (userInputWidth.isEmpty()) {
					//User did not input width
					break;
				} else {
					System.out.println("Please enter an integer");
				}
			}
		}
		while(true) {
			System.out.println("Enter the height or enter nothing: ");
			try {
				//Get user input
				userInputHeight = reader.readLine();
			} catch (IOException noInput) {
				noInput.printStackTrace();
			}
			try {
				//Convert string to double
				dUserInputHeight = Double.parseDouble(userInputHeight);
				break;
			} catch (NumberFormatException stringInput) {
				if (userInputHeight.isEmpty()) {
					//User did not input height
					break;
				} else {
					System.out.println("Please enter an integer");
				}
			}
		}
		
		BoardFoot object = new BoardFoot(dUserInputLength, dUserInputWidth, dUserInputHeight);
		System.out.println("The length is " + object.getLength() + "\nThe width is " + object.getWidth() +
				"\nThe height is " + object.getHeight());
	}
}
