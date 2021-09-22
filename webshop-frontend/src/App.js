import './App.css';
import Navbar from './components/Navbar'
import Home from './pages/Home';
import Cart from './pages/Cart';
import {Route} from 'react-router-dom';

function AppComponent() {
  return (
    <div className="AppClass">
      <Navbar />
      <Route path="/" exact>
        <Home />
      </Route>
      <Route path="/ostukorv">
        <Cart />
      </Route>
      <Route path="/lisa-ese">
        <div>Siia tuleb add-item mis pole veel valmis</div>
      </Route>
    </div>
  );
}

export default AppComponent;
