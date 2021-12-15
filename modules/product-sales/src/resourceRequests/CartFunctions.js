const test = btoa("test@liferay.com:test");
export function GetAllCarts() {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/cart/getAll`,
    {
      method: "GET",
      headers: { Authorization: "Basic " + test },
    }
  ).then((res) => res.json());
}

export function GetAllProductsByCartId(cartId) {
  return Liferay.Util.fetch(
    `  http://localhost:8080/o/RestBuilder/v1.0/cart/${cartId}`,
    {
      method: "GET",
      headers: { Authorization: "Basic " + test },
    }
  ).then((res) => res.json());
}

export function CreateCart() {

  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/cart/create/`,
    {
      method: "GET",
      headers: {
        Authorization: "Basic " + test,
      }
    }
  ).then((res) => res.json());
}

export function getTotalValueByCartId(cartId){
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/cart/getTotalValue/${cartId}`,
    {
      method: "GET",
      headers: {
        Authorization: "Basic " + test,
      }
    }
  ).then((res) => res.json());
}

export function DeleteCartByID(cartId) {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/cart/delete/${cartId}`,
    {
      method: "DELETE",
      headers: { Authorization: "Basic " + test },
    }
  );
}

export function RemoveProduct(cartId, productId) {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/removeProduct/carts/${cartId}/products/${productId}
    `,
    {
      method: "POST",
      headers: {
        Authorization: "Basic " + test,
      },
    }
  ).then((res) => res.json());
}
