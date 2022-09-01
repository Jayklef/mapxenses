import React from "react";
import "./mainScreen.css";
import Wallet from "../../../assets/walletRepo.svg";
// import TextField from '@mui/material/TextField';
// import { DesktopDatePicker } from '@mui/x-date-pickers/DesktopDatePicker';
// import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
// import { AdapterDateFns } from '@mui/x-date-pickers/AdapterDateFns';
import { Card } from "antd";
import "antd/dist/antd.css";
import { DatePicker, Space } from "antd";
import {
    // Card, CardImg, CardText, CardBody,
    CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button, Container, Row, Col
  } from 'reactstrap';


function MainScreen() {
  const onChange = (date, dateString) => {};

  return (
    <div className="MainScreen">
      <div className="mainTop">
        <div className="imgTxt">
          <div className="imgWallet">
            <img src={Wallet} alt="wallet" />
          </div>
          <div className="walletTxt">
            <span className="span1">Home Wallet</span>
            <span className="span2">Change default wallet</span>
          </div>
        </div>
        {/* Calendar */}
        <div className="calendar">
          {/* Calendar */}
          <DatePicker onChange={onChange} />
        </div>
      </div>

      {/* budget Card */}
      <div className="budgetCard">
        <div className="site-card-border-less-wrapper">
          <Card title="Card title" style={{ borderRadius: "15px" }}>
            <p>Card content</p>
            <p>Card content</p>
            <p>Card content</p>
          </Card>
        </div>
      </div>

      {/* Categories Card */}
      <div className="catCard">
        <div>
          <h3>Categories With Biggest Expense</h3>
        </div>
        {/* cards */}
        <div>

        </div>
      </div>
    </div>
  );
}

export default MainScreen;
