package com.ProblemOfGarage;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Commands {
    public Map<String, Method> CommRoadMap;

    
    public Commands() throws NoSuchMethodException, SecurityException {
	 CommRoadMap = new HashMap<String, Method>();
	 CommRoadMap.put("create_park", ParkingatGarage.class.getMethod("createPark", String.class));
     CommRoadMap.put("park", ParkingatGarage.class.getMethod("park", String.class, String.class));
     CommRoadMap.put("leave", ParkingatGarage.class.getMethod("leave", String.class));
     CommRoadMap.put("status", ParkingatGarage.class.getMethod("status"));
     CommRoadMap.put("reg_numbers_for_cars_with_colour", ParkingatGarage.class.getMethod("getRegNumbersFromColor", String.class));
     CommRoadMap.put("slot_numbers_for_cars_with_colour", ParkingatGarage.class.getMethod("getSlotNumbersFromColor", String.class));
     CommRoadMap.put("slot_number_for_registration_number", ParkingatGarage.class.getMethod("getSlotNumberFromRegNo", String.class));
 
	 
}
}