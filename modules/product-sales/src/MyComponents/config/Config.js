import React, { useState } from "react";
import ClayCard, { ClayCardWithInfo } from "@clayui/card";
import ClayButton from "@clayui/button";
import TypeCreateModal from "./modalType/TypeCreateModal";
import { DeleteTypeByID } from "../../resourceRequests/TypeFunctions";
import CategoryCreateModal from "./modalCategory/CategoryCreateModal";
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
  const [showCreateModalCategory, setShowCreateModalCategory] = useState(false);


  function handleModalCreateType() {
    setShowCreateModalType(true);
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
      <CategoryCreateModal
        showCreateModalCategory={showCreateModalCategory}
        setShowCreateModalCategory={setShowCreateModalCategory}
        addCategory={addCategory}
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
                  symbol="tag"
                  labels={[
                    item.tax ? {
                      displayType: "info",
                      value: `Taxa: ${item.tax*100}%`,
                    } : {
                      displayType: "success",
                      value: `Taxa zero`,
                    }
                  ]}
                />
              </div>
            ))}
          </div>
          <ClayButton
            displayType="primary"
            onClick={handleModalCreateType}
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
                  symbol="categories"
                  labels={[
                    item.tax ? {
                      displayType: "info",
                      value: `Taxa: ${item.tax*100}%`,
                    } : {
                      displayType: "success",
                      value: `Taxa zero`,
                    }
                  ]}
                />
              </div>
            ))}
          </div>
          <ClayButton
            displayType="primary"
            onClick={handleModalCreateCategory}
          >
            Create Category
          </ClayButton>
        </ClayCard.Body>
      </ClayCard>
    </div>
  );
}
