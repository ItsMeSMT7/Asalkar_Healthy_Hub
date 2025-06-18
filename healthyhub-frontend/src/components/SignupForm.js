import React, { useState } from 'react';
import BASE_URL from '../config';

const SignupForm = () => {
  const [form, setForm] = useState({ username: '', email: '', password: '' });

  const handleSubmit = async (e) => {
    e.preventDefault();

    const res = await fetch(`${BASE_URL}/auth/signup`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form)
    });

    const msg = await res.text();
    alert(msg);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input placeholder="Username" onChange={e => setForm({ ...form, username: e.target.value })} />
      <input type="email" placeholder="Email" onChange={e => setForm({ ...form, email: e.target.value })} />
      <input type="password" placeholder="Password" onChange={e => setForm({ ...form, password: e.target.value })} />
      <button type="submit">Sign Up</button>
    </form>
  );
};

export default SignupForm;
