package com.codenation.centraldeerros.advice;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName) {
        super("Resource: " + resourceName + " not foundd");
    }

}
