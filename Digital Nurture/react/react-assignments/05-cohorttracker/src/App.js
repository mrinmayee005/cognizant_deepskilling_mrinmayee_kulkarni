import React from 'react';
import CohortDetails from './CohortDetails';
import cohortData from './CohortData';

function App() {
  return (
    <div>
      <h1>Cohort Tracker</h1>
      {cohortData.map((cohort, index) => (
        <CohortDetails
          key={index}
          cohortCode={cohort.cohortCode}
          cohortName={cohort.cohortName}
          status={cohort.status}
        />
      ))}
    </div>
  );
}

export default App;
