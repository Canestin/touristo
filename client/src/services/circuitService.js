import api from "./api";

export default {
  getCircuitById: (uuid) => api.get(`/circuits/${uuid}`),
  getCircuits: () => api.get("/circuits"),
};
