import Home from "./pages/Home/Home";
import NotFound from "./pages/NotFound/NotFound";
import Circuit from "./pages/Circuit/Circuit";
import { Routes, Route, useLocation } from "react-router-dom";
import { useEffect } from "react";

function App() {
  const { pathname } = useLocation();

  useEffect(() => {
    window.scrollTo(0, 0);
  }, [pathname]);

  return (
    <div>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/circuits/:circuitId" element={<Circuit />}>
          <Route path=":dayId" element={<Circuit />} />
        </Route>
        <Route path="/*" element={<NotFound />} />
        <Route path="/not-found" element={<NotFound />} />
      </Routes>
    </div>
  );
}
export default App;
