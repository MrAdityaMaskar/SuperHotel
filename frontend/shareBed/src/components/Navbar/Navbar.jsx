import React, { useState } from "react";
import { Link, NavLink } from "react-router-dom";
function Navbar() {

  const[showNav, setShowNav] = useState(true)

  // const navShow =()=>{
  //   if(showNav == true) setShowNav(false)
  //     else setShowNav(true)
  // }

  return (
    <>
      <header className="shadow sticky z-0 "
      >
        <nav className="bg-slate-300 border-gray-200 px-4 lg:px-6 py-2.5">
          <div className="flex flex-wrap justify-between items-center mx-auto max-w-screen-xl">
            <Link>
              <img
                src="https://alexharkness.com/wp-content/uploads/2020/06/logo-2.png"
                alt="Logo"
                className="h-12 "
              />
            </Link>

            <div className="flex items-center lg:order-2">
              <Link
                to="/login"
                className="px-3 py-2 text-lg font-medium text-gray-800 hover:text-[#604d53] rounded-lg lg:px-5 lg:py-2.5 mr-3 focus:outline-none "
              >
                Sign In
              </Link>

              <Link className="px-3 py-2 text-[#119da4] font-medium text-lg hover:bg-[#96031a] hover:text-white rounded-full transition-all duration-400 focus:ring-5 focus:bg-red-300 ">
                Get Started
              </Link>
            </div>

            <div className="justify-between  items-center w-full lg:flex lg:w-auto lg:order-1">
              <ul className="flex flex-col font-medium mt-4 lg:flex-row lg:space-x-8 lg:mt-0">
                <li>
                  <NavLink
                  to="/"
                    className={({ isActive }) =>
                      `block py-2 pr-4 pl-3 ${
                        isActive ? "text-orange-700" : "text-gray-700"
                      } duration-200 border-b border-gray-100 hover:bg-gray-50 hover:shadow rounded-lg lg:hover-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                    }
                  >
                    Home
                  </NavLink>
                </li>
                <li>
                  <NavLink
                  to="/about"
                    className={({ isActive }) =>
                      `block py-2 pr-4 pl-3 ${
                        isActive ? "text-orange-700" : "text-gray-700"
                      } duration-200 border-b border-gray-100 hover:bg-gray-50 lg:hover-transparent lg:border-0 hover:text-orange-700 lg:p-0`
                    }
                  >
                    About
                  </NavLink>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
    </>
  );
}

export default Navbar;
