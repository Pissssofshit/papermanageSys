package com.example.rank.util;

import javax.servlet.http.HttpServletResponse;

public class CrossDomain {
    public void solveCrossDomain(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader( "Access-Control-Allow-Credentials","true" );
    }
}
