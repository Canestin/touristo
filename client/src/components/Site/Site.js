import React, { useEffect, useState } from "react";
import siteService from "../../services/siteService";
import { getPlacePhotos } from "../../utils/index";
import "./Site.scss";

const Site = ({ site, number }) => {
  const [objectData, setObjectData] = useState(null);

  console.log("Site", site);
  useEffect(() => {
    const getSite = async () => {
      const photo = await getPlacePhotos(site.latitude, site.longitude);
      setObjectData({
        ...site,
        image: photo,
      });
    };

    getSite();
  }, [site.id]);

  return (
    <div className="object-container">
      {objectData ? (
        <>
          <h1>
            {number}. {objectData.name}
          </h1>
          {/* <img className="object-img" src={objectData.image} alt="Site" /> */}
          <div className="object-details">
            <div className="object-info">
              <p>City: {objectData.city}</p>
              <p>Department : {objectData.code_departement}</p>
              {!!objectData.description && (
                <p>Description: {objectData.description}</p>
              )}

              {!!objectData.historical_context && (
                <p>Historical Context: {objectData.historical_context}</p>
              )}
            </div>
          </div>

          <span>
            How do I get there?{" "}
            <a
              target="_blank"
              href={`https://www.google.com/maps?q=${objectData.latitude},${objectData.longitude}`}
            >
              Itinerary
            </a>
          </span>
        </>
      ) : (
        <div className="skeleton">
          <div className="title"></div>
          {/* <div className="image"></div> */}
          <div className="details detail1"></div>
          <div className="details detail2"></div>
          <div className="details detail3"></div>
        </div>
      )}
    </div>
  );
};

export default Site;
