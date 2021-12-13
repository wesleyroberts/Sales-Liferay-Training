import React, { useState } from "react";
import ClayForm, { ClaySelect } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import { AddProductToCart } from "../../../resourceRequests/ProductFunctionsREST";

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
  return (
    <div>
      {productAddToCartModal && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Create Product"}</ClayModal.Header>
          <ClayModal.Body>
            <ClayForm>
              <ClayForm.Group className="form-group-sm">
                <label htmlFor="basicInput">Cart's</label>
                <ClaySelect
                  aria-label="Select Label"
                  id="mySelectId1"
                  onChange={(e) => {
                    setCartId(e.target.value);
                  }}
                >
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
                displayType="primary"
                onClick={() => {
                  AddProductToCart(parseInt(cartId), parseInt(productId)).then(
                    (data) => {
                      console.log(data);
                    }
                  );
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
        </ClayModal>
      )}
    </div>
  );
}