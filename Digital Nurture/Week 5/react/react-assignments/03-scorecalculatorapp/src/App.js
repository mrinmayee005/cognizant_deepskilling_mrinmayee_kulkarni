import React from 'react';
import CalculateScore from './Components/CalculateScore';
import './Stylesheets/mystyle.css';

function App() {
  return (
    <div>
      <CalculateScore Name="John Doe" School="ABC High School" Total={450} goal={500} />
    </div>
  );
}

export default App;
