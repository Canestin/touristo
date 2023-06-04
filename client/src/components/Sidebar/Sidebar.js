import React from "react";
import logo from "../../images/logo.png";
import styles from "./Sidebar.module.scss";
import { HiOutlineCalendarDays } from "react-icons/hi2";
import { useNavigate } from "react-router-dom";

export default function Navbar() {
  const navigate = useNavigate();
  return (
    <div className={styles.container}>
      <div className={styles.logo}>
        <img src={logo} alt="logo" />
      </div>
      <div className={styles.days}>
        {new Array(10).fill(0).map((_, i) => {
          return (
            <div>
              <HiOutlineCalendarDays
                size={25}
                onClick={() => navigate("/profile")}
              />
              <span>Day {i + 1}</span>
            </div>
          );
        })}
      </div>
    </div>
  );
}
