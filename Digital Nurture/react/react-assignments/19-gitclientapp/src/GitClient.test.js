import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe("Git Client Tests", () => {
  test("should return repository names for techiesyed", async () => {
    const mockedData = [
      { id: 1, name: 'repo1' },
      { id: 2, name: 'repo2' }
    ];
    axios.get.mockResolvedValue({ data: mockedData });

    const client = new GitClient();
    const result = await client.getRepositories('techiesyed');

    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
    expect(result).toEqual(mockedData);
  });
});