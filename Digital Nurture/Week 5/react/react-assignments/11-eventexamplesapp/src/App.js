import React from 'react';
import EventExamples from './EventExamples';
import CurrencyConvertor from './CurrencyConvertor';
import './App.css';

function App() {
  return (
    <div className="App">
      <h1>Project 11: Event Examples App</h1>
      <EventExamples />
      <hr />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
