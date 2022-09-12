# schedule-shift-api
Rest API to assign random engineers to the shifts within a period based on the given rules.

# Endpoint 
 - Localhost
 http://localhost:8080/api/wheel

 - Web


 # DTOs

 - EngineerDto
 - ShiftDto

 # Core Engine 

 - A list of shifts and a pool of engineers is prepared for the given period
 - A random engineer is picked up from the pool and sent to the Rule Validator to verify his availability
 - If the availability is true, the engineer is assigned to the shift, if it's not another random engineer is picked up and the same process continue until an available engineer is found
 - After every assignment, we update the engineer pool to remove unvailable engineers.

 
