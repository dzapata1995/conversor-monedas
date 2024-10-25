package com.dzapata.service;

import com.dzapata.entity.DivisaDTO;
import com.dzapata.helper.Helper;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    public Double getValorDivisa(String origen, String target) {
        DivisaDTO divisa = new DivisaDTO();
        URI urlApi = URI.create(Helper.getURLAPI(origen, target));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(urlApi).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            divisa = new Gson().fromJson(response.body(), DivisaDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película.");
        }

        return divisa.getConversionRate();
    }
}
