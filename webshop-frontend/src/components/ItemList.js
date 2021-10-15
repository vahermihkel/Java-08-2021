import Item from './Item';

            // props abil võetakse muutujad vastu kust teda välja kutsutakse
            // <ItemList midagi="asdas" /> siis pean võtma selle kasutusele
            // props.midagi abil ja saan props.midagi väärtuseks "asdas"

            // .map() on tavaline JavaScripti funktsionaalsus ja see muudab
            // iga elementi ja paneb talle asemele mingi muu väärtuse
            // praegusel juhul võetakse üks element: {price: 1, title: "Ese"}
            // ja pannakse selle asemele <Item price=1 title="Ese" />

            // Itemi sees peab ka olema props, kus omakorda võetakse kasutusele
            // props.price ja props.title

function ItemList(props) {
    function onDelete(itemId) {
        console.log(itemId);
        props.onDeleteItem(itemId);
        // onDelete läks käima
        // kutsu välja kes sind välja kutsus (AdminHome) ja võta sealt props
        // pane käima onDeleteItem
        // sinna saada kaasa itemId
    }

    // deleteItemisse tuli käimapanek props.deleteItem kaudu ja pane käima
    // onDelete
    return (<div className="item-list">
        {props.items.map(element=> (
            <Item 
                isAddToCartButton={props.isAddToCart}
                key={element.id} 
                id={element.id}
                name={element.name} 
                price={element.price} 
                category={element.category}
                deleteItem={onDelete} />
        ))}
        </div>);
}

export default ItemList;