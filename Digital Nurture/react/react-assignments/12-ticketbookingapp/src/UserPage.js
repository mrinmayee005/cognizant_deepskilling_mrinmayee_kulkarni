import React from 'react';
import FlightDetails from './FlightDetails';
import BookingPage from './BookingPage';

function UserPage() {
  return (
    <div>
      <h2>User View</h2>
      <FlightDetails />
      <BookingPage />
    </div>
  );
}

export default UserPage;
