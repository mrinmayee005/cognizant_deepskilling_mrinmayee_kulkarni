import React, { Component } from 'react';

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      password: '',
      errors: {}
    };
  }

  handleChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  validate() {
    const errors = {};
    const { name, email, password } = this.state;

    if (!name || name.length < 5) {
      errors.name = 'Name must be at least 5 characters';
    }

    if (!email || !email.includes('@') || !email.includes('.')) {
      errors.email = 'Email must contain @ and .';
    }

    if (!password || password.length < 8) {
      errors.password = 'Password must be at least 8 characters';
    }

    return errors;
  }

  handleSubmit(e) {
    e.preventDefault();
    const errors = this.validate();
    if (Object.keys(errors).length > 0) {
      this.setState({ errors });
    } else {
      alert('Registration successful!');
      this.setState({ name: '', email: '', password: '', errors: {} });
    }
  }

  render() {
    const { name, email, password, errors } = this.state;
    return (
      <div>
        <h2>Register</h2>
        <form onSubmit={(e) => this.handleSubmit(e)}>
          <div>
            <label>Name</label>
            <input
              type="text"
              name="name"
              value={name}
              onChange={(e) => this.handleChange(e)}
            />
            {errors.name && <div className="error-text">{errors.name}</div>}
          </div>
          <div>
            <label>Email</label>
            <input
              type="email"
              name="email"
              value={email}
              onChange={(e) => this.handleChange(e)}
            />
            {errors.email && <div className="error-text">{errors.email}</div>}
          </div>
          <div>
            <label>Password</label>
            <input
              type="password"
              name="password"
              value={password}
              onChange={(e) => this.handleChange(e)}
            />
            {errors.password && <div className="error-text">{errors.password}</div>}
          </div>
          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}

export default Register;