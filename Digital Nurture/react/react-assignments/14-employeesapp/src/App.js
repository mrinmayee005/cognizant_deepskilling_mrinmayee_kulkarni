import React, { useState } from 'react';
import { ThemeContext } from './ThemeContext';
import EmployeesList from './EmployeesList';
import './App.css';

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(prevTheme => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Project 14: Employees App</h1>
        <button onClick={toggleTheme}>Toggle Theme (Current: {theme})</button>
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
