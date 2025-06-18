import React, { useEffect, useState } from 'react';
import BASE_URL from '../config';

const ProductList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch(`${BASE_URL}/products`)
      .then(res => res.json())
      .then(data => setProducts(data));
  }, []);

  const addToCart = async (productId) => {
    const userEmail = localStorage.getItem("userEmail");
    if (!userEmail) {
      alert("Login first");
      return;
    }

    const body = {
      userId: userEmail,
      items: [{ productId, quantity: 1 }]
    };

    const res = await fetch(`${BASE_URL}/cart/add`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body)
    });

    const result = await res.text();
    alert("Added to cart");
  };

  return (
    <div>
      <h2>Products</h2>
      {products.map(p => (
        <div key={p.id}>
          <h4>{p.name}</h4>
          <p>₹{p.price}</p>
          <button onClick={() => addToCart(p.id)}>Add to Cart</button>
        </div>
      ))}
    </div>
  );
};

export default ProductList;
