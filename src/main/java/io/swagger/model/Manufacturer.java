package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Manufacturer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-25T18:13:38.547Z[GMT]")


public class Manufacturer   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("homePage")
  private String homePage = null;

  @JsonProperty("phone")
  private String phone = null;

  public Manufacturer name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(example = "ACME Corporation", required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Manufacturer homePage(String homePage) {
    this.homePage = homePage;
    return this;
  }

  /**
   * Get homePage
   * @return homePage
   **/
  @Schema(example = "https://www.acme-corp.com", description = "")
  
    public String getHomePage() {
    return homePage;
  }

  public void setHomePage(String homePage) {
    this.homePage = homePage;
  }

  public Manufacturer phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
   **/
  @Schema(example = "408-867-5309", description = "")
  
    public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Manufacturer manufacturer = (Manufacturer) o;
    return Objects.equals(this.name, manufacturer.name) &&
        Objects.equals(this.homePage, manufacturer.homePage) &&
        Objects.equals(this.phone, manufacturer.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, homePage, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Manufacturer {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    homePage: ").append(toIndentedString(homePage)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
