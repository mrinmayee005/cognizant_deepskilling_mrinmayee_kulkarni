import React, { Component } from 'react';

class GetUser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      this.setState({ user: data.results[0], loading: false });
    } catch (error) {
      console.error('Error fetching user:', error);
      this.setState({ loading: false });
    }
  }

  render() {
    const { user, loading } = this.state;

    if (loading) {
      return <div className="loading">Loading...</div>;
    }

    if (!user) {
      return <div>Failed to load user.</div>;
    }

    return (
      <div className="user-card">
        <img src={user.picture.large} alt="User" />
        <h2>{user.name.title} {user.name.first} {user.name.last}</h2>
        <p>Email: {user.email}</p>
      </div>
    );
  }
}

export default GetUser;