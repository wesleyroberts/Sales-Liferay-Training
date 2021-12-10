import React, { useState } from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import { CreateCategory } from "../../../resourceRequests/CategoryFunctions";

export default function CategoryCreateModal({
  showCreateModalCategory,
  setShowCreateModalCategory,
  addCategory,
}) {
  const [name, setName] = useState("");
  const [id, setId] = useState(0);
  const [tax, setTax] = useState(0);

  const { observer, onClose } = useModal({
    onClose: () => setShowCreateModalCategory(false),
  });

  return (
    <div>
      {showCreateModalCategory && (
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
                  CreateCategory(name, id, tax).then((data) =>
                    addCategory(data)
                  );
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
