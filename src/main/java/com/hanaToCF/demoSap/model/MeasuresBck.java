package com.hanaToCF.demoSap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEASURESBACKUP")
public class MeasuresBck implements Serializable {
    /* spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
       spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
       permits supporting to non-standard tables name, i.e. lowercase or camelCase
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //requires IDENTITY automatic definition on HANA
    @Column(name = "`id`")
    private long id;
    @Column(name = "`thingId`", length = 32)
    private String thingId;
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
                ", thingId='" + thingId + '\'' +
                ", pst='" + pst + '\'' +
                ", measurement='" + measurement + '\'' +
                ", time=" + time +
                ", value=" + value +
                '}';
    }

}