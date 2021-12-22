import React from "react";
import { useState } from "react";
import { DeleteProductByID } from "../../resourceRequests/ProductFunctionsREST";
import ProductModalEdit from "./Modal/ProductModalEdit";
import ProductModalCreate from "./Modal/ProductModalCreate";
import ClayCard, { ClayCardWithInfo } from "@clayui/card";
import ClayButton from "@clayui/button";

import ProductAddToCartModal from "./Modal/ProductAddToCartModal";
import { Alert } from "../alert/CustomAlert"

export default function Products({
  productList,
  setProductList,
  typesList,
  categoryList,
  cartList,
  addProduct,
  deleteProduct,
}) {
  const [productAddToCartModal, setProductAddToCartModal] = useState(false);
  const [showEditModal, setShowEditModal] = useState(false);
  const [showCreateModal, setShowCreateModal] = useState(false);
  const [objModal, setObjModel] = useState({
    name: "",
    category: "",
    type: "",
    price: "",
  });
  const [productId, setproductId] = useState(0);
  const [alertDeleteSuccess, setAlertDeleteSuccess] = useState(false)

  function handleModalEdit(name, category, type, price) {
    setShowEditModal(true);
    setObjModel({
      name: name,
      category: category,
      type: type,
      price: price,
    });
  }
  function handleModalCreate() {
    setShowCreateModal(true);
  }
  function handleModalAddToCart(id) {
    setproductId(id);
    setProductAddToCartModal(true);
  }

  const handleProductDelete = (id) => {
    DeleteProductByID(id).then((response) => {
      if(!response.ok) {
        console.log(response)
        throw new Error(response.status)}
      else {
        deleteProduct(id)
        setAlertDeleteSuccess(true)
      }
    })
    .catch((error) => console.log("error:", error));
  }

  return (
    <div>
      <ProductAddToCartModal
        cartList={cartList}
        productAddToCartModal={productAddToCartModal}
        setProductAddToCartModal={setProductAddToCartModal}
        productId={productId}
      />
      <ProductModalEdit
        showEditModal={showEditModal}
        setShowEditModal={setShowEditModal}
        objModal={objModal}
      />
      <ProductModalCreate
        typesList={typesList}
        categoryList={categoryList}
        productList={productList}
        setProductList={setProductList}
        showCreateModal={showCreateModal}
        setShowCreateModal={setShowCreateModal}
        addProduct={addProduct}
      />
      <ClayCard>
        <ClayCard.Body>
          <div className="row">
            {productList.map((item, index) => (
              <div className="col-md-3" key={index}>
                <ClayCardWithInfo
                  key={index}
                  id={index}
                  actions={[
                    {
                      label: "edit",
                      onClick: () => {
                        handleModalEdit(
                          item.name,
                          item.category.name,
                          item.type.name,
                          item.price
                        );
                      },
                    },
                    { type: "divider" },
                    {
                      label: "Delete",
                      onClick: () => handleProductDelete(item.id),
                    },
                    { type: "divider" },
                    {
                      href: "#",
                      label: "Add to Cart",
                      onClick: () => {
                        handleModalAddToCart(item.id);
                      },
                    },
                  ]}
                  stickerProps={{
                    content: "IMG",
                    displayType: "danger",
                  }}
                  title={item.name}
                  description={"Price: " + item.price}
                />
              </div>
            ))}
          </div>
          <ClayButton displayType="primary" onClick={() => handleModalCreate()}>
            Create Product
          </ClayButton>
          {alertDeleteSuccess && (
            <Alert displayType={"success"} title={"Success: "} message={"The product were successfully deleted"}>
              {setTimeout(() => setAlertDeleteSuccess(false), 5000)}
            </Alert>
          )}
        </ClayCard.Body>
      </ClayCard>
    </div>
  );
}
