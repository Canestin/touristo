import React, { useState } from "react";
import logo from "../../images/logo.png";
import styles from "./Home.module.scss";
import SiteFilters from "../../components/SiteFilters/SiteFilters";
import { FaExternalLinkAlt } from "react-icons/fa";
// import { Navigate } from "react-router-dom";

// const circuitId = "f1cad218-3987-4b55-a976-a529f75f5c1e";
const Home = () => {
  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <h2> Tourism has never been so easy</h2>
        <a target="_blank" href="https://github.com/Canestin/touristo">
          <span>Github</span> <FaExternalLinkAlt />
        </a>
      </div>
      <div className={styles.logo}>
        <img src={logo} alt="logo" />
      </div>
      {/* <Navigate to={`/circuits/${circuitId}`} /> */}
      <div className={styles.filters}>
        <SiteFilters />
      </div>
    </div>
  );
};

export default Home;
