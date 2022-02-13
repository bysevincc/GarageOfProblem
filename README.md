In this problem, you have a garage that can be parked up to 10 slots (you can consider each slot is 1 unit range) at any
given point in time. You should create an automated ticketing system that allows your customers to use your garage
without human intervention. When a car enters your garage, you give a unique ticket issued to the driver. The ticket
issuing process includes us documenting the plate and the colour of the car and allocating an available slots to the car
before actually handing over a ticket to the driver. When a vehicle holds number of slots with its own width, you have to
leave 1 unit slot to next one. The customer should be allocated slot(s) which is nearest to the entry. At the exit the
customer returns the ticket which then marks slot(s) they were using as being available.
you can use for tests


create_parking_lot 6
park KAÂ­01Â­HHÂ­1234 White
park KAÂ­01Â­HHÂ­9999 White
park KAÂ­01Â­BBÂ­0001 Black
park KAÂ­01Â­HHÂ­7777 Red
park KAÂ­01Â­HHÂ­2701 Blue
park KAÂ­01Â­HHÂ­3141 Black
leave 4
status
park KAÂ­01Â­PÂ­333 White
park DLÂ­12Â­AAÂ­9999 White
registration_numbers_for_cars_with_colour White
slot_numbers_for_cars_with_colour White
slot_number_for_registration_number KAÂ­01Â­HHÂ­3141
slot_number_for_registration_number MHÂ­04Â­AYÂ­1111
