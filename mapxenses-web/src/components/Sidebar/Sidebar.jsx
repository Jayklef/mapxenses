import React from "react";
import "./Sidebar.css";
import Avatar from "@mui/material/Avatar";
// import Stack from '@mui/material/Stack';
import { deepPurple } from "@mui/material/colors";
import NotificationsOutlinedIcon from "@mui/icons-material/NotificationsOutlined";

function Sidebar() {
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
      <div><h3>Categories</h3></div>
      {/* Category 1 */}
      <div className="cat1">
        {/* Image */}
        <img src="" alt="" />
        {/* Text  display block*/}
        <div className="catText">

        </div>
        {/* amount */}
        <span>
            {/* currency */}
            {/* <CurrencyFormat */}
        </span>
      </div>
      
      new
    </div>
  );
}

export default Sidebar;
