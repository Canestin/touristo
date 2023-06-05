import React from "react";
import logo from "../../images/logo.png";
import styles from "./Sidebar.module.scss";
import { HiOutlineCalendarDays } from "react-icons/hi2";
import { useNavigate } from "react-router-dom";

export default function Sidebar({ numberOfDays, setSitesOfTheDay }) {
  const navigate = useNavigate();
  return (
    <div className={styles.container}>
      <div className={styles.logo}>
        <img src={logo} alt="logo" />
      </div>
      <div className={styles.days}>
        {new Array(numberOfDays).fill(0).map((_, i) => (
          <div
            onClick={() => {
              setSitesOfTheDay([]);
              navigate((i + 1).toString());
            }}
            key={i + 1}
          >
            <HiOutlineCalendarDays size={25} />
            <span>Day {i + 1}</span>
          </div>
        ))}
      </div>
    </div>
  );
}
