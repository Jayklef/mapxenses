import React from "react";
import "./Sidebar.css";
import Avatar from "@mui/material/Avatar";
import { deepPurple } from "@mui/material/colors";
import NotificationsOutlinedIcon from "@mui/icons-material/NotificationsOutlined";
import ChaletIcon from "@mui/icons-material/Chalet";
// import CurrencyFormat from 'react-currency-format';
import HeadsetIcon from "@mui/icons-material/Headset";
import CameraAltIcon from "@mui/icons-material/CameraAlt";
import { Calendar } from "antd";
import "antd/dist/antd.css";

function Sidebar() {

  const onPanelChange = (value, mode) => {
    // console.log(value.format('YYYY-MM-DD'), mode);
  };

  return (
    // <div>Sidebar</div>
    <div className="Sidebar">
      <div className="SidebarNA">
        {/* notification */}
        <div className="notify">
          <NotificationsOutlinedIcon />
        </div>
        {/* Avatar */}
        <div className="avatar">
          <Avatar sx={{ bgcolor: deepPurple[500] }}>KY</Avatar>
        </div>
      </div>
      {/* Categories */}
      <div className="cath3">
        <h3>Categories</h3>
      </div>
      {/* Categories */}
      <div className="categories">
        <div className="categoryItem">
          {/* Image */}
          <div className="chaletIcon">
            <ChaletIcon />
          </div>
          {/* Text  display block*/}
          <div className="catText">
            <span>Home Loan</span> <br />
            <span className="dateTxt">15 April</span>
          </div>
          {/* amount */}
          <div>
            <span>$</span>
            <span>150.00</span>
            {/* <CurrencyFormat>12000</CurrencyFormat> */}
          </div>
        </div>
        
        {/* cat2 */}
        <div className="categoryItem">
          {/* Image */}
          <div className="chaletIcon">
            <HeadsetIcon />
          </div>
          {/* Text  display block*/}
          <div className="catText">
            <span>EarPhones</span> <br />
            <span className="dateTxt">15 April</span>
          </div>
          {/* amount */}
          <div>
            <span>$</span>
            <span>150.00</span>
            {/* <CurrencyFormat>12000</CurrencyFormat> */}
          </div>
        </div>
        {/* cat3 */}
        <div className="categoryItem">
          {/* Image */}
          <div className="chaletIcon">
            <CameraAltIcon />
          </div>
          {/* Text  display block*/}
          <div className="catText">
            <span>Camera</span> <br />
            <span className="dateTxt">15 April</span>
          </div>
          {/* amount */}
          <div>
            <span>$</span>
            <span>150.00</span>
            {/* <CurrencyFormat>12000</CurrencyFormat> */}
          </div>
        </div>

        {/* Add New */}
        <div className="categoryItemAdd">
          <div className="addIcon"></div>
          {/* Text  display block*/}
          <div className="catText2">
            <span style={{ color: "darkgray" }}>Add New</span>
          </div>
        </div>

        <div></div>
      </div>
      <div className="cath3">
        <h3>Calendar</h3>
        <div className="site-calendar-demo-card">
          <Calendar fullscreen={false} onPanelChange={onPanelChange} />
        </div>
      </div>
    </div>
  );
}

export default Sidebar;
