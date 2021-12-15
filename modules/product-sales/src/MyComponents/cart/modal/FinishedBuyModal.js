import React from "react";
import ClayModal, { useModal } from "@clayui/modal";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";

export default function FinishedBuyModal({
  showFinishedBuyModal,
  setShowFinishedBuyModal,
  productsInCartList,
  totalValue
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
                    {"Categoria "}
                  </ClayTable.Cell>
                  <ClayTable.Cell expanded headingCell>
                    {"Preço "}
                  </ClayTable.Cell>
                </ClayTable.Row>
              </ClayTable.Head>
              <ClayTable.Body>
                {productsInCartList.map((item, index) => (
                  <ClayTable.Row key={index}>
                    <ClayTable.Cell headingTitle>{item.name}</ClayTable.Cell>
                    <ClayTable.Cell>{item.category.name}</ClayTable.Cell>
                    <ClayTable.Cell>{item.price}</ClayTable.Cell>
                  </ClayTable.Row>
                ))}
                <ClayTable.Row>
                  <ClayTable.Cell expanded headingCell>
                    {"Total "}
                  </ClayTable.Cell>
                  <ClayTable.Cell expanded headingCell />
                  <ClayTable.Cell expanded>
                    {totalValue}
                  </ClayTable.Cell>
                </ClayTable.Row>
              </ClayTable.Body>
            </ClayTable>
          </ClayModal.Body>
          <ClayModal.Footer
            first={<ClayButton onClick={onClose} displayType="secondary">{"Fechar"}</ClayButton>}
            last={<ClayButton onClick={onClose} displayType="primary">{"Finalizar Compra"}</ClayButton>}
          />
        </ClayModal>
      )}
    </div>
  );
}
