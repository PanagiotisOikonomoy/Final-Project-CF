import React from 'react'
import "./Home.css";

//Author Panagiotis Oikonomou

const Home = () => {
  return (
    <div>
        <h2 className='title'>Web HR Department Application</h2>
        <div>
          <p>
          Web HR Department Aplication is great. Web HR Department Application is easy to use, has good customer support and they are very responsive to our needs.<br></br>
          They even have been very flexible with making custom program changes.
          </p>
        
        </div>
        <div>
          <h6 className='title'>Now you have the knowlege in your hands</h6>
          <img className='imgH6' height={700} width={1200}
          src='https://t4.ftcdn.net/jpg/01/92/13/65/360_F_192136561_9jE272lofBue3oF1ZyfdLJKvLzpg9EN9.jpg'></img>
        </div>
        
    </div>
  )
}

export default Home