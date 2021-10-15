import { useRef } from 'react';
import { Link } from 'react-router-dom';

function AddItem() {
    const nameInputRef = useRef();
    const priceInputRef = useRef();
    const categoryInputRef = useRef();

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

        fetch('http://localhost:8080/add-item',
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
        <Link to="admin">
            <button>Tagasi</button>
        </Link>
        <h1>Lisa uus ese</h1>
        <form onSubmit={onSubmitItem}>
            <label>Pealkiri</label><br/>
            <input type="text" ref={nameInputRef} /><br/>
            <label>Hind</label><br/>
            <input type="text" ref={priceInputRef} /><br/>
            <label>Kategooria</label><br/>
            <input type="text" ref={categoryInputRef} /><br/>
            <button>Lisa</button>
        </form>
    </div>)
}

export default AddItem;