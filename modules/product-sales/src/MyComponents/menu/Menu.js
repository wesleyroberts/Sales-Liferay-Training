import React from "react";
import ClayNavigationBar from "@clayui/navigation-bar";
import { useState, useEffect } from "react";
import Products from "../products/Products";
import Carts from "../cart/Carts";
import Config from "../config/Config";
import { GetAllTypes } from "../../resourceRequests/TypeFunctions";
import { GetAllCategories } from "../../resourceRequests/CategoryFunctions";
import { GetAllCarts } from "../../resourceRequests/CartFunctions";
import { GetAllProducts } from "../../resourceRequests/ProductFunctionsREST";
import { getTotalValueByCartId } from "../../resourceRequests/ProductFunctionsREST";

export default function Menu() {
  const btnStyle = {
    padding: "5.5px 16px 5.5px 16px",
    borderColor: "var(--indigo)",
  };

  const [showProductWindows, setShowProductsWindows] = useState(true);
  const [showCartWindows, setShowCartWindows] = useState(false);
  const [showConfigWindows, setShowConfigWindows] = useState(false);
  const [typesList, setTypeList] = useState([]);
  const [productList, setProductList] = useState([]);
  const [cartList, setCartList] = useState([]);
  const [categoryList, setCategoryList] = useState([]);

  const showProducts = () => {
    setShowProductsWindows(true);
    setShowCartWindows(false);
    setShowConfigWindows(false);
  };
  const showCart = () => {
    setShowProductsWindows(false);
    setShowCartWindows(true);
    setShowConfigWindows(false);
  };
  const showConfig = () => {
    setShowProductsWindows(false);
    setShowCartWindows(false);
    setShowConfigWindows(true);
  };

  useEffect(() => {
    GetAllTypes().then((data) => setTypeList(data.items));
    GetAllCategories().then((data) => setCategoryList(data.items));
    GetAllCarts().then((data) => setCartList(data.items));
    GetAllProducts().then((data) => setProductList(data.items));
  }, []);

  const addCart = (obj) => {
    setCartList([...cartList, obj]);
  };

  const deleteCart = (id) => {
    var res = [];
    cartList.forEach((item) => {
      if (item.id !== id) res.push(item);
    });
    setCartList(res);
  };

  const addCategory = (obj) => {
    setCategoryList([...categoryList, obj]);
  };

  const deleteCategory = (id) => {
    var res = [];
    categoryList.forEach((item) => {
      if (item.id !== id) res.push(item);
    });
    setCategoryList(res);
  };

  const addType = (obj) => {
    setTypeList([...typesList, obj]);
  };

  const deleteType = (id) => {
    var res = [];
    categoryList.forEach((item) => {
      if (item.id !== id) res.push(item);
    });
    setTypeList(res);
  };

  const addProduct = (obj) => {
    setProductList([...productList, obj]);
  };

  const deleteProduct = (id) => {
    var res = [];
    productList.forEach((item) => {
      if (item.id !== id) res.push(item);
    });
    setProductList(res);
  };

  return (
    <div>
      <ClayNavigationBar triggerLabel="Item 1">
        <ClayNavigationBar.Item>
          <button
            className="btn btn-unstyled btn-block btn-sm"
            style={btnStyle}
            type="button"
            onClick={showProducts}
          >
            Produtos
          </button>
        </ClayNavigationBar.Item>
        <ClayNavigationBar.Item>
          <button
            className="btn btn-unstyled btn-block btn-sm"
            style={btnStyle}
            type="button"
            onClick={showCart}
          >
            Carrinho
          </button>
        </ClayNavigationBar.Item>
        <ClayNavigationBar.Item>
          <button
            className="btn btn-unstyled btn-block btn-sm"
            style={btnStyle}
            type="button"
            onClick={showConfig}
          >
            {" "}
            config
          </button>
        </ClayNavigationBar.Item>
      </ClayNavigationBar>

      {showProductWindows && (
        <Products
          productList={productList}
          setProductList={setProductList}
          typesList={typesList}
          categoryList={categoryList}
          cartList={cartList}
          addProduct={addProduct}
          deleteProduct={deleteProduct}
        />
      )}
      {showCartWindows && (
        <Carts cartList={cartList} addCart={addCart} deleteCart={deleteCart} />
      )}
      {showConfigWindows && (
        <Config
          typesList={typesList}
          categoryList={categoryList}
          addCategory={addCategory}
          deleteCategory={deleteCategory}
          addType={addType}
          deleteType={deleteType}
        />
      )}
    </div>
  );
}
