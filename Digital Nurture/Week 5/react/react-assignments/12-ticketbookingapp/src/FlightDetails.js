import React from 'react';

const flights = [
  { id: 1, from: 'New York', to: 'London', departure: '10:00 AM', arrival: '10:00 PM', price: '$450' },
  { id: 2, from: 'London', to: 'Paris', departure: '8:00 AM', arrival: '10:30 AM', price: '$120' },
  { id: 3, from: 'Dubai', to: 'Tokyo', departure: '11:00 PM', arrival: '2:00 PM', price: '$680' },
  { id: 4, from: 'Mumbai', to: 'New York', departure: '1:00 AM', arrival: '6:00 AM', price: '$550' }
];

function FlightDetails() {
  return (
    <div>
      <h2>Available Flights</h2>
      {flights.map(flight => (
        <div className="flight" key={flight.id}>
          <p><strong>{flight.from}</strong> to <strong>{flight.to}</strong></p>
          <p>Departure: {flight.departure} | Arrival: {flight.arrival}</p>
          <p>Price: {flight.price}</p>
        </div>
      ))}
    </div>
  );
}

export default FlightDetails;
