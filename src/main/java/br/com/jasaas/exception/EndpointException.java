/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.exception;

/**
 *
 * @author bosco
 */
public class EndpointException extends RuntimeException{

    int endpointValue;

    public EndpointException(String message, int endpointValue) {
        super(message);
        this.endpointValue = endpointValue;
    }
    
    
}
