import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohortCode, cohortName, status }) {
  return (
    <div className={styles.box}>
      <dl>
        <dt>Cohort Code</dt>
        <dd>{cohortCode}</dd>
        <dt>Cohort Name</dt>
        <dd>{cohortName}</dd>
        <dt>Status</dt>
        <dd>
          <h3 className={status === 'ongoing' ? styles.ongoing : styles.other}>
            {status}
          </h3>
        </dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
