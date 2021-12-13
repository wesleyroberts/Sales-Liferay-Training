const test = btoa("test@liferay.com:test");
export function GetAllCategories() {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/category/all`,
    {
      method: "GET",
      headers: { Authorization: "Basic " + test },
    }
  ).then((res) => res.json());
}
export function CreateCategory(name, tax) {
  let category = {
    name: name,
    tax: tax,
  };

  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/category/create`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Basic " + test,
      },
      body: JSON.stringify(category),
    }
  ).then((res) => res.json());
}

export function DeleteCategoryByID(categoryId) {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/category/delete/${categoryId}`,
    {
      method: "DELETE",
      headers: { Authorization: "Basic " + test },
    }
  );
}
