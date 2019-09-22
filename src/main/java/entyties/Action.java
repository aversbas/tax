package entyties;

public class Action {

    public Action() {
    }

    private Long id;
    private Double discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", discount=" + discount +
                '}';
    }
}
