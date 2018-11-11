package com.marktech.domopi.controller.message;

import java.util.ArrayList;

public class OperationList {
    ArrayList<String> operazioni;

    public OperationList(String operations)
    {
        String op[] = operations.split(":");
        for(String s:op){operazioni.add(s);}
    }
}
