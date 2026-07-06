import React from 'react';
import CohortDetails from './CohortDetails';
import cohortData from './CohortData';
import './App.css';

function App() {
  return (
    <div className="App">
      <h1>Cohort Tracker</h1>
      {cohortData.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;