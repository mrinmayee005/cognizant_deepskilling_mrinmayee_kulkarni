import React, { Component } from 'react';

class Cart extends Component {
  render() {
    const { Itemname, Price } = this.props;
    return (
      <tr>
        <td>{Itemname}</td>
        <td>${Price}</td>
      </tr>
    );
  }
}

export default Cart;
