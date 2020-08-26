package services;

import java.time.LocalDate;

public class CarModel {

    private String id;
    private BrandModel brandModel;
    private LocalDate purchasingDate;
    private String model;

    public CarModel(String id, BrandModel brandModel, LocalDate purchasingDate, String model) {
        this.id = id;
        this.brandModel = brandModel;
        this.purchasingDate = purchasingDate;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BrandModel getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(BrandModel brandModel) {
        this.brandModel = brandModel;
    }

    public LocalDate getPurchasingDate() {
        return purchasingDate;
    }

    public void setPurchasingDate(LocalDate purchasingDate) {
        this.purchasingDate = purchasingDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id='" + id + '\'' +
                ", brandModel=" + brandModel +
                ", purchasingDate=" + purchasingDate +
                ", model='" + model + '\'' +
                '}';
    }
}
