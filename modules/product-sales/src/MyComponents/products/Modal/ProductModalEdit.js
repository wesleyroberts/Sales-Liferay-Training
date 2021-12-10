import React from "react";
import ClayModal, { useModal } from "@clayui/modal";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
export default function ProductModal({
  showEditModal,
  setShowEditModal,
  objModal,
}) {
  const { observer, onClose } = useModal({
    onClose: () => setShowEditModal(false),
  });
  return (
    <div>
      {showEditModal && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Edit Product"}</ClayModal.Header>
          <ClayModal.Body>
            <ClayForm>
              <ClayForm.Group className="form-group-sm">
                <label htmlFor="basicInput">Name</label>
                <ClayInput
                  type="text"
                  defaultValue={objModal.name}
                  onChange={(e) => {
                    // setHeadline(e.target.value);
                  }}
                ></ClayInput>
                <label htmlFor="basicInput">Category</label>
                <ClayInput
                  type="text"
                  defaultValue={objModal.category}
                  onChange={(e) => {
                    // setHeadline(e.target.value);
                  }}
                ></ClayInput>
                <label htmlFor="basicInput">Type</label>
                <ClayInput
                  type="text"
                  defaultValue={objModal.type}
                  onChange={(e) => {
                    // setHeadline(e.target.value);
                  }}
                ></ClayInput>
                <label htmlFor="basicInput">Price</label>
                <ClayInput
                  type="text"
                  defaultValue={objModal.price}
                  onChange={(e) => {
                    // setHeadline(e.target.value);
                  }}
                ></ClayInput>
              </ClayForm.Group>
              <ClayButton
                displayType="primary"
                // onClick={() => {
                //   PUT(id, headlineShow, articleBodyShow).then((data) =>
                //     editBlog(id, data.headline, data.articleBody)
                //   );
                // }}
              >
                Alterar
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
