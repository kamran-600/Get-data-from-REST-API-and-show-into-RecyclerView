package com.example.interview;

import java.util.ArrayList;

public class DataModal {

    public String status, message;
    public ArrayList<Subdata> data;

    public DataModal(String status, String message, ArrayList<Subdata> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public class Subdata {
        private int flag;
        private String countries_name, country_code, countries_id, countries_iso_code;

        public Subdata(int flag, String countries_name, String country_code, String countries_id, String countries_iso_code) {
            this.flag = flag;
            this.countries_name = countries_name;
            this.country_code = country_code;
            this.countries_id = countries_id;
            this.countries_iso_code = countries_iso_code;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
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