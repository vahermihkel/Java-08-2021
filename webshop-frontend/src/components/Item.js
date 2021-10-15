// saadeti props kust teda välja kutsuti (ItemList)
// kujul: <Item name="ese" price=125 category="Kat" isAddToCartButton=false />

import { Link } from "react-router-dom";

// { props.isAddToCartButton ? 
// kas props.isAddToCartButton on "true"
// kui on, siis käivita rida mis on ? ja : vahel
// kui ei ole, siis käivita rida, mis on : järel
// lõppeb loogelise suluga
function Item(props) {
    function handleDelete(itemId) {
        // lehel parem klõps ja inspect (inspekteeri)
        // ülevalt tabidest vaade "console"
        // klikkides "kustuta nupule", tuleb console-sse "töötab"
        props.deleteItem(itemId);
        // mine selle juurde kes seda välja kutsus ja otsi üles deleteItem
    }

    // toimub buttonile click ja see paneb käima handleDelete funktsiooni ja saadab kaasa
    // props.id
    // props.id tuleb tegelikult Itemlistist
    return(<div className="item">
        <Link to={`view/${props.id}`}>   
            <div>{props.name}</div>
            <div>{props.price}</div>
            <div>{props.category}</div>
        </Link> 
        { props.isAddToCartButton ? 
             <button>Lisa ostukorvi</button> :
                <div>
                    <button onClick={()=>handleDelete(props.id)}>Kustuta toode</button> 
                    <Link to={`edit/${props.id}`}>   
                        <button>Muuda toodet</button>
                    </Link> 
                
                </div>
        }
       
     
        </div>)
}

export default Item;