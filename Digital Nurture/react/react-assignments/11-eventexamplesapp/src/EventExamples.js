import React from 'react';

class EventExamples extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0, message: '' };
  }

  increment = () => {
    const newCount = this.state.count + 1;
    this.setState({ count: newCount, message: `Hello! Count is ${newCount}` });
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayWelcome = (msg) => {
    this.setState({ message: msg });
  };

  handleClick = (e) => {
    this.setState({ message: 'I was clicked' });
  };

  render() {
    return (
      <div>
        <h2>Event Examples</h2>
        <p>Count: {this.state.count}</p>
        <p>Message: {this.state.message}</p>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <button onClick={() => this.sayWelcome('Welcome to React!')}>Say Welcome</button>
        <button onClick={this.handleClick}>Click me</button>
      </div>
    );
  }
}

export default EventExamples;
