import api from "./api";

export const getCircuitById = (uuid) => api.get(`/circuits/${uuid}`);
export const getCircuits = () => api.get("/circuits");
export const createCircuit = (search) => api.get(`/circuits?${search}`);

// department=75&numberOfDays=3&numberOfSitePerDay=3&latitude=48.877059&longitude=2.329685&city=Paris
