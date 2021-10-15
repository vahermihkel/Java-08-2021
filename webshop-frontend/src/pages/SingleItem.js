import { useEffect, useState } from 'react';
import Item from '../components/Item';

function SingleItem(props) {
  console.log(window.location.href.split("view/")[1]);
  const itemId = window.location.href.split("view/")[1];

  const [loadedItem, setLoadedItem] = useState(null);
  const [isLoading, setLoading] = useState(true);
  const [message, setMessage] = useState("");

    useEffect(()=>{
        fetch('http://localhost:8080/view-item/' + itemId).then(res => {
            return res.json();
        }).then(data => {
            console.log(data);
            if (!data.httpStatus) {
              setLoadedItem(data);
            } else {
              setMessage(data.message);
            }
            setLoading(false);
        })
    },[])

  if (isLoading) {
    return(<div>Loading...</div>)
  }

  if (loadedItem == null) {
    return message;
  }

  return(<div><Item 
    isAddToCartButton={true}
    key={loadedItem.id} 
    id={loadedItem.id}
    name={loadedItem.name} 
    price={loadedItem.price} 
    category={loadedItem.category} /></div>)
}

export default SingleItem;