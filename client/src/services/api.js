import axios from "axios";

const api = axios.create({
  // baseURL: "https://touristo.herokuapp.com",
  baseURL: "http://localhost:8080",
  headers: {
    "Content-Type": "application/json",
  },
});

export default api;
