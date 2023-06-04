import React, { useEffect } from "react";
// import { getCircuitById } from "../../services/circuitService";
import Site from "../../components/Site/Site";
import Sidebar from "../../components/Sidebar/Sidebar";
import styles from "./Circuit.module.scss";

const Circuit = () => {
  // const [objectData, setObjectData] = useState(null);

  useEffect(() => {}, []);

  return (
    <div className={styles.container}>
      <div className={styles.sidebar}>
        <Sidebar />
      </div>
      <div className={styles.sites}>
        <h1>Your Tourist Circuit : Day 1</h1>
        <Site />
        <Site />
        <Site />
        <Site />
        <Site />
        <Site />
      </div>
    </div>
  );
};

export default Circuit;
