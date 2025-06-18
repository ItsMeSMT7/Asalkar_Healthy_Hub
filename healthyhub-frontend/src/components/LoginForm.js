import React, { useState } from 'react';
import BASE_URL from '../config';

const LoginForm = () => {
  const [form, setForm] = useState({ email: '', password: '' });

  const handleLogin = async (e) => {
    e.preventDefault();

    const res = await fetch(`${BASE_URL}/auth/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form)
    });

    const result = await res.text();
    if (result.includes("successful")) {
      localStorage.setItem("userEmail", form.email);
      alert("Login successful");
    } else {
      alert("Login failed");
    }
  };

  return (
    <form onSubmit={handleLogin}>
      <input type="email" placeholder="Email" onChange={e => setForm({ ...form, email: e.target.value })} />
      <input type="password" placeholder="Password" onChange={e => setForm({ ...form, password: e.target.value })} />
      <button type="submit">Login</button>
    </form>
  );
};

export default LoginForm;
