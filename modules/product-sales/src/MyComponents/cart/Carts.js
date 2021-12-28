import React, { useState } from "react";
import ClayCard, { ClayCardWithHorizontal } from "@clayui/card";
import ClayButton from "@clayui/button";
import {
  CreateCart,
  DeleteCartByID,
  GetAllProductsByCartId,
  getTotalValueByCartId
} from "../../resourceRequests/CartFunctions";
import RemoveProductsModal from "./modal/RemoveProductsModal";
import FinishedBuyModal from "./modal/FinishedBuyModal";
import { Alert } from "../alert/CustomAlert"

export default function Carts({ cartList, addCart, deleteCart }) {
  const [showRemoveproductsModal, setShowRemoveproductsModal] = useState(false);
  const [cartIdSelected, setCartIdSelected] = useState([]);
  const [showFinishedBuyModal, setShowFinishedBuyModal] = useState(false);
  const [productsInCartList, setProductsInCartList] = useState([]);
  const [totalValue, setTotalValue] = useState(0)
  const [alertAddtoCartSuccess, setAlertToCartSuccess] = useState(false)
  const [alertDeleteSuccess, setAlertDeleteSuccess] = useState(false)

  const removeProductOfList = (id) => {
    var res = [];
    productsInCartList.forEach((item) => {
      if (item.id !== id) res.push(item);
    });
    setProductsInCartList(res);
  };

  function handleModalRemoveProducts(cartId) {
    setCartIdSelected(cartId);
    GetAllProductsByCartId(cartId).then((data) =>
      setProductsInCartList([...data.productList])
    );
    setShowRemoveproductsModal(true);
  }

  function handleModalFinishedBuy(cartId) {
    GetAllProductsByCartId(cartId).then((data) => {
      setProductsInCartList([...data.productList])
    });
    getTotalValueByCartId(cartId).then((data) => {
      setTotalValue(data)
    })
    setShowFinishedBuyModal(true);
  }

  const handleCartCreate = () => {
    CreateCart().then((response) => {
      if(!response) {
        console.log(response)
        throw new Error(response.status)}
      else {
        addCart(response)
        setAlertToCartSuccess(true)
      }
    })
    .catch((error) => console.log("error:", error));
  }

  const handleCartDelete = (id) => {
    DeleteCartByID(id).then((response) => {
      if(!response.ok) {
        console.log(response)
        throw new Error(response.status)}
      else {
        deleteCart(id)
        setAlertDeleteSuccess(true)
      }
    })
    .catch((error) => console.log("error:", error));
  }

  return (
    <div>
      <FinishedBuyModal
        showFinishedBuyModal={showFinishedBuyModal}
        setShowFinishedBuyModal={setShowFinishedBuyModal}
        productsInCartList={productsInCartList}
        totalValue={totalValue}
      />
      <RemoveProductsModal
        showRemoveproductsModal={showRemoveproductsModal}
        setShowRemoveproductsModal={setShowRemoveproductsModal}
        productsInCartList={productsInCartList}
        cartIdSelected={cartIdSelected}
        removeProductOfList={removeProductOfList}
      />
      <ClayCard>
        <ClayCard.Body>
          <div className="row">
            {cartList.map((item, index) => (
              <div className="col-md-3" key={index}>
                <ClayCardWithHorizontal
                  actions={[
                    {
                      label: "Finalizar compras",
                      onClick: () => {
                        handleModalFinishedBuy(item.id);
                      },
                    },
                    { type: "divider" },
                    {
                      label: "Remover produtos",
                      onClick: () => {
                        handleModalRemoveProducts(item.id);
                      },
                    },
                    { type: "divider" },
                    {
                      label: "Delete",
                      onClick: () => handleCartDelete(item.id),
                    },
                  ]}
                  title={`Lista de desejos ${index+1}`}
                />
              </div>
            ))}
          </div>
          <ClayButton
            displayType="primary"
            onClick={handleCartCreate}
          >
            Create Cart
          </ClayButton>
        </ClayCard.Body>
      </ClayCard>
      {alertAddtoCartSuccess && (
            <Alert displayType={"success"} title={"Success: "} message={"The cart were successfully created"}>
              {setTimeout(() => setAlertToCartSuccess(false), 5000)}
            </Alert>
      )}
      {alertDeleteSuccess && (
            <Alert displayType={"success"} title={"Success: "} message={"The cart were successfully deleted"}>
              {setTimeout(() => setAlertDeleteSuccess(false), 5000)}
            </Alert>
      )}
    </div>
  );
}
