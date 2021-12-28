import React from "react";
import { useState } from "react";
import { DeleteProductByID } from "../../resourceRequests/ProductFunctionsREST";
import ProductModalEdit from "./Modal/ProductModalEdit";
import ProductModalCreate from "./Modal/ProductModalCreate";
import ClayCard, { ClayCardWithInfo } from "@clayui/card";
import ClayButton from "@clayui/button";

import ProductAddToCartModal from "./Modal/ProductAddToCartModal";
import { Alert } from "../alert/CustomAlert";
import DeleteProductModal from "./Modal/DeleteProductModal";

export default function Products({
  productList,
  setProductList,
  stockList,
  setStockList,
  typesList,
  categoryList,
  cartList,
  addProduct,
  deleteProduct,
  addStock,
  deleteStock,
}) {
  const [quantity, setQuantity] = useState(0);
  const [productAddToCartModal, setProductAddToCartModal] = useState(false);
  const [showEditModal, setShowEditModal] = useState(false);
  const [showCreateModal, setShowCreateModal] = useState(false);
  const [showDeleteModal, setShowDeleteModal] = useState(false);
  const [objModal, setObjModel] = useState({
    name: "",
    category: "",
    type: "",
    price: "",
  });
  const [stock, setStock] = useState({
    productName: "",
    category: "",
    type: "",
    price: "",
    id: "",
    quantity: "",
  });
  const [productId, setproductId] = useState(0);
  const [alertDeleteSuccess, setAlertDeleteSuccess] = useState(false);

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
  function handleDeleteModal(item) {
    setStock({
      productName: item.productName,
      category: item.category,
      type: item.type,
      price: item.price,
      quantity: item.quantity,
      id: item.id,
    });
    setQuantity(0), setShowDeleteModal(true);
  }
  function handleModalAddToCart(item) {
    setStock({
      productName: item.productName,
      category: item.category,
      type: item.type,
      price: item.price,
      quantity: item.quantity,
      id: item.id,
    });
    setQuantity(0), setProductAddToCartModal(true);
  }

  return (
    <div>
      <ProductAddToCartModal
        cartList={cartList}
        stock={stock}
        quantity={quantity}
        setQuantity={setQuantity}
        productAddToCartModal={productAddToCartModal}
        setProductAddToCartModal={setProductAddToCartModal}
      />
      <ProductModalEdit
        showEditModal={showEditModal}
        setShowEditModal={setShowEditModal}
        objModal={objModal}
      />
      <ProductModalCreate
        typesList={typesList}
        categoryList={categoryList}
        showCreateModal={showCreateModal}
        setShowCreateModal={setShowCreateModal}
        addProduct={addProduct}
        addStock={addStock}
      />
      <DeleteProductModal
        stock={stock}
        quantity={quantity}
        setQuantity={setQuantity}
        showDeleteModal={showDeleteModal}
        setShowDeleteModal={setShowDeleteModal}
      />
      <ClayCard>
        <ClayCard.Body>
          <div className="row">
            {stockList.map((item, index) => (
              <div className="col-md-3" key={index}>
                <ClayCardWithInfo
                  key={index}
                  id={index}
                  actions={[
                    {
                      label: "Add to Cart",
                      onClick: () => {
                        handleModalAddToCart(item);
                      },
                    },
                    { type: "divider" },
                    {
                      label: "edit",
                      onClick: () => {
                        handleModalEdit(
                          item.productName,
                          item.category.name,
                          item.type.name,
                          item.price
                        );
                      },
                    },
                    { type: "divider" },
                    {
                      label: "Delete",
                      onClick: () => handleDeleteModal(item),
                    },
                  ]}
                  labels={[
                    {
                      displayType: "info",
                      value: `${item.type.name}`,
                    },
                    {
                      displayType: "secondary",
                      value: `${item.category.name}`,
                    },
                  ]}
                  stickerProps={{
                    content: "IMG",
                    displayType: "danger",
                  }}
                  title={item.productName}
                  description={`Price: ${item.price} Quantity: ${item.quantity}`}
                />
              </div>
            ))}
          </div>
          <ClayButton displayType="primary" onClick={() => handleModalCreate()}>
            Create Product
          </ClayButton>
          {alertDeleteSuccess && (
            <Alert
              displayType={"success"}
              title={"Success: "}
              message={"The product were successfully deleted"}
            >
              {setTimeout(() => setAlertDeleteSuccess(false), 5000)}
            </Alert>
          )}
        </ClayCard.Body>
      </ClayCard>
    </div>
  );
}
