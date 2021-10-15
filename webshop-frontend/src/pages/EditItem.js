import { useEffect, useState, useRef } from 'react';

function EditItem(props) {
  const nameInputRef = useRef();
    const priceInputRef = useRef();
    const categoryInputRef = useRef();
    const idInputRef = useRef();


  console.log(window.location.href.split("edit/")[1]);
  const itemId = window.location.href.split("edit/")[1];

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

  function onEditItem(event) {
    event.preventDefault();

    const nameValue = nameInputRef.current.value;
    const priceValue = priceInputRef.current.value;
    const categoryValue = categoryInputRef.current.value;
    const idValue = idInputRef.current.value;


    const item = {
                    id: idValue,
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
        window.location.href = "/admin";
  }

  return(<div><h1>Lisa uus ese</h1>
    <form onSubmit={onEditItem}>
        <input hidden type="text" readOnly value={loadedItem.id} ref={idInputRef} /><br/>
        <label>Pealkiri</label><br/>
        <input type="text" defaultValue={loadedItem.name} ref={nameInputRef} /><br/>
        <label>Hind</label><br/>
        <input type="text" defaultValue={loadedItem.price} ref={priceInputRef} /><br/>
        <label>Kategooria</label><br/>
        <input type="text" defaultValue={loadedItem.category} ref={categoryInputRef} /><br/>
        <button>Lisa</button>
    </form></div>)
}

export default EditItem;