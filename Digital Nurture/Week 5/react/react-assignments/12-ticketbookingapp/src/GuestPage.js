import React from 'react';
import FlightDetails from './FlightDetails';

function GuestPage() {
  return (
    <div>
      <h2>Guest View</h2>
      <p>Please login to book flights.</p>
      <FlightDetails />
    </div>
  );
}

export default GuestPage;
