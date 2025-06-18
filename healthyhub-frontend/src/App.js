import React from 'react';
import SignupForm from './components/SignupForm';
import LoginForm from './components/LoginForm';
import ProductList from './components/ProductList';

function App() {
  return (
    <div>
      <h1>Asalkar Healthy Hub</h1>
      <SignupForm />
      <LoginForm />
      <ProductList />
    </div>
  );
}

export default App;
