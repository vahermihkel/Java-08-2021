import { useEffect, useState } from "react";
import Item from "../components/Item";


function SingleItem() {
  const [item, setItem] = useState(null);

  const itemId = window.location.href.split("view/")[1];

  useEffect(()=>{
    fetch("http://localhost:8080/view-item/" + itemId).then(response => {
      return response.json();
    }).then(data => {
      setItem(data);
    })
  },[])
  
  if (item == null) {
    return "Loading";
  }

  return(<div> <Item name={item.name} price={item.price} isAddToCartButton={true} /> </div>)
}

export default SingleItem;