import React from 'react';

class ComplaintRegister extends React.Component {
  constructor(props) {
    super(props);
    this.state = { employeeName: '', complaint: '', refNumber: '' };
  }

  handleNameChange = (e) => {
    this.setState({ employeeName: e.target.value });
  };

  handleComplaintChange = (e) => {
    this.setState({ complaint: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const refNumber = 'REF' + Date.now().toString().slice(-8);
    this.setState({ refNumber });
    alert(`Complaint registered successfully!\nReference Number: ${refNumber}`);
  };

  render() {
    return (
      <div>
        <h2>Complaint Register</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Employee Name:</label>
            <input
              type="text"
              value={this.state.employeeName}
              onChange={this.handleNameChange}
              placeholder="Enter your name"
              required
            />
          </div>
          <div>
            <label>Complaint:</label>
            <textarea
              value={this.state.complaint}
              onChange={this.handleComplaintChange}
              placeholder="Describe your complaint"
              required
            />
          </div>
          <button type="submit">Submit Complaint</button>
        </form>
        {this.state.refNumber && (
          <div>
            <h3>Complaint Submitted</h3>
            <p>Reference Number: <strong>{this.state.refNumber}</strong></p>
          </div>
        )}
      </div>
    );
  }
}

export default ComplaintRegister;
