package com.appointment.doctor_appointment.admin;

import com.appointment.doctor_appointment.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menu")
public class Menu extends BaseEntity {

    private String name;
    private String path;
    private String icon;
}
