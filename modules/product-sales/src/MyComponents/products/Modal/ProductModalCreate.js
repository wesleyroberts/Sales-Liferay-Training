import React, { useState } from "react";
import { CreateProduct } from "../../../resourceRequests/ProductFunctionsREST";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
import { ClaySelect } from "@clayui/form";

import { Alert } from "../../alert/CustomAlert"

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
  const [price, setPrice] = useState(0);
  const [alertSuccess, setAlertSuccess] = useState(false)
  const [alertError, setAlertError] = useState(false)

  const { observer, onClose } = useModal({
    onClose: () => setShowCreateModal(false),
  });

  const handleProductCreate = () => {
    CreateProduct(
      name,
      price,
      parseInt(category),
      parseInt(type)
    ).then((response) => {
      if(response.status) throw new Error(JSON.stringify(response.status))
      else {
        addProduct(response)
        setAlertSuccess(true)
      }
    })
    .catch((error) => {console.log("error:", error); setAlertError(true)});
  }

  const handleCartCreateDisabled = () => {
    if(!name){
      return true
    }
    return false
  }

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
              </ClayForm.Group>
              <ClayButton
                displayType="primary"
                disabled={handleCartCreateDisabled()}
                onClick={handleProductCreate}
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
      {alertSuccess && (
        <Alert displayType={"success"} title={"Success: "} message={"The product were successfully created"}>
          {setTimeout(() => setAlertSuccess(false), 5000)}
        </Alert>
      )}
      {alertError && (
        <Alert displayType={"danger"} title={"Error: "} message={"The product couldn't be created"}>
          {setTimeout(() => setAlertError(false), 5000)}
        </Alert>
      )}
    </div>
  );
}
