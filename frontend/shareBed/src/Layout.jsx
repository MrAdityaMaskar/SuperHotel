import React, { useState } from "react";
// import Login from './components/Login/Login'
import Home from "./components/Home/Home";
import Navbar from "./components/Navbar/Navbar";
import { Outlet } from "react-router-dom";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function layout() {
  return (
    <>
      <Navbar />
      <Outlet />
    </>
  );
}

export default layout;
