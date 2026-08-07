package in.SpringBot.LaptopApplication.DTO;

public class LaptopRequestDto {
    private String model;
    private String manufacturer;
    private String buyerName;
    private String sellerName;
    private Long price;
    private String manufactureDate;
    private Long Password;
    private Boolean delevered;
    private String buyerEmail;
    private Long buyerMobile;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Long getPassword() {
        return Password;
    }

    public void setPassword(Long password) {
        Password = password;
    }

    public Boolean getDelevered() {
        return delevered;
    }

    public void setDelevered(Boolean delevered) {
        this.delevered = delevered;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public Long getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(Long buyerMobile) {
        this.buyerMobile = buyerMobile;
    }
}
