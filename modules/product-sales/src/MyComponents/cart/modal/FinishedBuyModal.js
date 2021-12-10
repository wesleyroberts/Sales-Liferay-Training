import React from "react";
import ClayModal, { useModal } from "@clayui/modal";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";

export default function FinishedBuyModal({
  showFinishedBuyModal,
  setShowFinishedBuyModal,
  productsInCartList,
}) {
  const { observer, onClose } = useModal({
    onClose: () => setShowFinishedBuyModal(false),
  });
  return (
    <div>
      {showFinishedBuyModal && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Finalizar Compra"}</ClayModal.Header>
          <ClayModal.Body>
            <ClayTable>
              <ClayTable.Head>
                <ClayTable.Row>
                  <ClayTable.Cell expanded headingCell>
                    {"Produtos "}
                  </ClayTable.Cell>
                  <ClayTable.Cell expanded headingCell>
                    {"preço "}
                  </ClayTable.Cell>
                  <ClayTable.Cell expanded headingCell>
                    {"categoria "}
                  </ClayTable.Cell>
                </ClayTable.Row>
              </ClayTable.Head>
              <ClayTable.Body>
                {productsInCartList.map((item, index) => (
                  <ClayTable.Row key={index}>
                    <ClayTable.Cell headingTitle>{item.name}</ClayTable.Cell>
                    <ClayTable.Cell>{item.price}</ClayTable.Cell>
                    <ClayTable.Cell>{item.category.name}</ClayTable.Cell>
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
