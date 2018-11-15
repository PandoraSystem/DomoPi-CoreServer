package com.marktech.domopi.controller.servertcp;

public class Comunicator {

    private ServerRequest serverRequest;
    private ServerResponse serverResponse;
    private Integer id;

    public Comunicator(ServerRequest serverRequest, ServerResponse serverResponse, int id) {
        this.serverRequest = serverRequest;
        this.serverResponse = serverResponse;
        this.id = id;
    }

    public ServerRequest getServerRequest() {
        return serverRequest;
    }

    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    public Integer getId() {
        return id;
    }


}
