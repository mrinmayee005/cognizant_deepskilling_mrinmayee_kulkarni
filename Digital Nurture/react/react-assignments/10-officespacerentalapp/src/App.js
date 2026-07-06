import React from 'react';
import './App.css';

function App() {
  const office = {
    Name: 'Downtown Office',
    Rent: 55000,
    Address: '123 Main Street, City Center',
  };

  const officeSpaces = [
    { Name: 'Tech Hub', Rent: 45000, Address: '456 Tech Park' },
    { Name: 'Business Center', Rent: 75000, Address: '789 Commerce Ave' },
    { Name: 'Creative Studio', Rent: 35000, Address: '321 Art District' },
    { Name: 'Executive Suite', Rent: 95000, Address: '555 Luxury Lane' },
    { Name: 'Startup Space', Rent: 25000, Address: '777 Innovation Blvd' },
  ];

  return (
    <div className="App">
      <h1>Office Space Rental</h1>
      <img
        src="https://via.placeholder.com/600x300?text=Office+Space"
        alt="Office Space"
        className="office-image"
      />
      <h2>Featured Office</h2>
      <div className="office-card">
        <h3>{office.Name}</h3>
        <p>Rent: ${office.Rent}</p>
        <p>Address: {office.Address}</p>
      </div>
      <h2>Available Office Spaces</h2>
      <div className="office-list">
        {officeSpaces.map((space, index) => (
          <div
            key={index}
            className="office-card"
            style={{
              color: space.Rent < 60000 ? 'red' : 'green',
            }}
          >
            <h3>{space.Name}</h3>
            <p>Rent: ${space.Rent}</p>
            <p>Address: {space.Address}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
