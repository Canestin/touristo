import React, { useState } from "react";
import logo from "../../images/logo.png";
import styles from "./Home.module.scss";
import SiteFilters from "../../components/SiteFilters/SiteFilters";
import { FaExternalLinkAlt } from "react-icons/fa";

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

      <div className={styles.filters}>
        <SiteFilters />
      </div>
    </div>
  );
};

export default Home;
