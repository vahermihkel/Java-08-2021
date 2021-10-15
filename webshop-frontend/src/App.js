import './App.css';
import {Route} from 'react-router-dom';
import Navbar from './components/Navbar'
import Home from './pages/Home';
import Cart from './pages/Cart';
import AddItem from './pages/AddItem';
import AdminHome from './pages/AdminHome';
import SingleItem from './pages/SingleItem';
import EditItem from './pages/EditItem';

function AppComponent() {
  return (
    <div className="AppClass">
      <Navbar />
        {/* localhost:3000/ - siis näitab Home component sisu
          Home componenti ta leiab üles ülemise import kaudu */}
      <Route path="/" exact>
        <Home />
      </Route>
      {/* localhost:3000/ostukorv - siis näitab Cart component sisu
          Cart componenti ta leiab üles ülemise import kaudu */}
      <Route path="/ostukorv">
        <Cart />
      </Route>
      <Route path="/lisa-ese">
        <AddItem />
      </Route>
      <Route path="/admin">
        <AdminHome />
      </Route>
      <Route path="/view/:itemId">
        <SingleItem />
      </Route>
      <Route path="/edit/:itemId">
        <EditItem />
      </Route>
    </div>
  );
}

export default AppComponent;
