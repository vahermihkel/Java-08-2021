import Item from './Item';

function ItemList(props) {
    return (<div>
        {props.items.map(item=> (
            <Item 
                key={item.title} 
                name={item.title} 
                price={item.price} 
                category={item.category} />
        ))}
        </div>);
}

export default ItemList;