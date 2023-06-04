import React, { useEffect, useState } from "react";
import siteService from "../../services/siteService";
import { getPlacePhotos } from "../../utils/index";
import "./Site.scss";

const itinerary = {
  origin: "48.8871648,2.3844529",
  destination: "48.899594,2.344794",
};
const Site = ({ site, number, nextSite }) => {
  const [objectData, setObjectData] = useState(null);

  useEffect(() => {
    const getSite = async () => {
      // const { data: site } = await siteService.getSiteById(
      //   "f7b52566-a8ea-4b36-a1f7-3a1f7d0e5bca"
      // );

      // if (!site) return;

      setObjectData({
        ...site,
        image: await getPlacePhotos(site.latitude, site.longitude),
      });
    };

    getSite();
  }, []);

  return (
    <div className="object-container">
      {objectData ? (
        <>
          <h1>
            {number}. {objectData.name}
          </h1>
          <img className="object-img" src={objectData.image} alt="Site" />
          <div className="object-details">
            <div className="object-info">
              <p>City: {objectData.city}</p>
              <p>Department : {objectData.code_departement}</p>
              {!!objectData.description && (
                <p>Description: {objectData.description}</p>
              )}

              {!!objectData.historicalContext && (
                <p>Historical Context: {objectData.historicalContext}</p>
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
          <div className="image"></div>
          <div className="details detail1"></div>
          <div className="details detail2"></div>
          <div className="details detail3"></div>
        </div>
      )}
    </div>
  );
};

export default Site;
