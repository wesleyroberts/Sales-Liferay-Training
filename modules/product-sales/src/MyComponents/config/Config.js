import React, { useState } from "react";
import ClayCard, { ClayCardWithInfo } from "@clayui/card";
import ClayButton from "@clayui/button";
import ClayTable from "@clayui/table";
import TypeCreateModal from "./modalType/TypeCreateModal";
import { DeleteTypeByID } from "../../resourceRequests/TypeFunctions";
import TypeEditModal from "./modalType/TypeEditModal";
import CategoryCreateModal from "./modalCategory/CategoryCreateModal";
import CategoryEditModal from "./modalCategory/CategoryEditModal";
import { DeleteCategoryByID } from "../../resourceRequests/CategoryFunctions";
export default function Config({
  typesList,
  categoryList,
  addCategory,
  deleteCategory,
  addType,
  deleteType,
}) {
  const [showCreateModalType, setShowCreateModalType] = useState(false);
  const [showEditModalType, setShowEditModalType] = useState(false);
  const [objModalEditType, setObjModelEditType] = useState({
    name: "",
    tax: "",
    id: "",
  });
  const [showCreateModalCategory, setShowCreateModalCategory] = useState(false);
  const [showEditModalCategory, setShowEditModalCategory] = useState(false);
  const [objModalEditCategory, setObjModelEditCategory] = useState({
    name: "",
    tax: "",
    id: "",
  });

  function handleModalEditType(name, tax, id) {
    setShowEditModalType(true);
    setObjModelEditType({
      name: name,
      tax: tax,
      id: id,
    });
  }

  function handleModalCreateType() {
    setShowCreateModalType(true);
  }

  function handleModalEditCategory(name, tax, id) {
    setShowEditModalCategory(true);
    setObjModelEditCategory({
      name: name,
      tax: tax,
      id: id,
    });
  }

  function handleModalCreateCategory() {
    setShowCreateModalCategory(true);
  }

  return (
    <div>
      <TypeCreateModal
        showCreateModalType={showCreateModalType}
        setShowCreateModalType={setShowCreateModalType}
        addType={addType}
      />
      <TypeEditModal
        showEditModalType={showEditModalType}
        setShowEditModalType={setShowEditModalType}
        objModalEditType={objModalEditType}
      />
      <CategoryCreateModal
        showCreateModalCategory={showCreateModalCategory}
        setShowCreateModalCategory={setShowCreateModalCategory}
        addCategory={addCategory}
      />
      <CategoryEditModal
        showEditModalCategory={showEditModalCategory}
        setShowEditModalCategory={setShowEditModalCategory}
        objModalEditCategory={objModalEditCategory}
      />
      <ClayCard>
        <ClayCard.Body>
          <div className="row">
            {typesList.map((item, index) => (
              <div className="col-md-3" key={index}>
                <ClayCardWithInfo
                  key={index}
                  id={index}
                  actions={[
                    {
                      label: "edit",
                      onClick: () => {
                        handleModalEditType(item.name, item.tax, item.id);
                      },
                    },
                    { type: "divider" },
                    {
                      href: "#",
                      label: "Delete",
                      onClick: () => {
                        DeleteTypeByID(item.id), deleteType(item.id);
                      },
                    },
                  ]}
                  stickerProps={{
                    content: "TAX",
                    displayType: "danger",
                  }}
                  title={item.name}
                />
              </div>
            ))}
          </div>
          <ClayButton
            displayType="primary"
            onClick={() => handleModalCreateType()}
          >
            Create Type
          </ClayButton>
        </ClayCard.Body>
      </ClayCard>
      <ClayCard>
        <ClayCard.Body>
          <div className="row">
            {categoryList.map((item, index) => (
              <div className="col-md-3" key={index}>
                <ClayCardWithInfo
                  key={index}
                  id={index}
                  actions={[
                    {
                      label: "edit",
                      onClick: () => {
                        handleModalEditCategory(item.name, item.tax, item.id);
                      },
                    },
                    { type: "divider" },
                    {
                      href: "#",
                      label: "Delete",
                      onClick: () => {
                        DeleteCategoryByID(item.id), deleteCategory(item.id);
                      },
                    },
                  ]}
                  stickerProps={{
                    content: "Category",
                    displayType: "danger",
                  }}
                  title={item.name}
                />
              </div>
            ))}
          </div>
          <ClayButton
            displayType="primary"
            onClick={() => handleModalCreateCategory()}
          >
            Create Category
          </ClayButton>
        </ClayCard.Body>
      </ClayCard>
    </div>
  );
}
