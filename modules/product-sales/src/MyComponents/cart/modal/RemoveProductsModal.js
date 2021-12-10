import React from "react";
import ClayTable from "@clayui/table";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import { RemoveProduct } from "../../../resourceRequests/CartFunctions";
export default function RemoveProductsModal({
  showRemoveproductsModal,
  setShowRemoveproductsModal,
  productsInCartList,
  cartIdSelected,
  removeProductOfList,
}) {
  const { observer, onClose } = useModal({
    onClose: () => setShowRemoveproductsModal(false),
  });
  return (
    <div>
      {showRemoveproductsModal && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Lista de Produtos "}</ClayModal.Header>
          <ClayModal.Body>
            <ClayTable>
              <ClayTable.Head>
                <ClayTable.Row>
                  <ClayTable.Cell expanded headingCell>
                    {"Products "}
                  </ClayTable.Cell>
                </ClayTable.Row>
              </ClayTable.Head>
              <ClayTable.Body>
                {productsInCartList.map((item, index) => (
                  <ClayTable.Row key={index}>
                    <ClayTable.Cell headingTitle>{item.name}</ClayTable.Cell>
                    <ClayTable.Cell>
                      <ClayButton
                        displayType="secondary"
                        onClick={() => {
                          RemoveProduct(cartIdSelected, item.id),
                            removeProductOfList(item.id);
                        }}
                      >
                        Remover
                      </ClayButton>
                    </ClayTable.Cell>
                  </ClayTable.Row>
                ))}
              </ClayTable.Body>
            </ClayTable>
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
