import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [
        { Itemname: 'Laptop', Price: 999 },
        { Itemname: 'Mouse', Price: 25 },
        { Itemname: 'Keyboard', Price: 75 },
        { Itemname: 'Monitor', Price: 299 },
        { Itemname: 'Headphones', Price: 149 },
      ],
    };
  }

  render() {
    return (
      <div>
        <h1>Shopping Cart</h1>
        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {this.state.items.map((item, index) => (
              <Cart key={index} Itemname={item.Itemname} Price={item.Price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
