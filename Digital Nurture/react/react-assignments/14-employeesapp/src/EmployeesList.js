import React from 'react';
import EmployeeCard from './EmployeeCard';

const employees = [
  { id: 1, name: 'Alice Johnson', role: 'Software Engineer', department: 'Engineering' },
  { id: 2, name: 'Bob Smith', role: 'Product Manager', department: 'Product' },
  { id: 3, name: 'Charlie Brown', role: 'Designer', department: 'Design' },
  { id: 4, name: 'Diana Prince', role: 'Data Analyst', department: 'Analytics' }
];

function EmployeesList() {
  return (
    <div>
      <h2>Employees List</h2>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
