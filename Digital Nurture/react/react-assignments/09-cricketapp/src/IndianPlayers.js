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

function IndianPlayers() {
  const [oddTeam, evenTeam] = players.reduce(
    ([odd, even], player, index) => {
      if ((index + 1) % 2 === 0) {
        return [odd, [...even, player]];
      } else {
        return [[...odd, player], even];
      }
    },
    [[], []]
  );

  const T20players = [
    { name: 'MS Dhoni', score: 60 },
    { name: 'Bhuvneshwar Kumar', score: 20 },
  ];

  const RanjiTrophy = [
    { name: 'Prithvi Shaw', score: 110 },
    { name: 'Cheteshwar Pujara', score: 88 },
  ];

  const mergedPlayers = [...T20players, ...RanjiTrophy];

  return (
    <div>
      <h2>Odd Team (Destructured)</h2>
      <ul>
        {oddTeam.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
      <h2>Even Team (Destructured)</h2>
      <ul>
        {evenTeam.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
      <h2>Merged Players (Spread Operator)</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;
