package repositories;

public class CarEntity {

    private String id;
    private String brandId;
    private String model;
    private String purchasingDate;

    public CarEntity() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPurchasingDate() {
        return purchasingDate;
    }

    public void setPurchasingDate(String purchasingDate) {
        this.purchasingDate = purchasingDate;
    }
}
