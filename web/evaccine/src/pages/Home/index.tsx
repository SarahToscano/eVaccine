import React from 'react';
import './styles.css'
import { FiChevronRight } from 'react-icons/fi';
import {Link} from 'react-router-dom'; //SPA Single Page Application
import { FaArrowCircleRight } from 'react-icons/fa';

const Home = ()=>{
    return(
        <div id="page-home">
            <div className="content">
                <main>
                    <h1>COVID-19 <br/> VACCINE</h1>
                    <h3>Register to participate in the vaccination</h3>
                    <h4> Vaccines will be distributed according to the priorities</h4>
                
                
                    <Link to="/" className="enter-cadastro">
                        <FaArrowCircleRight size={60} color="rgba(246, 63, 71, 1)" />
                    </Link>

                    



                </main>
            </div>
        </div>
    )
}

export default Home;