import React from 'react'
import "./Home.css"
import MainScreen from './Main'
import NavBar from './NavBar'

function Home() {
  return (
    <>
    <div className='Home'>
        {/* Navbar */}
        <NavBar />
        {/* Main Screen */}
        <MainScreen />

        {/* Categories Cards */}
    </div>
    </>
  )
}

export default Home