import React, { useState } from "react";
import ClayForm, { ClaySelect } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import { AddProductToCart } from "../../../resourceRequests/ProductFunctionsREST";

import { Alert } from "../../alert/CustomAlert"

export default function ProductAddToCartModal({
  cartList,
  productAddToCartModal,
  setProductAddToCartModal,
  productId,
}) {
  const [cartId, setCartId] = useState(0);
  const { observer, onClose } = useModal({
    onClose: () => setProductAddToCartModal(false),
  });
  const [enableButton, setEnableButton] = useState(true)
  const [alertAddtoCartSuccess, setAlertToCartSuccess] = useState(false)

  const handleAddtoCart = (cartId, productId) => {
    AddProductToCart(cartId, productId).then(
      (data) => {
        console.log(data);
        setAlertToCartSuccess(true)
      }
    ).catch(error => console.log(error));
  }

  return (
    <div>
      {productAddToCartModal && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Add to Cart"}</ClayModal.Header>
          <ClayModal.Body>
            <ClayForm>
              <ClayForm.Group className="form-group-sm">
                <label htmlFor="basicInput">Cart's</label>
                <ClaySelect
                  aria-label="Select Label"
                  id="mySelectId1"
                  onChange={(e) => {
                    setCartId(e.target.value);
                    if(e.target.value == 0){
                      setEnableButton(true);
                    }else{
                      setEnableButton(false);
                    }
                  }}
                >
                  <ClaySelect.Option
                      label={"Selecionar carrinho"}
                      value={0}
                    />
                  {cartList.map((item, index) => (
                    <ClaySelect.Option
                      key={index}
                      label={item.id}
                      value={item.id}
                    />
                  ))}
                </ClaySelect>
              </ClayForm.Group>
              <ClayButton
                className="btn-primary"
                displayType="primary"
                disabled={enableButton}
                onClick={() => {
                  handleAddtoCart(parseInt(cartId), parseInt(productId))
                }}
              >
                Adicionar
              </ClayButton>
            </ClayForm>
          </ClayModal.Body>
          <ClayModal.Footer
            first={<ClayButton.Group spaced></ClayButton.Group>}
            last={<ClayButton onClick={onClose}>{"Fechar"}</ClayButton>}
          />
          {alertAddtoCartSuccess && (
            <Alert displayType={"success"} title={"Success: "} message={"The product were successfully added to your cart"}>
              {setTimeout(() => setAlertToCartSuccess(false), 5000)}
            </Alert>
          )}
        </ClayModal>
      )}
    </div>
  );
}
