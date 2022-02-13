package com.ProblemOfGarage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class ParkingatGarage {
	 int mksimum_size = 0;
	    private class Car {
	        String carNo;
	        String color;
	        public Car(String regNo, String color) {
	            this.carNo = carNo;
	            this.color = color;
	        }
	    }
	    ArrayList<Integer> avblSlotList;
	    Map<String, Car> mapOfSlot;
	    Map<String, String> mapOfCarNo;
	    Map<String, ArrayList<String>> mapOfColor;
	    
	    public void createPark(String lotCount) {
	        try {
	            this.mksimum_size = Integer.parseInt(lotCount);
	        } catch (Exception e) {

	        }
	        this.avblSlotList = new ArrayList<Integer>() {};
	        for (int i=1; i<= this.mksimum_size; i++) {
	        	avblSlotList.add(i);
	        }
	        this.mapOfSlot = new HashMap<String, Car>();
	        this.mapOfCarNo = new HashMap<String, String>();
	        this.mapOfColor = new HashMap<String, ArrayList<String>>();
	       
	    }
	    

	    public void park(String regNo, String color) {
	        if (this.mksimum_size == 0) {
	            System.out.println("Sorry, parking lot is not created");
	            System.out.println();
	        } else if (this.mapOfSlot.size() == this.mksimum_size) {
	            System.out.println("Sorry, parking lot is full");
	            System.out.println();
	        } else {
	            Collections.sort(avblSlotList);
	            String slot = avblSlotList.get(0).toString();
	            Car car = new Car(regNo, color);
	            this.mapOfSlot.put(slot, car);
	            this.mapOfCarNo.put(regNo, slot);
	            if (this.mapOfColor.containsKey(color)) {
	                ArrayList<String> regNoList = this.mapOfColor.get(color);
	                this.mapOfColor.remove(color);
	                regNoList.add(regNo);
	                this.mapOfColor.put(color, regNoList);
	            } else {
	                ArrayList<String> regNoList = new ArrayList<String>();
	                regNoList.add(regNo);
	                this.mapOfColor.put(color, regNoList);
	            }
	            System.out.println("Allocated slot number: " + slot);
	            System.out.println();
	            avblSlotList.remove(0);
	        }
	    }
	    public void leave(String slotNo) {
	        if (this.mksimum_size == 0) {
	
	        } else if (this.mapOfSlot.size() > 0) {
	            Car carToLeave = this.mapOfSlot.get(slotNo);
	            if (carToLeave != null) {
	                this.mapOfSlot.remove(slotNo);
	                this.mapOfCarNo.remove(carToLeave.carNo);
	                ArrayList<String> regNoList = this.mapOfColor.get(carToLeave.color);
	                if (regNoList.contains(carToLeave.carNo)) {
	                    regNoList.remove(carToLeave.carNo);
	                }
	            
	                this.avblSlotList.add(Integer.parseInt(slotNo));
	               
	            } else {
	                System.out.println("Slot number " + slotNo + " is already empty");
	                
	            }
	        } else {
	            System.out.println("Parking lot is empty");
	          
	        }
	    }
	    
	    public void status() {
	        if (this.mksimum_size == 0) {
	            System.out.println("Sorry, parking lot is not created");
	            System.out.println();
	        } else if (this.mapOfSlot.size() > 0) {
	            // Print the current status.
	            System.out.println("Slot No.\tRegistration No.\tColor");
	            Car car;
	            for (int i = 1; i <= this.mksimum_size; i++) {
	                String key = Integer.toString(i);
	                if (this.mapOfSlot.containsKey(key)) {
	                    car = this.mapOfSlot.get(key);
	                    System.out.println(i + "\t" + car.carNo + "\t" + car.color);
	                }
	            }
	            System.out.println();
	        } else {

	        }
	    }
	    

	    public void getRegistrationNumbersFromColor(String color) {
	        if (this.mksimum_size == 0) {
	            System.out.println("Sorry, parking lot is not created");
	            System.out.println();
	        } else if (this.mapOfColor.containsKey(color)) {
	            ArrayList<String> regNoList = this.mapOfColor.get(color);
	            System.out.println();
	            for (int i=0; i < regNoList.size(); i++) {
	                if (!(i==regNoList.size() - 1)){
	                    System.out.print(regNoList.get(i) + ",");
	                } else {
	                    System.out.print(regNoList.get(i));
	                }
	            }
	        } else {
	            System.out.println("Not found");
	            System.out.println();
	        }
	    }
	    public void getSlotNumbersFromColor(String color) {
	        if (this.mksimum_size == 0) {
	            System.out.println("Sorry, parking  is not created");
	           
	        } else if (this.mapOfColor.containsKey(color)) {
	            ArrayList<String> regNoList = this.mapOfColor.get(color);
	            ArrayList<Integer> slotList = new ArrayList<Integer>();
	            System.out.println();
	            for (int i=0; i < regNoList.size(); i++) {
	                slotList.add(Integer.valueOf(this.mapOfCarNo.get(regNoList.get(i))));
	            }
	            Collections.sort(slotList);
	            for (int j=0; j < slotList.size(); j++) {
	                if (!(j == slotList.size() - 1)) {
	                    System.out.print(slotList.get(j) + ",");
	                } else {
	                    System.out.print(slotList.get(j));
	                }
	            }
	            System.out.println();
	        } else {
	            System.out.println("Not found");
	
	        }
	    }
	    public void getSlotNumberFromRegNo(String regNo) {
	        if (this.mksimum_size == 0) {
	            System.out.println("Sorry, parking lot is not created");
	            System.out.println();
	        } else if (this.mapOfCarNo.containsKey(regNo)) {
	            System.out.println(this.mapOfCarNo.get(regNo));
	        } else {
	            System.out.println("Not found");
	            System.out.println();
	        }
	    }
}
