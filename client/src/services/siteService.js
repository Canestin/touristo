import api from "./api";

const siteService = {
  getSites: () => api.get("/sites"),
  getSiteById: (siteId) => api.get(`/sites/${siteId}`),
};

export default siteService;
