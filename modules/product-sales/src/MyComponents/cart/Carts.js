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
export default function Carts({ cartList, addCart, deleteCart }) {
  const [showRemoveproductsModal, setShowRemoveproductsModal] = useState(false);
  const [cartIdSelected, setCartIdSelected] = useState([]);
  const [showFinishedBuyModal, setShowFinishedBuyModal] = useState(false);
  const [productsInCartList, setProductsInCartList] = useState([]);
  const [totalValue, setTotalValue] = useState(0)

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
                      href: "#",
                      label: "Delete",
                      onClick: () => {
                        DeleteCartByID(item.id), deleteCart(item.id);
                      },
                    },
                  ]}
                  title={item.id}
                />
              </div>
            ))}
          </div>
          <ClayButton
            displayType="primary"
            onClick={() => {
              CreateCart().then((data) => addCart(data));
            }}
          >
            Create Cart
          </ClayButton>
        </ClayCard.Body>
      </ClayCard>
    </div>
  );
}
