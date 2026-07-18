import React from 'react';

function BookingPage() {
  return (
    <div>
      <h2>Book a Flight</h2>
      <form>
        <div>
          <label>Name: </label>
          <input type="text" placeholder="Enter your name" />
        </div>
        <div>
          <label>Email: </label>
          <input type="email" placeholder="Enter your email" />
        </div>
        <div>
          <label>Flight ID: </label>
          <input type="text" placeholder="Enter flight ID" />
        </div>
        <button type="submit">Book Now</button>
      </form>
    </div>
  );
}

export default BookingPage;
