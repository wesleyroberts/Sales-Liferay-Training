import React from "react";
import ClayForm, { ClayInput } from "@clayui/form";
import ClayButton from "@clayui/button";
import ClayModal, { useModal } from "@clayui/modal";
export default function CategoryEditModal({
  showEditModalCategory,
  setShowEditModalCategory,
  objModalEditCategory,
}) {
  const { observer, onClose } = useModal({
    onClose: () => setShowEditModalCategory(false),
  });
  return (
    <div>
      {showEditModalCategory && (
        <ClayModal observer={observer} size="lg" status="info">
          <ClayModal.Header>{"Edit Product"}</ClayModal.Header>
          <ClayModal.Body>
            <ClayForm>
              <ClayForm.Group className="form-group-sm">
                <label htmlFor="basicInput">Name</label>
                <ClayInput
                  type="text"
                  defaultValue={objModalEditCategory.name}
                  onChange={(e) => {
                    // setHeadline(e.target.value);
                  }}
                ></ClayInput>
                <label htmlFor="basicInput">Tax</label>
                <ClayInput
                  type="text"
                  defaultValue={objModalEditCategory.tax}
                  onChange={(e) => {
                    // setHeadline(e.target.value);
                  }}
                ></ClayInput>
                <label htmlFor="basicInput">Id</label>
                <ClayInput
                  type="text"
                  defaultValue={objModalEditCategory.id}
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
