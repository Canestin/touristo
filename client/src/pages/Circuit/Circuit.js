import React, { useEffect, useState } from "react";
import Site from "../../components/Site/Site";
import Sidebar from "../../components/Sidebar/Sidebar";
import styles from "./Circuit.module.scss";
import { getCircuitById } from "../../services/circuitService";
import { useParams, useNavigate } from "react-router-dom";

const Circuit = () => {
  const [sitesOfTheDay, setSitesOfTheDay] = useState([]);
  const [circuit, setCircuit] = useState(null);
  const { circuitId, dayId } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (!dayId || isNaN(dayId) || dayId < 1) {
      navigate("1");
      return;
    }
    if (circuit && dayId > circuit.numberOfDays) {
      navigate("1");
      return;
    }
    if (circuit) {
      const journeys = circuit.journeys.map((j) => j.sites);
      const sites = journeys[dayId - 1].slice(1, -1);
      setSitesOfTheDay(sites);
    }
  }, [dayId, circuit?.id]);

  useEffect(() => {
    const fetchCircuit = async () => {
      const { data: c } = await getCircuitById(circuitId);
      setCircuit(c);
    };

    fetchCircuit();
  }, [circuitId]);

  return (
    <>
      {circuit ? (
        <div className={styles.container}>
          <div className={styles.sidebar}>
            <Sidebar
              setSitesOfTheDay={setSitesOfTheDay}
              numberOfDays={circuit.numberOfDays}
            />
          </div>
          <div className={styles.sites}>
            <h1>Your Tourist Circuit : Day {dayId}</h1>
            {sitesOfTheDay.map((site, i) => (
              <Site number={i + 1} key={i} site={site} />
            ))}
          </div>
        </div>
      ) : (
        <div style={{ textAlign: "center", marginTop: 300 }}>Chargement...</div>
      )}
    </>
  );
};

export default Circuit;
