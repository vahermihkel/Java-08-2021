import { useRef } from 'react';

function AddItem() {
    const nameInputRef = useRef();
    const priceInputRef = useRef();
    const categoryInputRef = useRef();

    function onSubmitItem(event) {
        event.preventDefault();

        const nameValue = nameInputRef.current.value;
        const priceValue = priceInputRef.current.value;
        const categoryValue = categoryInputRef.current.value;

        console.log(nameValue);
        console.log(priceValue);
        console.log(categoryValue);
    }

    return(<div>
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