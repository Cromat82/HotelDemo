# Endpoints

- add (POST): 
  - input: clientFullName, roomNumber, startDate, endDate
  - output: reservationId
- all (GET): 
  - input: 
  - output: list[id, clientFullName, roomNumber, startDate, endDate]
- update (POST)
  - input: id, clientFullName, roomNumber, startDate, endDate
  - output: result
	