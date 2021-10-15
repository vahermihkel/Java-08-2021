import {Link} from 'react-router-dom';

function Navbar() {
    return (<div className="navbar">
         <Link to="/">
            <img className="logo" src="webshio.png" alt="" />
        </Link>
        <Link to="/admin">
            <button>Admini vaatesse</button>
        </Link>
        <Link to="ostukorv">
            <img className="cart-button" src="shopping-cart.svg" alt="" />
        </Link>
    </div>);
}

export default Navbar;