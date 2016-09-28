/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.exception;

/**
 *
 * @author bosco
 */
public class EndpointException extends RuntimeException{
    String message;
    int endpointValue;

    public EndpointException(String message, int endpointValue) {
        this.message = message;
        this.endpointValue = endpointValue;
    }
    
    
}
