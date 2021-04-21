package com.example.office.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperatingSystem {
    public enum OSType {
        WINDOWS,
        UBUNTU
    }

    public static final String[] WINDOWS_VERSIONS = { "8.1", "10" };
    public static final String[] UBUNTU_VERSIONS = { "16.4", "18.4", "20.4" };

    @Enumerated(EnumType.STRING)
    private OSType osType;

    private String version;
}
