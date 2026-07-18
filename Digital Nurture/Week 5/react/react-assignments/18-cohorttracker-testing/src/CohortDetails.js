import React from 'react';

function CohortDetails({ cohort }) {
  return (
    <div className="cohort-card">
      <h3>{cohort.code}</h3>
      <p><strong>Name:</strong> {cohort.name}</p>
      <p><strong>Status:</strong> {cohort.status}</p>
    </div>
  );
}

export default CohortDetails;