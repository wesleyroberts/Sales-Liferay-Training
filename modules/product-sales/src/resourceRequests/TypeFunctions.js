const test = btoa("test@liferay.com:test");
export function GetAllTypes() {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/type/all`,
    {
      method: "GET",
      headers: { Authorization: "Basic " + test },
    }
  ).then((res) => res.json());
}
export function createType(name, tax) {
  let type = {
    name: name,
    tax: tax,
  };

  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/type/create`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Basic " + test,
      },
      body: JSON.stringify(type),
    }
  ).then((res) => res.json());
}

export function DeleteTypeByID(typeId) {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/type/delete/${typeId}`,
    {
      method: "DELETE",
      headers: { Authorization: "Basic " + test },
    }
  );
}
