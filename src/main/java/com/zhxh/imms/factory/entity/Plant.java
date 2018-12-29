package com.zhxh.imms.factory.entity;

import com.zhxh.core.data.EntityObject;

public class Plant extends EntityObject {
    private String plantId;
    private String plantNo;
    private String plantName;
    private String plantDescription;
    private Double plantCostPriceRatio;

    public String getPlantId() {
        return plantId;
    }

    public String getPlantNo() {
        return plantNo;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getPlantDescription() {
        return plantDescription;
    }

    public Double getPlantCostPriceRatio() {
        return plantCostPriceRatio;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public void setPlantNo(String plantNo) {
        this.plantNo = plantNo;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setPlantDescription(String plantDescription) {
        this.plantDescription = plantDescription;
    }

    public void setPlantCostPriceRatio(Double plantCostPriceRatio) {
        this.plantCostPriceRatio = plantCostPriceRatio;
    }
}
