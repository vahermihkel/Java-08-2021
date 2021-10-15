import { useEffect, useState } from 'react';
import {Link} from 'react-router-dom';
import ItemList from '../components/ItemList';

function AdminHome() {
    // esimene on muutuja, mida muudetakse
    // teine on muutev funktsioon (setter)

    // useState on Reacti Hook, mis kasutabki neid kahte asja
    // useState() sees tuleb anda algväärtus

    // iga kord kui kasutatakse setterit, siis Component laetakse uuesti
  const [loadedItems, setLoadedItems] = useState([]);

  // useEffect on samuti Reacti Hook
  // see takistab uuesti laadimist, sest muidu läheb praegu loopima
    useEffect(()=>{
            // ütlen aadressi kuhu päring teha
                            // then abil võtan selle mida ta tagastab
        fetch('http://localhost:8080/items').then(response => {
            // List<Item> teen JSON kujule
            return response.json();
        }).then(data => {
            // login JSON kujul oleva List<Item> välja
            console.log(data);
            // panen setteriga väärtuse loadedItemsile
            setLoadedItems(data);
        })
    },[])
        
    function makeDeleteRequest(itemId) {
        fetch("http://localhost:8080/delete-item/" + itemId, {
            method: 'DELETE'
        }).then(response => {
            return response.json();
        }).then(data => {
            setLoadedItems(data);
        });
    }

    // võtan kasutusele loadedItems muutuja ja saadan selle
    // ItemList componenti ja pean selle seal kasutusele võtma
    // props.items järgi
    return(<div>
        <Link to="lisa-ese">
            <button>Uut toodet lisama</button>
        </Link>
        <ItemList isAddToCart={false} items={loadedItems} onDeleteItem={makeDeleteRequest} />
        </div>)
}

export default AdminHome;