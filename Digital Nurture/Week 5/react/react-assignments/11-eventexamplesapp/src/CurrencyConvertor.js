import React from 'react';

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = { rupees: '', euro: '' };
  }

  handleChange = (e) => {
    this.setState({ rupees: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const inr = parseFloat(this.state.rupees);
    if (!isNaN(inr)) {
      const euroVal = (inr * 0.011).toFixed(2);
      this.setState({ euro: `${this.state.rupees} INR = ${euroVal} EUR` });
    } else {
      this.setState({ euro: 'Please enter a valid number' });
    }
  };

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <input
            type="text"
            placeholder="Enter amount in INR"
            value={this.state.rupees}
            onChange={this.handleChange}
          />
          <button type="submit">Convert</button>
        </form>
        <p>{this.state.euro}</p>
      </div>
    );
  }
}

export default CurrencyConvertor;
