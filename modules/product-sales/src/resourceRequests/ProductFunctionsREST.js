const test = btoa("test@liferay.com:test");
export function GetAllProducts() {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/product/all`,
    {
      method: "GET",
      headers: { Authorization: "Basic " + test },
    }
  ).then((res) => res.json());
}

export function CreateProduct(name, price, category, type, quantity) {
  let product = {
    categoryId: category,
    name: name,
    price: price,
    typeId: type,
    quantity: quantity
  };
  console.log(product);
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/product/create`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Basic " + test,
      },
      body: JSON.stringify(product),
    }
  ).then((res) => res.json());
}

export function DeleteProductByID(productId) {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/product/delete/${productId}`,
    {
      method: "DELETE",
      headers: { Authorization: "Basic " + test },
    }
  );
}
export function AddProductToCart(quantity, stockId, cartID) {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/addProductoCart/${cartID}/sotckId/${stockId}/quantity/${quantity}`,
    {
      method: "PATCH",
      headers: {
        Authorization: "Basic " + test,
      },
    }
  ).then((res) => res.json());
}
