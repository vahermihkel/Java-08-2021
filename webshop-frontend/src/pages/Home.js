import { useEffect, useState } from 'react';
import ItemList from '../components/ItemList';

function Home() {
    const [loadedItems, setLoadedItems] = useState([]);

    useEffect(()=>{
        fetch('http://localhost:8080/items').then(res => {
            return res.json();
        }).then(data => {
            console.log(data);
            setLoadedItems(data);
        })
    },[])
        

    return(<div>
        <ItemList isAddToCart={true} items={loadedItems} />
        </div>)
}

export default Home;