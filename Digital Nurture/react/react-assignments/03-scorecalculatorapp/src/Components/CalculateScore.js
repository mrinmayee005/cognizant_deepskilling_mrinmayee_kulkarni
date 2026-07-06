import React from 'react';

function CalculateScore({ Name, School, Total, goal }) {
  const average = (Total / goal) * 100;

  return (
    <div className="score-card">
      <h2>Score Details</h2>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total:</strong> {Total}</p>
      <p><strong>Goal:</strong> {goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}%</p>
    </div>
  );
}

export default CalculateScore;
