import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
// import StarRating from "./StarRating";
// import CodingCha from "./CodingCha1";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
    {/* <StarRating
      maxRating={5}
      message={["Terrible", "Bad", "Okay", "Good", "Amazing"]}
    />
    <Mod /> */}
    {/* <CodingCha /> */}
  </React.StrictMode>
);

// function Mod() {
//   const [starRating, setStatRating] = useState(0);
//   return (
//     <div>
//       <StarRating
//         size={24}
//         color="red"
//         maxRating={10}
//         onSetState={setStatRating}
//       />
//       <p>You rate {starRating} stars</p>
//     </div>
//   );
// }
