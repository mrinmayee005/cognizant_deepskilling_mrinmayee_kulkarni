import Trainer from './trainer';

const trainers = [
  new Trainer(1, 'John Doe', 'john@example.com', '123-456-7890', 'React', ['JavaScript', 'HTML', 'CSS']),
  new Trainer(2, 'Jane Smith', 'jane@example.com', '234-567-8901', 'Angular', ['TypeScript', 'RxJS', 'SCSS']),
  new Trainer(3, 'Bob Johnson', 'bob@example.com', '345-678-9012', 'Vue', ['JavaScript', 'Vuex', 'Webpack']),
  new Trainer(4, 'Alice Williams', 'alice@example.com', '456-789-0123', 'Node.js', ['Express', 'MongoDB', 'REST API']),
  new Trainer(5, 'Charlie Brown', 'charlie@example.com', '567-890-1234', 'Python', ['Django', 'Flask', 'SQL']),
];

export default trainers;
