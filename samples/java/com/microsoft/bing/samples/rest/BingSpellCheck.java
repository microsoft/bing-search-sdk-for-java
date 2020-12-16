package com.microsoft.bing.rest;

// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * This sample uses the Bing Spell Check v7 API to check spelling of a sentence.
 *
 * Include library (for pretty print), add jar to a lib folder:
 * https://github.com/stleary/JSON-java
 *
 * Add your subscription key and endpoint to your environment variables.
 *
 * Build/run from command line: 
 *   javac BingSpellCheck.java -cp .;lib\* 
 *   java -cp .;lib\* BingSpellCheck
 */

public class BingSpellCheck {

    static String endpoint = System.getenv("BING_SPELL_CHECK_ENDPOINT") + "/v7.0/spellcheck";

    // NOTE: Replace this example key with a valid subscription key.
    static String subscriptionKey = System.getenv("BING_SPELL_CHECK_SUBSCRIPTION_KEY");

    static String mkt = "en-US";
    static String mode = "proof";
    static String text = "Hollo, wrld!";

    
    // Pretty-printer for JSON; uses GSON parser to parse and re-serialize
    public static String prettify (String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(json_text);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }
    
    public static void main(String[] args) {
        try {
            String params = "?mkt=" + mkt + "&mode=" + mode;
            URL url = new URL(endpoint + params);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", "" + text.length() + 5);
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", subscriptionKey);
            connection.setDoOutput(true);

            // Optional
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes("text=" + text);
            wr.flush();
            wr.close();

            // Get results
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            // Pretty print
            System.out.println(prettify(sb.toString()));

            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}