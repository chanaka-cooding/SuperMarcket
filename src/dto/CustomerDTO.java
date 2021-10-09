/*
 *
 *  *
 *  *  * --------------------------------------------------------------------------------------------------------------
 *  *  *  *  Copyright (c) Lahiru Chanaka. All rights reserved.
 *  *  *  *  Licensed under the SriLankan Information License. See License.txt in the project root for license information.
 *  *  *  *------------------------------------------------------------------------------------------------------------
 *  *
 *
 */

package dto;

/**
 * @author Lahiru Chanaka <chankalahiru69@gmail.com>
 * @since 10/9/2021
 */


public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private double salary; // Ctrl + Shift + Alt + T

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
