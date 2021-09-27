function Item(props) {
    return(<div>
        <div>{props.name}</div>
        <div>{props.price}</div>
        <div>{props.category}</div>
        <button>Lisa ostukorvi</button>
        <br /><br />
        </div>)
}

export default Item;