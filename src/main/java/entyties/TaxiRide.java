package entyties;

import dao.Identified;

public class TaxiRide implements Identified<Integer> {

  private Long id;
  private Street startAddress;
  private Street endAddress;
  private double km;
  private double coef;

  public TaxiRide() {
  }

  public TaxiRide(Street startAddress, Street endAddress, double km, double coef) {
    this.startAddress = startAddress;
    this.endAddress = endAddress;
    this.km = km;
    this.coef = coef;
  }

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public double getKm() {
    return km;
  }

  public void setKm(double km) {
    this.km = km;
  }

  public double getCoef() {
    return coef;
  }

  public void setCoef(double coef) {
    this.coef = coef;
  }

  @Override
  public String toString() {
    return "TaxiRide{" +
            "id=" + id +
            ", startAddress=" + startAddress +
            ", endAddress=" + endAddress +
            ", km=" + km +
            ", coef=" + coef +
            '}';
  }
}
