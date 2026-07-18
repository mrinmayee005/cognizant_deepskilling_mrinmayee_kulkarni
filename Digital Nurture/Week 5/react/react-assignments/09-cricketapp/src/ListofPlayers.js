import React from 'react';

const players = [
  { name: 'Virat Kohli', score: 85 },
  { name: 'Rohit Sharma', score: 72 },
  { name: 'Jasprit Bumrah', score: 15 },
  { name: 'Ravindra Jadeja', score: 45 },
  { name: 'KL Rahul', score: 68 },
  { name: 'Shubman Gill', score: 92 },
  { name: 'Rishabh Pant', score: 55 },
  { name: 'Hardik Pandya', score: 70 },
  { name: 'Mohammed Shami', score: 12 },
  { name: 'Yuzvendra Chahal', score: 8 },
  { name: 'Suryakumar Yadav', score: 90 },
];

function ListofPlayers() {
  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
      <h2>Players with Score &gt;= 70</h2>
      <ul>
        {players.filter((player) => player.score >= 70).map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
