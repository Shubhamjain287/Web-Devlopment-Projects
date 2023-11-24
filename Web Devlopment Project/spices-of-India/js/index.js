let cartItems=[];
let  cartTotal=0;
const updateCount=document.querySelector('.notifiCount');
function addToCart(productName,price,ImageUrl)
{
    const existingItem = cartItems.find(item => item.name === productName);
    
    if(existingItem)
    {
        existingItem.quantity+=1;
        existingItem.total = existingItem.quantity * price;
       

    }
    else{
    cartItems.push({
        name:productName,
        price:price,
        quantity:1,
        total:price,
        ImageUrl:ImageUrl
    });
    updateCount.innerHTML=cartItems.length;
}
    updateUI();

}
function updateUI()
{
    const cartItemsEle=document.getElementById('cart-items');
    const cartTotalprice=document.getElementById('cart-total');

    cartItemsEle.innerHTML='';
    cartTotal=0;
    cartItems.forEach(item=>{
        const listItem=document.createElement('li');

        const imageEle=document.createElement('img');
        imageEle.src=item.ImageUrl;
        imageEle.alt=item.name;
        imageEle.style.width='50px';

        const itemName=document.createElement('h4');
        itemName.innerText=item.name;

        const quan=document.createElement('p');
        quan.textContent=" x " +item.quantity;

        listItem.appendChild(imageEle);
        listItem.appendChild(itemName);
        listItem.appendChild(quan);
        listItem.appendChild(document.createTextNode(` $${item.total.toFixed(2)}`));
        cartItemsEle.appendChild(listItem);
        cartTotal+=item.total;
    });
    cartTotalprice.textContent = cartTotal.toFixed(2);
}

document.getElementById('menu-btn').addEventListener('click', function () {
    var navbar = document.querySelector('.navbar');
    if (navbar.style.display === 'block') {
        navbar.style.display = 'none';
    } else {
        navbar.style.display = 'block';
    }
});
const cartButton = document.getElementById('cart-btn');
const cart = document.getElementById('cart');

cartButton.addEventListener('click', function () {
    if (cartItems.length > 0) {
        cart.style.display = 'block';
    } else {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Empty Cart !",
            
          });
    }
});

document.addEventListener('click', function (event) {
    if (!cart.contains(event.target) && event.target !== cartButton) {
        cart.style.display = 'none';
    }
});
document.getElementById('contact-btn').addEventListener('click', function () {
    var inputElement = document.getElementById('name-box');
    var inputEmail = document.getElementById('email-box');
    var inputNumber = document.getElementById('number-box');
    var name = inputElement.value;
    var email=inputEmail.value;
    var number=inputNumber.value;
    if(name==='' || email==='' || number==='' )
    {
        Swal.fire({
            icon: "error",
            title: "Soory...",
            text: "Please fill your all details !",
            
          });
    }
    else{
      
    Swal.fire({
        position: "center",
        icon: "success",
        title: "Thanku for filling details !",
        showConfirmButton: false,
        timer: 1500
      });
    }
});

document.getElementById('checkout').addEventListener('click',function()
{
    Swal.fire({
        position: "center",
        icon: "success",
        title: "Order Placed",
        showConfirmButton: false,
        timer: 1500
      });
});