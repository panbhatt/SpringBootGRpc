/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import io.grpc.stub.StreamObserver;
import org.exampledriven.grpc.services.Address;
import org.exampledriven.grpc.services.Employee;
import org.exampledriven.grpc.services.EmployeeFetch;
import org.exampledriven.grpc.services.EmployeeServiceGrpc.EmployeeServiceImplBase;
import org.lognet.springboot.grpc.GRpcService;

/**
 *
 * @author bhattp7
 */
@GRpcService
public class EmployeeGRpcService extends EmployeeServiceImplBase{

    @Override
    public void getEmployee(EmployeeFetch request, StreamObserver<Employee> responseObserver) {
        
        System.out.println("Employee Id -> "  + request.getId());
        Address address = Address.newBuilder().setCity("NOrthYork ").setStreet("ST no " + request.getId()).build ();
        Employee employee = Employee.newBuilder().setId(request.getId()).setName("Pankaj Bhatt " + request.getId()).addAddresses(address).build();
        responseObserver.onNext(employee);
        responseObserver.onCompleted();
        
        
        
        
    }
    
    
    
}
