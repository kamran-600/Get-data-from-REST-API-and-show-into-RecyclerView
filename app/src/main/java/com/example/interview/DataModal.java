package com.example.interview;

import java.util.ArrayList;

public class DataModal {

    public String message;
    public int status;
    public ArrayList<Subdata> data;

    public DataModal(int status, String message, ArrayList<Subdata> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Subdata> getData() {
        return data;
    }

    public void setData(ArrayList<Subdata> data) {
        this.data = data;
    }

    public static class Subdata {
        private String flag,countries_name, country_code, countries_id, countries_iso_code;

        public Subdata(String flag, String countries_name, String country_code, String countries_id, String countries_iso_code) {
            this.flag = flag;
            this.countries_name = countries_name;
            this.country_code = country_code;
            this.countries_id = countries_id;
            this.countries_iso_code = countries_iso_code;
        }

        public String  getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getCountries_name() {
            return countries_name;
        }

        public void setCountries_name(String countries_name) {
            this.countries_name = countries_name;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getCountries_id() {
            return countries_id;
        }

        public void setCountries_id(String countries_id) {
            this.countries_id = countries_id;
        }

        public String getCountries_iso_code() {
            return countries_iso_code;
        }

        public void setCountries_iso_code(String countries_iso_code) {
            this.countries_iso_code = countries_iso_code;
        }
    }
}