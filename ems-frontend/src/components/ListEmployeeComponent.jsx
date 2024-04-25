import React,{useEffect, useState} from 'react'
import { deleteEmployee, listEmployees } from '../services/EmployeeService'
import {useNavigate} from 'react-router-dom'

const ListEmployeeComponent = () => {

    const [employees,setEmployees]= useState([])
    const navigator = useNavigate();

    useEffect(()=>{

        getAllEmployees();
        
    } ,[])

   function getAllEmployees(){

    listEmployees().then((response)=>{
        setEmployees(response.data);
    }).catch(error =>{
        console.error(error);
    })

   }


    function addNewEmployee(){
        navigator('/add-employee')

    }

    function updateEmployee(id){
        navigator(`/edit-employee/${id}`)
    }

    function removeEmployee(id){
        console.log(id);
        deleteEmployee(id).then((response) =>{
            getAllEmployees()
        }).catch(error =>{
            console.error(error);
        })
    }


    
  return (
    <div className='container my-5 abc'>

        <h2 className='text-center'>List of Employee</h2>
        <button className='btn btn-primary mb-2' onClick={addNewEmployee}> Add Employee</button>

        <table className='table table-striped table-bordered table-success my-3 tb'>
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee First Name</th>
                    <th>Employee Last Name</th>
                    <th>Employee Email Id</th>
                    <th>Actions</th>
                   
                </tr>
            </thead>

            <tbody>
                {
                   employees.map(employee =>
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstname}</td>
                            <td>{employee.lastname}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className='btn btn-info mx-2' onClick={() => updateEmployee(employee.id)}>Update</button>
                                <button className='btn btn-danger mx-2 my-2' onClick={()=> removeEmployee(employee.id)}>Delete</button>
                            </td>
                        </tr>
                    )
                }
                
            </tbody>
        </table>
      
    </div>
  )
}

export default ListEmployeeComponent
