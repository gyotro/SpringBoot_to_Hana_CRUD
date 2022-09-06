package com.hanaToCF.demoSap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MEASURESB")
public class Measures {

    /* spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
       spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
       permits supporting to non-standard tables name, i.e. lowercase or camelCase
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //requires IDENTITY automatic definition on HANA
    /*
    Remember to put backticks before and after "name" in @Column
     */
    @Column(name = "`id`")
    private long id;
    @Column(name = "`thing`", length = 32)
    private String thing;
    @Column(name = "`pst`", length = 125)
    private String pst;
    @Column(name = "`measurement`", length = 125)
    private String measurement;
    @Column(name = "`time`")
    private Date time;
    @Column(name = "`value`")
    private Float value;

    @Override
    public String toString() {
        return "Measures{" +
                "id=" + id +
                ", thing='" + thing + '\'' +
                ", pst='" + pst + '\'' +
                ", measurement='" + measurement + '\'' +
                ", time=" + time +
                ", value=" + value +
                '}';
    }
}