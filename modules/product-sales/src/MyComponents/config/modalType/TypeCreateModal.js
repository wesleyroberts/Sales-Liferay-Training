import React, { useState } from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import { createType } from "../../../resourceRequests/TypeFunctions";
export default function TypeCreateModal({
  showCreateModalType,
  setShowCreateModalType,
  addType,
}) {
  const [name, setName] = useState("");
  const [id, setId] = useState(0);
  const [tax, setTax] = useState(0);

  const { observer, onClose } = useModal({
    onClose: () => setShowCreateModalType(false),
  });

  return (
    <div>
      {showCreateModalType && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Create Type"}</ClayModal.Header>
          <ClayModal.Body>
            <ClayForm>
              <ClayForm.Group className="form-group-sm">
                <label htmlFor="basicInput">Name</label>
                <ClayInput
                  type="text"
                  onChange={(e) => {
                    setName(e.target.value);
                  }}
                ></ClayInput>
                <label htmlFor="basicInput">Tax</label>
                <ClayInput
                  type="number"
                  onChange={(e) => {
                    setTax(e.target.value);
                  }}
                ></ClayInput>
                <label htmlFor="basicInput">Id</label>
                <ClayInput
                  type="number"
                  onChange={(e) => {
                    setId(e.target.value);
                  }}
                ></ClayInput>
              </ClayForm.Group>
              <ClayButton
                displayType="primary"
                onClick={() => {
                  createType(name, id, tax).then((data) => addType(data));
                }}
              >
                Criar
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
