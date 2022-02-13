package com.ProblemOfGarage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Input {
	Commands commands;
	static ParkingatGarage parkingatGarage;
	   public Input() throws NoSuchMethodException, SecurityException {
	        commands = new Commands();
	        parkingatGarage = new ParkingatGarage();
	    }
	
	public void parseTextInput(String input) throws NoSuchMethodException, SecurityException {
		   String[] inputs = input.split(" ");	
		   switch (inputs.length) {
           case 1:
               try {
                   Method method = commands.CommRoadMap.get(input);
                   if (method != null) {
                       method.invoke(parkingatGarage);
                   } else {
                       System.out.println("Invalid input");
                   }
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               } catch (InvocationTargetException e) {
                   e.printStackTrace();
               }
               break;
           case 2:
               try {
                   Method method = commands.CommRoadMap.get(inputs[0]);
                   if (method != null) {
                       method.invoke(parkingatGarage, inputs[1]);
                   } else {
                       System.out.println("Invalid input");
                   }
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               } catch (InvocationTargetException e) {
                   e.printStackTrace();
               }
               break;
           case 3:
               try {
                   Method method = commands.CommRoadMap.get(inputs[0]);
                   if (method != null) {
                       method.invoke(parkingatGarage, inputs[1], inputs[2]);
                   } else {
                       System.out.println("Invalid input");
                   }
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               } catch (InvocationTargetException e) {
                   e.printStackTrace();
               }
               break;
           default:
               System.out.println("Invalid input.");
       }}
		   

		    public void parseFileInput(String filePath) throws NoSuchMethodException, SecurityException {
		        // Assuming input to be a valid file path.
		        File inputFile = new File(filePath);
		        try {
		            BufferedReader br = new BufferedReader(new FileReader(inputFile));
		            String line;
		            try {
		                while ((line = br.readLine()) != null) {
		                	parseTextInput(line.trim());
		                }
		            } catch (IOException ex) {
		                System.out.println("Error in reading the input file.");
		                ex.printStackTrace();
		            }
		        } catch (FileNotFoundException e) {
		            System.out.println("File not found in the path specified.");
		            e.printStackTrace();
		        }
	}

}
