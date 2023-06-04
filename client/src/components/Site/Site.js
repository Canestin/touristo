import React, { useEffect, useState } from "react";
import siteService from "../../services/siteService";
import { getPlacePhotos } from "../../utils/index";
import "./Site.scss";

const itinerary = {
  origin: "48.8871648,2.3844529",
  destination: "48.899594,2.344794",
};
const Site = () => {
  const [objectData, setObjectData] = useState(null);

  useEffect(() => {
    const getSite = async () => {
      const { data: site } = await siteService.getSiteById(1);

      if (!site) return;

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
          <h1>1. {objectData.name}</h1>
          <img className="object-img" src={objectData.image} alt="Site" />
          <div className="object-details">
            <div className="object-info">
              <p>City: {objectData.city}</p>
              <p>Department : {objectData.code_departement}</p>
              <p>Description: {objectData.description}</p>
              <p>Historical Context: {objectData.historicalContext}</p>
            </div>
          </div>
          <a
            target="_blank"
            href={`https://www.google.com/maps/dir/${itinerary.origin}/${itinerary.destination}`}
          >
            Itinerary
          </a>
        </>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default Site;
