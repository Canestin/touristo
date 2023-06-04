import React, { useEffect, useState } from "react";
import styles from "./SiteFilters.module.scss";
import { AiOutlineLoading3Quarters } from "react-icons/ai";
import { departments, historicalContexts } from "../../utils";
import { createCircuit } from "../../services/circuitService";
import { useNavigate } from "react-router-dom";

const SiteFilters = () => {
  const [loading, setLoading] = useState(false);
  const [city, setCity] = useState("Paris");
  const [department, setDepartment] = useState("");
  const [numberOfDays, setNumberOfDays] = useState(3);
  const [numberOfSitesPerDay, setNumberOfSitesPerDay] = useState(3);
  const [type, setType] = useState("");
  const [historicalContext, setHistoricalContext] = useState("");
  const [circuitId, setCircuitId] = useState(null);

  const navigate = useNavigate();

  const handleFilterSubmit = async () => {
    if (loading) return;
    setLoading(true);

    const circuit = await createCircuit(
      "departement=75&latitude=48.877059&longitude=2.329685"
    );
    setCircuitId(circuit.data.id);
  };

  useEffect(() => {
    if (circuitId) {
      setLoading(false);
      navigate(`/circuits/${circuitId}`);
    }
  }, [circuitId]);

  return (
    <div className={styles.container}>
      <h2>Choose your Preferences</h2>
      <div className={styles.inputs}>
        <div className={styles.formGroup}>
          <label htmlFor="department">Department :</label>
          <select
            id="department"
            value={department}
            onChange={(e) => setDepartment(e.target.value)}
          >
            <option value="">All departments</option>

            {Object.entries(departments).map((d) => {
              return (
                <option key={d[0]} value={d[0]}>
                  {d[1].department}
                </option>
              );
            })}
          </select>
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="city">City :</label>
          <input
            value={city}
            onChange={(e) => setCity(e.target.value)}
            type="text"
          />
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="type">Type :</label>
          <select
            id="type"
            value={type}
            onChange={(e) => setType(e.target.value)}
          >
            <option value="">All types</option>
            <option value="museums">Museums</option>
            <option value="monuments">Monuments</option>
          </select>
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="number">Number of Days :</label>
          <input
            onChange={(e) => setNumberOfDays(e.target.value)}
            type="number"
            min={1}
            max={30}
            value={numberOfDays}
          />
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="numberOfSitesPerDay">Number of Sites / Day :</label>
          <select
            id="numberOfSitesPerDay"
            value={numberOfSitesPerDay}
            onChange={(e) => setNumberOfSitesPerDay(e.target.value)}
          >
            <option value={2}>2</option>
            <option value={3}>3</option>
            <option value={4}>4</option>
            <option value={5}>5</option>
            <option value={6}>6</option>
            <option value={7}>7</option>
          </select>
        </div>

        <div className={styles.formGroup}>
          <label htmlFor="type">Historical Context :</label>
          <select
            id="type"
            value={historicalContext}
            onChange={(e) => setHistoricalContext(e.target.value)}
          >
            <option value="">Tous les types</option>
            {historicalContexts.map((h, index) => (
              <option key={index} value={h}>
                {h}
              </option>
            ))}
          </select>
        </div>
      </div>

      <button
        className={`${styles.submitButton} ${loading && styles.disable}`}
        onClick={handleFilterSubmit}
      >
        {loading && <AiOutlineLoading3Quarters className={styles.spin} />}
        <span>Start reseach</span>
      </button>
    </div>
  );
};

export default SiteFilters;
