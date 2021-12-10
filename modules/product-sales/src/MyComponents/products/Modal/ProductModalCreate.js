import React, { useState } from "react";
import { PostProduct } from "../../../resourceRequests/ProductFunctionsREST";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import { ClaySelect } from "@clayui/form";

export default function ProductModalCreate({
  typesList,
  categoryList,
  showCreateModal,
  setShowCreateModal,
  addProduct,
}) {
  const [name, setName] = useState("");
  const [category, setCategory] = useState("1");
  const [type, setType] = useState("1");
  const [id, setId] = useState(0);
  const [price, setPrice] = useState(0);

  const { observer, onClose } = useModal({
    onClose: () => setShowCreateModal(false),
  });

  return (
    <div>
      {showCreateModal && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Create Product"}</ClayModal.Header>
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
                <label htmlFor="basicInput">Category</label>
                <ClaySelect
                  aria-label="Select Label"
                  id="mySelectId1"
                  onChange={(e) => {
                    setCategory(e.target.value);
                  }}
                >
                  {categoryList.map((item, index) => (
                    <ClaySelect.Option
                      key={index}
                      label={item.name}
                      value={item.id}
                    />
                  ))}
                </ClaySelect>
                <label htmlFor="basicInput">Type</label>
                <ClaySelect
                  aria-label="Select Label"
                  id="mySelectId2"
                  onChange={(e) => {
                    setType(e.target.value);
                  }}
                >
                  {typesList.map((item, index) => (
                    <ClaySelect.Option
                      key={index}
                      label={item.name}
                      value={item.id}
                    />
                  ))}
                </ClaySelect>
                <label htmlFor="basicInput">Price</label>
                <ClayInput
                  type="number"
                  onChange={(e) => {
                    setPrice(e.target.value);
                  }}
                ></ClayInput>
                <label htmlFor="basicInput">product Id</label>
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
                  PostProduct(
                    name,
                    price,
                    id,
                    parseInt(category),
                    parseInt(type)
                  ).then((data) => addProduct(data));
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
