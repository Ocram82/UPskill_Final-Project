package pt.iscte.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.iscte.hospital.entities.Speciality;
import pt.iscte.hospital.repositories.SpecialityRepository;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public void addSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }
}