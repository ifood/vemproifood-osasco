package br.com.ifood.vemproifood.dishlist.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDTO {
    private final String category;


    @JsonCreator
    public CategoryDTO(
            @JsonProperty("dish_type")
            String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
