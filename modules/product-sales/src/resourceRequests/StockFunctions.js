const test = btoa("test@liferay.com:test");
export function GetAllStock() {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/stock/all`,
    {
      method: "GET",
      headers: { Authorization: "Basic " + test },
    }
  ).then((res) => res.json());
}
export function getAllProductsBySotckId(stockId) {
  return Liferay.Util.fetch(
    `http://localhost:8080/o/RestBuilder/v1.0/stock/getAllProductsBySotckId/${stockId}
      `,
    {
      method: "GET",
      headers: { Authorization: "Basic " + test },
    }
  ).then((res) => res.json());
}
