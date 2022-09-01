import "./App.css"
import Home from "./components/Overview";
import Sidebar from "./components/Sidebar/Sidebar";

function App() {
  return (
    <div className="App">
     <div className="AppGlass">

      <Home />
      <Sidebar />

     </div>
    </div>
  );
}

export default App;
