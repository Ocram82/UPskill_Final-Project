package pt.iscte.hospital.services;

import pt.iscte.hospital.entities.Nationality;

import java.util.List;

public interface NationalityService {
    List<Nationality> findAll();
}
