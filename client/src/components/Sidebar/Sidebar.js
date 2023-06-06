import React, { useEffect, useState } from "react";
import logo from "../../images/logo.png";
import styles from "./Sidebar.module.scss";
import { HiOutlineCalendarDays } from "react-icons/hi2";
import { AiOutlineMenuFold, AiOutlineClose } from "react-icons/ai";
import { useNavigate } from "react-router-dom";

export default function Sidebar({ numberOfDays, setSitesOfTheDay }) {
  const [showDays, setShowDays] = useState(false);
  const [screenWidth, setScreenWidth] = useState(window.innerWidth);
  const navigate = useNavigate();

  const handleMenu = () => {
    setShowDays((s) => !s);
  };

  console.log("screenWidth", screenWidth);

  useEffect(() => {
    if (window.innerWidth > 760) setShowDays(true);
    const handleResize = () => {
      setScreenWidth(window.innerWidth);
      if (window.innerWidth > 760) setShowDays(true);
    };

    window.addEventListener("resize", handleResize);

    return () => {
      window.removeEventListener("resize", handleResize);
    };
  }, []);
  return (
    <div className={styles.container}>
      <div className={styles.top}>
        <img src={logo} alt="logo" />
        {!showDays && (
          <AiOutlineMenuFold
            onClick={handleMenu}
            className={styles.menu}
            size={25}
          />
        )}

        {showDays && (
          <AiOutlineClose
            onClick={handleMenu}
            className={styles.menu}
            size={25}
          />
        )}
      </div>
      {showDays && (
        <div className={styles.days}>
          {new Array(numberOfDays).fill(0).map((_, i) => (
            <div
              onClick={() => {
                if (window.innerWidth < 760) {
                  handleMenu();
                }
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
      )}
    </div>
  );
}
