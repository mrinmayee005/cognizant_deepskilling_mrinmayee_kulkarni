import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import './App.css';

function App() {
  const [selectedComponent, setSelectedComponent] = useState('book');

  let componentToRender;

  // 1. if/else approach
  if (selectedComponent === 'book') {
    componentToRender = <BookDetails />;
  } else if (selectedComponent === 'blog') {
    componentToRender = <BlogDetails />;
  } else {
    componentToRender = <CourseDetails />;
  }

  return (
    <div className="App">
      <h1>Project 13: Blogger App</h1>
      <div>
        <button onClick={() => setSelectedComponent('book')}>Book Details</button>
        <button onClick={() => setSelectedComponent('blog')}>Blog Details</button>
        <button onClick={() => setSelectedComponent('course')}>Course Details</button>
      </div>

      {/* 1. if/else rendered via element variable */}
      {componentToRender}

      <hr />

      <h3>Ternary Operator Example</h3>
      {/* 2. ternary operator */}
      {selectedComponent === 'book' ? (
        <p>Showing Book Details via ternary</p>
      ) : selectedComponent === 'blog' ? (
        <p>Showing Blog Details via ternary</p>
      ) : (
        <p>Showing Course Details via ternary</p>
      )}

      <h3>&& Operator Example</h3>
      {/* 3. && operator */}
      {selectedComponent === 'book' && <p>This is rendered with && operator (Book)</p>}
      {selectedComponent === 'blog' && <p>This is rendered with && operator (Blog)</p>}
      {selectedComponent === 'course' && <p>This is rendered with && operator (Course)</p>}

      <h3>Element Variables Example</h3>
      {/* 4. element variables */}
      {(() => {
        let elem;
        switch (selectedComponent) {
          case 'book':
            elem = <p>Element variable: Book Details</p>;
            break;
          case 'blog':
            elem = <p>Element variable: Blog Details</p>;
            break;
          case 'course':
            elem = <p>Element variable: Course Details</p>;
            break;
        }
        return elem;
      })()}
    </div>
  );
}

export default App;
