import React, { useState } from "react";
import ClayForm from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import ClaySlider from "@clayui/slider";
import { Alert } from "../../alert/CustomAlert";

export default function DeleteProductModal({
  stock,
  quantity,
  setQuantity,
  showDeleteModal,
  setShowDeleteModal,
}) {
  const [cartId, setCartId] = useState(0);
  const { observer, onClose } = useModal({
    onClose: () => setShowDeleteModal(false),
  });
  const [alertAddtoCartSuccess, setAlertToCartSuccess] = useState(false);

  // const handleProductDelete = (quantity, stockId) => {
  //   DeleteProductByID(id)
  //     .then((response) => {
  //       if (!response.ok) {
  //         throw new Error(response.status);
  //       } else {
  //         deleteProduct(id);
  //         setAlertDeleteSuccess(true);
  //       }
  //     })
  //     .catch((error) => console.log("error:", error));
  // };

  return (
    <div>
      {showDeleteModal && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Delete Product"}</ClayModal.Header>
          <ClayModal.Body>
            <ClayForm>
              <ClayForm.Group className="form-group-sm">
                <div className="form-group">
                  <label htmlFor="slider">{"quantidade de produtos"}</label>
                  <ClaySlider
                    id="slider"
                    onValueChange={setQuantity}
                    max={stock.quantity}
                    value={quantity}
                  />
                </div>
              </ClayForm.Group>
              <ClayButton
                className="btn-primary"
                displayType="primary"
                onClick={() => {
                  handleProductDelete(
                    parseInt(quantity),
                    parseInt(stock.id),
                    parseInt(cartId)
                  );
                }}
              >
                Deletar
              </ClayButton>
            </ClayForm>
          </ClayModal.Body>
          <ClayModal.Footer
            first={<ClayButton.Group spaced></ClayButton.Group>}
          />
          {alertAddtoCartSuccess && (
            <Alert
              displayType={"success"}
              title={"Success: "}
              message={"The product were successfully added to your cart"}
            >
              {setTimeout(() => setAlertToCartSuccess(false), 5000)}
            </Alert>
          )}
        </ClayModal>
      )}
    </div>
  );
}
