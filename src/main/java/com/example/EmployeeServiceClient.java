/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javax.annotation.PostConstruct;
import org.exampledriven.grpc.services.Employee;
import org.exampledriven.grpc.services.EmployeeFetch;
import org.exampledriven.grpc.services.EmployeeServiceGrpc;
import org.springframework.stereotype.Service;

/**
 *
 * @author bhattp7
 */
@Service
public class EmployeeServiceClient {
    
    private EmployeeServiceGrpc.EmployeeServiceBlockingStub stub ; 
    
    @PostConstruct
    public void initialize(){
       ManagedChannel channel =  ManagedChannelBuilder.forAddress("localhost", 6565)
        .usePlaintext(true)
        .build();
       
       
       stub = EmployeeServiceGrpc.newBlockingStub(channel) ;
    }
    
    
    public void getEmployee(int id) {
        EmployeeFetch empFetch = EmployeeFetch.newBuilder().setId(id).build();
        Employee ee = stub.getEmployee(empFetch);
        System.out.println(ee.getId());
        System.out.println(ee.getName()); 
        System.out.println(ee.getAddressesCount());
    }
    
}
