package entyties;

public class Booking {
    private Long id;
    private User user;
    private Street startAddress;
    private Street endAddress;
    private Taxi taxi;
    private UserAction action;
    private Double price;

    public Booking() {
    }

    public Booking(User user, Street startAddress, Street endAddress, Taxi taxi, UserAction action, Double price) {
        this.user = user;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.taxi = taxi;
        this.action = action;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Street getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(Street startAddress) {
        this.startAddress = startAddress;
    }

    public Street getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(Street endAddress) {
        this.endAddress = endAddress;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public UserAction getAction() {
        return action;
    }

    public void setAction(UserAction action) {
        this.action = action;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
