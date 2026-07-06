import React, { Component } from 'react';
import GitClient from './GitClient';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      repos: [],
      loading: true,
      error: null
    };
  }

  async componentDidMount() {
    try {
      const client = new GitClient();
      const repos = await client.getRepositories('octocat');
      this.setState({ repos, loading: false });
    } catch (err) {
      this.setState({ error: err.message, loading: false });
    }
  }

  render() {
    const { repos, loading, error } = this.state;

    if (loading) return <div className="loading">Loading repositories...</div>;
    if (error) return <div className="error">Error: {error}</div>;

    return (
      <div className="App">
        <h1>GitHub Repositories for octocat</h1>
        <ul className="repo-list">
          {repos.map((repo) => (
            <li key={repo.id}>{repo.name}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default App;