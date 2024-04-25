

import './App.css'
import EmployeeComponent from './components/EmployeeComponent'
import Footer from './components/Footer'
import HeaderComponents from "./components/HeaderComponents"
import ListEmployeeComponent from "./components/ListEmployeeComponent"
import { BrowserRouter,Routes,Route } from 'react-router-dom'


function App() {
  // const [count, setCount] = useState(0)

  return (
    <>
      <BrowserRouter>

        <HeaderComponents/>
          <Routes>
              <Route path='/' element={<ListEmployeeComponent/>}></Route>
              <Route path='/employees' element={<ListEmployeeComponent/>}></Route>
              <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
              <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
              
          </Routes>
      
        <Footer/>

      </BrowserRouter>
      
    
    </>
  )
}

export default App
