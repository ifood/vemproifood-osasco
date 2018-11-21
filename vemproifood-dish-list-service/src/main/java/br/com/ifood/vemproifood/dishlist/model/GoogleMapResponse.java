package br.com.ifood.vemproifood.dishlist.model;

import java.util.List;

public class GoogleMapResponse {

    private List results;

    static class AddressComponents {
        private String longName;
        private String shortName;
        private String[] types;

        public void setLongName(String value) { this.longName = value; }
        public String getLongName() { return longName; }

        public void setShortName(String value) { this.shortName = value; }
        public String getShortName() { return  shortName; }

        public void setTypes(String[] values) { this.types = values; }
        public String[] getTypes() { return types; }

    }

}
