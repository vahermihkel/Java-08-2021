import { useEffect, useRef, useState } from "react";

function EditItem() {
  const nameInputRef = useRef();
  const priceInputRef = useRef();
  const categoryInputRef = useRef();
 
  const [item, setItem] = useState(null);

  const itemId = window.location.href.split("edit/")[1];

  useEffect (()=>{
    fetch("http://localhost:8080/view-item/" + itemId).then(response => {
      return response.json();
    }).then(data => {
      setItem(data);
    })
  },[])
  
  if (item == null) {
    return "Loading";
  }

    function onSubmitItem(event) {
        event.preventDefault();

        const nameValue = nameInputRef.current.value;
        const priceValue = priceInputRef.current.value;
        const categoryValue = categoryInputRef.current.value;

        const item = {
                        name: nameValue, 
                        price: priceValue, 
                        category: categoryValue
                    }

        fetch('http://localhost:8080/edit-item',
                {
                    method: 'POST',
                    body: JSON.stringify(item),
                    headers: {
                        "Content-Type": "application/json"
                    }
                }
            )
    }

  return(<div>
            <h1>Muuda eset</h1>
        <form onSubmit={onSubmitItem}>
            <label>Pealkiri</label><br/>
            <input type="text" defaultValue={item.name} ref={nameInputRef} /><br/>
            <label>Hind</label><br/>
            <input type="text" defaultValue={item.price} ref={priceInputRef} /><br/>
            <label>Kategooria</label><br/>
            <input type="text" defaultValue={item.category} ref={categoryInputRef} /><br/>
            <button>Muuda</button>
        </form>
     </div>)
}
export default EditItem;