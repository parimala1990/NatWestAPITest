package com.natwest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@lombok.Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {
    Integer year;
    Double price;

    @JsonProperty("CPU model")
    String cpuModel;

    @JsonProperty("Hard disk size")
    String hardDiskSize;

    @JsonProperty("Color")
    String color;

    @JsonProperty("color")
    String colorLower;

    @JsonProperty("capacity")
    String capacity;

    @JsonProperty("Capacity")
    String capacityCapital;

    @JsonProperty("capacity GB")
    Integer capacityGb;

    String generation;

    @JsonProperty("Generation")
    String generationCapital;

    @JsonProperty("Strap Colour")
    String strapColour;

    @JsonProperty("Case Size")
    String caseSize;

    @JsonProperty("description")
    String description;

    @JsonProperty("Description")
    String descriptionCapitol;

    @JsonProperty("Screen size")
    Double screenSize;

    @JsonProperty("price")
    public void setPrice(Object value) {
        this.price = convertToDouble(value);
    }

    @JsonProperty("Price")
    public void setPriceCapital(Object value) {
        this.price = convertToDouble(value);
    }

    private Double convertToDouble(Object value) {
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        } else if (value instanceof String) {
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
    public String getColor() {
        return color != null ? color : colorLower;
    }

    public String getCapacity() {
        return capacity != null ? capacity : capacityCapital;
    }

    public String getGeneration() {
        return generation != null ? generation : generationCapital;
    }

    public String getDescription() {
        return description != null ? description : descriptionCapitol;
    }
}
